package myCollectionsImpl;

import java.util.Iterator;

public class ArrayList<E> implements Iterable<E> {
	
	private static final int INITIAL_CAPACITY = 2;
	private Object[] elementData;
	private int size;
	
	ArrayList () {
		elementData = new Object[INITIAL_CAPACITY];
	}
	
	public boolean add(E name) {
		rangeCheck(size + 1);
		elementData[size++] = name;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		return (E) elementData[index];
	}
	
	@SuppressWarnings("unchecked")
	public void printAll() {
		for (E el : (E[]) elementData) {
			System.out.println(el);
		}
	}
	
	private void rangeCheck(int minCapacity) {
		if (minCapacity - elementData.length > 0)
			grow();
	}
	
	// increase by half of elementData capacity
	private void grow() {
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		Object[] expElementData = new Object[newCapacity];
		System.arraycopy(elementData, 0, expElementData, 0, size);
		elementData = expElementData;
	}
	
	public void remove(int index) {
		int numMoved = size - (index+1);
		if (numMoved > 0)
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
		elementData[--size] = null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}
	
	private class Itr implements Iterator<E> {
		int cursor;
		
		Itr() { }

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		@SuppressWarnings("unchecked")
		public E next() {
			if (cursor >= elementData.length)
				throw new NoSuchElementException("There are no more elements");
			return (E) elementData[cursor++];
		}
	}
}
