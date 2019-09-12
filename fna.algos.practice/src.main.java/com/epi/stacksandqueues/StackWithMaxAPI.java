package com.epi.stacksandqueues;

import java.util.*;

public class StackWithMaxAPI {
	
	// EPI-9.1: Implement a stack with max API

	public static class MaxStack {
		int max = Integer.MIN_VALUE;
		Deque<Integer> stack = new LinkedList<>();
		
		void push(int x) {
			if(x >= max) {
				stack.push(max);
				max = x;
			}
			stack.push(x);
		}
		
		int pop() {
			int top = stack.pop();
			if(top == max)
				max = stack.pop();
			return top;
		}
		
		int peek() {
			return stack.peek();
		}
		
		int max() {
			return max;
		}
	}
}
