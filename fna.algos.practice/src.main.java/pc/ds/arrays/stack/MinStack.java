package pc.ds.arrays.stack;

import java.util.Stack;

public class MinStack {

	/**
	 * Design a stack that supports push, pop, top, and retrieving the minimum
	 * element in constant time.
	 * 
	 * push(x) -- Push element x onto stack. pop() -- Removes the element on top
	 * of the stack. top() -- Get the top element. getMin() -- Retrieve the
	 * minimum element in the stack.
	 * 
	 * Example: MinStack minStack = new MinStack(); minStack.push(-2);
	 * minStack.push(0); minStack.push(-3); minStack.getMin(); --> Returns -3.
	 * minStack.pop(); minStack.top(); --> Returns 0. minStack.getMin(); -->
	 * Returns -2.
	 **/

	// https://www.programcreek.com/2014/02/leetcode-min-stack-java/
	static class Elem {
		public int value;
		public int min;
		public Elem next;

		public Elem(int value, int min) {
			this.value = value;
			this.min = min;
		}
	}

	// Storing min at each node.
	static class MinStack01 {
		public Elem top;

		/** initialize your data structure here. */
		public MinStack01() {

		}

		public void push(int x) {
			if (top == null) {
				top = new Elem(x, x);
			} else {
				Elem e = new Elem(x, Math.min(x, top.min));
				e.next = top;
				top = e;
			}

		}

		public void pop() {
			if (top == null)
				return;
			Elem temp = top.next;
			top.next = null;
			top = temp;

		}

		public int top() {
			if (top == null)
				return -1;
			return top.value;
		}

		public int getMin() {
			if (top == null)
				return -1;
			return top.min;
		}
	}

	public static void main(String[] args) {
		MinStack04 stack = new MinStack04();

		stack.push(3);
		stack.push(1);
		stack.push(2);

		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}

	// https://leetcode.com/problems/min-stack/discuss/49016/C++-using-two-stacks-quite-short-and-easy-to-understand
	// Using two stacks, one for values and another one for min values
	static class MinStack03 {
		private Stack<Integer> s1;
		private Stack<Integer> s2;

		public void push(int x) {
			s1.push(x);
			if (s2.empty() || x <= getMin())
				s2.push(x);
		}

		public void pop() {
			if (s1.peek() == getMin())
				s2.pop();
			s1.pop();
		}

		public int top() {
			return s1.peek();
		}

		public int getMin() {
			return s2.peek();
		}
	}

	// https://leetcode.com/problems/min-stack/discuss/49014/Java-accepted-solution-using-one-stack
	// same idea as above but with one stack,
	// if min is updated push the previous min to the stack,
	// if popped the current min, fall back to previous min via top value

	static class MinStack02 {
		int min = Integer.MAX_VALUE;
		Stack<Integer> stack = new Stack<Integer>();

		public void push(int x) {
			// only push the old minimum value when the current
			// minimum value changes after pushing the new value x
			if (x <= min) {
				stack.push(min);
				min = x;
			}
			stack.push(x);
		}

		public void pop() {
			// if pop operation could result in the changing of the current
			// minimum value,
			// pop twice and change the current minimum value to the last
			// minimum value.
			if (stack.pop() == min)
				min = stack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return min;
		}
	}

	// Constant memory solution
	// Store the differences b/w min and values
	// https://leetcode.com/problems/min-stack/discuss/49031/Share-my-Java-solution-with-ONLY-ONE-stack
	static class MinStack04 {
		long min;
		Stack<Long> stack;

		public MinStack04() {
			stack = new Stack<Long>();
		}

		public void push(int x) {
			if (stack.isEmpty()) {
				stack.push(0L);
				min = x;
			} else {
				stack.push(x - min);// Could be negative if min value needs to
									// change
				if (x < min)
					min = x;
			}
		}

		public void pop() {
			if (stack.isEmpty())
				return;

			long pop = stack.pop();

			if (pop < 0)
				min = min - pop;// If negative, increase the min value

		}

		public int top() {
			long top = stack.peek();
			if (top > 0) {
				return (int) (top + min);
			} else {
				return (int) (min);
			}
		}

		public int getMin() {
			return (int) min;
		}
	}
}
