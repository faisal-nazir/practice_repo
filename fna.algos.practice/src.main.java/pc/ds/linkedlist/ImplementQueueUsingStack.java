package pc.ds.linkedlist;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element
 * from in front of queue. peek() -- Get the front element. empty() -- Return
 * whether the queue is empty. Example:
 * 
 * MyQueue queue = new MyQueue();
 * 
 * queue.push(1); queue.push(2); queue.peek(); // returns 1 queue.pop(); //
 * returns 1 queue.empty(); // returns false Notes:
 * 
 * You must use only standard operations of a stack -- which means only push to
 * top, peek/pop from top, size, and is empty operations are valid. Depending on
 * your language, stack may not be supported natively. You may simulate a stack
 * by using a list or deque (double-ended queue), as long as you use only
 * standard operations of a stack. You may assume that all operations are valid
 * (for example, no pop or peek operations will be called on an empty queue).
 **/
public class ImplementQueueUsingStack {

	// https://leetcode.com/articles/implement-queue-using-stacks/
	public static class Queue<E> {
		private Stack<E> s1;
		private Stack<E> s2;
		private E front;

		public Queue() {
			s1 = new Stack<E>();
			s2 = new Stack<E>();
		}

		public void add(E e) {
			if (s1.isEmpty()) {
				front = e;
			}
			s1.add(e);
		}

		public E remove() {
			if (s2.isEmpty()) {
				while (!s1.isEmpty()) {
					s2.push(s1.pop());
				}
			}
			return s2.pop();
		}

		public E peek() {
			if (!s2.isEmpty())
				return s2.peek();
			return front;
		}

		public boolean empty() {
			return s1.isEmpty() && s2.isEmpty();
		}
	}

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.remove());
		q.add(4);
		while (!q.empty()) {
			System.out.println(q.remove());
		}
	}

}
