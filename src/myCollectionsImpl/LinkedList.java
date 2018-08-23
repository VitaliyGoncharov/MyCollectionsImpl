package myCollectionsImpl;

public class LinkedList<E> {
	int size = 0;
	Node<E> first;
	Node<E> last;
	
	private static class Node<E> {
		E item;
		Node<E> prev;
		Node<E> next;
		
		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.prev = prev;
			this.next = next;
		}
	}
	
	public void add(E element) {
		final Node<E> l = last;
		Node<E> newNode = new Node<E>(l, element, null);
		last = newNode;
		
		if (l == null)
			first = newNode;
		else
			l.next = newNode;
		
		size++;
	}
	
	public E get(int index) {
		checkElementIndex(index);
		return getNode(index).item;
	}
	
	public void printAll() {
		Node<E> x = first;
		for (int i = 0; i < size; i++) {
			System.out.println(x.item);
			x = x.next;
		}
	}
	
	private Node<E> getNode(int index) {
		if (index < (size >> 1)) {
			Node<E> x = first;
			for (int i = 0; i < index; i++)
				x = x.next;
			return x;
		}
		else {
			Node<E> x = last;
			for (int i = size - 1; i > index; i--)
				x = x.prev;
			return x;		
		}
	}
	
	public void remove(int index) {
		checkElementIndex(index);
		unlink(getNode(index));
	}
	
	private E unlink(Node<E> x) {
		final E element = x.item;
		final Node<E> prev = x.prev;
		final Node<E> next = x.next;
		
		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			x.prev = null;
		}
		
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}
		
		x.item = null;
		size--;
		return element;
	}
	
	private void checkElementIndex(int index) {
		if (!isElementIndex(index))
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
	}
	
	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size > 0;
	}
}
