package com.vitgon.collections;

public class Stack<E> {
	
	private Object[] stack;
	private int size;
	
	public Stack() {
		this(10);
	}
	
	public Stack(int capacity) {
		stack = new Object[capacity];
	}
	
	public void push(E item) {
		stack[size++] = item;
	}
	
	@SuppressWarnings("unchecked")
	public E pop() {
		E obj = (E) stack[size-1];
		stack[--size] = null;
		return obj;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
}
