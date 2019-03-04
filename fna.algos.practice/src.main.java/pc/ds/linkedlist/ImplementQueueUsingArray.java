package pc.ds.linkedlist;

public class ImplementQueueUsingArray {

	public static class Queue<E> {
		E[] elements;
		int head = 0;
		int tail = 0;
		int size = 0;
		
		@SuppressWarnings("unchecked")
		public Queue(int capacity) {
			elements = (E[]) new Object[capacity];
		}
		
		public boolean add(E item) {
			if(elements.length == size) return false;
			elements[tail] = item;
			tail = (tail+1) % elements.length;
			++size;
			return true;
		}
		
		public E poll() {
			if(size == 0) return null;
			E result = elements[head];
			elements[head] = null;
			head = (head + 1) % elements.length;
			--size;
			return result;
		}
		
		public E peek() {
			if(size == 0) return null;
			return elements[head];
		}
	}
}
