package myCollectionsImpl;

import java.util.Objects;

public class HashMap<K,V> {
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	static final int MAXIMUM_CAPACITY = 1 << 30;

	final float loadFactor;
	
	Entry[] table;
	
	int size; 
	
	// The next size value at which to resize (capacity * load factor)
	int threshold;
	
	HashMap() {
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
		table = new Entry[DEFAULT_INITIAL_CAPACITY];
	}
	
	public V put(K key, V value) {
		int hash = hash(key);
		int i = indexFor(hash, table.length);
		for (Entry<K,V> e  = table[i]; e != null; e = e.next) {
			Object k;
			if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
				V oldValue = e.value;
				e.value = value;
				return oldValue;
			}
		}
		addEntry(hash, key, value, i);
		return null;
	}
	
	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
	
	static int indexFor(int h, int length) {
		return h & (length -1);
	}
	
	static class Entry<K,V> {
		final K key;
		V value;
		Entry<K,V> next;
		final int hash;
		
		Entry(int h, K k, V v, Entry<K,V> n) {
			value = v;
			next = n;
			key = k;
			hash = h;
		}
		
		public final K getKey() 		{ return key; }
		public final V getValue() 		{ return value; }
		public final String toString() 	{ return key + "=" + value; }
		
		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}
		
		public final int hashCode() {
			return (key == null ? 0 : key.hashCode()) ^
					(value == null ? 0 : value.hashCode());
		}
		
		@SuppressWarnings("rawtypes")
		public final boolean equals(Object o) {
			if (o == this)
				return true;
			if (!(o instanceof HashMap.Entry))
				return false;

			HashMap.Entry e = (HashMap.Entry) o;
			Object k1 = getKey();
			Object k2 = e.getKey();
			
			if (k1 == k2 || (k1 != null && k1.equals(k2))) {
				Object v1 = getValue();
				Object v2 = e.getValue();
				
				if (v1 == v2 || (v1 != null && v1.equals(v2))) {
					return true;
				}
			}
			
			return false;
		}
	}
	
	void addEntry(int hash, K key, V value, int bucketIndex) {
		Entry<K,V> e = table[bucketIndex];
		table[bucketIndex] = new Entry<>(hash, key, value, e);
		if (size++ >= threshold)
			resize(table.length * 2);
	}
	
	@SuppressWarnings("rawtypes")
	void resize(int newCapacity) {
		Entry[] oldTable = table;
		int oldCapacity = oldTable.length;
		if (oldCapacity == MAXIMUM_CAPACITY) {
			threshold = Integer.MAX_VALUE;
			return;
		}
		
		Entry[] newTable = new Entry[newCapacity];
		transfer(newTable);
		table = newTable;
		threshold = (int) (newCapacity * loadFactor);
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	void transfer(Entry[] newTable) {
		Entry[] src = table;
		int newCapacity = newTable.length;
		for (int j = 0; j < src.length; j++) {
			Entry<K,V> e = src[j];
			if (e != null) {
				src[j] = null;
				do {
					Entry<K,V> next = e.next;
					int i = indexFor(e.hash, newCapacity);
					e.next = newTable[i];
					newTable[i] = e;
					e = next;
				} while (e != null);
			}
		}
	}
}
