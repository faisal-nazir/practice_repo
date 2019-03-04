package pc.ds.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. empty() -- Return whether the stack
 * is empty. Example:
 * 
 * MyStack stack = new MyStack();
 * 
 * stack.push(1); stack.push(2); stack.top(); // returns 2 stack.pop(); //
 * returns 2 stack.empty(); // returns false Notes:
 * 
 * You must use only standard operations of a queue -- which means only push to
 * back, peek/pop from front, size, and is empty operations are valid. Depending
 * on your language, queue may not be supported natively. You may simulate a
 * queue by using a list or deque (double-ended queue), as long as you use only
 * standard operations of a queue. You may assume that all operations are valid
 * (for example, no pop or top operations will be called on an empty stack).
 **/

public class ImplementStackUsingQueue {

	// https://leetcode.com/articles/implement-stack-using-queues/
	public static class Stack<E> {
		Queue<E> q;

		public Stack() {
			this.q = new LinkedList<E>();
		}

		// Push element x onto stack.
		public void push(E x) {
			q.add(x);
			for (int i = 0; i < q.size() - 1; i++) {
				q.add(q.poll());
			}
		}

		// Removes the element on top of the stack.
		public E pop() {
			return q.poll();
		}

		// Get the top element.
		public E top() {
			return q.peek();
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return q.isEmpty();
		}
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.pop();
		while (!s.empty()) {
			System.out.println(s.pop());
		}
	}
}
