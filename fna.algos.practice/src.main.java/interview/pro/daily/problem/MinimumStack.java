package interview.pro.daily.problem;

import java.util.*;

public class MinimumStack {
	
	private static class MinStack {
		private Deque<Integer> values;
		private int min;
		
		public MinStack() {
			values = new LinkedList<>();
			min =  Integer.MAX_VALUE;
		}
		
		public void push(int x) {
			if(x <= min) {
				values.push(min);
				min = x;
			}
			values.push(x);
		}
		
		public void pop() {
			int val = values.pop();
			if(val == min) {
				min = values.pop();
			}
		}
		
		public int peek() {
			return values.peek();
		}
		
		public int min() { 
			return min;
		}
	}
	
	public static void main(String[] args) {
		MinStack s = new MinStack();
		s.push(-2);
		s.push(0);
		s.push(-3);
		System.out.println(s.min());
		s.pop();
		System.out.println(s.peek());
		System.out.println(s.min());
	}
	
}
