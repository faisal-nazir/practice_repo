package com.epi.stacksandqueues;

import java.util.*;

public class EvaluateRPNExpression {

	public static int evalRPN(String exp) {
		Deque<Integer> stack = new LinkedList<>();
		String delim = ",";
		String[] tokens = exp.split(delim);
		for(String token: tokens) {
			if(token.length() == 1 && "+-*/".contains(token)) {
				int y = stack.pop();
				int x = stack.pop();
				switch(token.charAt(0)) {
				case '/':
					stack.push(x/y);
					break;
				case '*':
					stack.push(x/y);
					break;
				case '-':
					stack.push(x/y);
					break;
				case '+':
					stack.push(x/y);
					break;
				default:
					throw new IllegalArgumentException("Malformed RPN at : " + token);
				}
			} else {
				stack.push(Integer.parseInt(token));
			} 
		}
		return stack.pop();
	}
}
