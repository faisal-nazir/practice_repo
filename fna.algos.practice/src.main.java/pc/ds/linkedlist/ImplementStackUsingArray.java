package pc.ds.linkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ImplementStackUsingArray {

	public static class Stack<E> {

		private E[] elements;
		private int size = 0;
		private static final int DEFAULT_INITIAL_CAPACITY = 16;

		@SuppressWarnings("unchecked")
		public Stack() {
			elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
		}

		public void push(E item) {
			ensureCapacity();
			elements[size++] = item;
		}
		
		public E pop() {
			if(size <= 0) {
				throw new NoSuchElementException();
			} 
			E result = (E) elements[--size];
			elements[size] = null;
			return result;
		} 
		
		public E peek() {
			return (size > 0) ? elements[size-1] : null;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public int size() {
			return (size > 0) ? size - 1 : 0;
		}
		
		private void ensureCapacity() {
			if(elements.length == size) 
				elements = Arrays.copyOf(elements, size * 2 + 1);
		}
	}
}
