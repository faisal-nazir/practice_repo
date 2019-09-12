package com.epi.stacksandqueues;

import java.util.*;

public class ParanthesisWellformedness {

	// EPI-9.3: Test string over "(,),{,},[,]" well-formedness
	
	public static boolean isValid(String str) {
		Deque<Character> stack = new LinkedList<>();
		
		for(char c : str.toCharArray()) {
			if(c == '(') {
				stack.push(')');
			} else if (c == '{') {
				stack.push('}');
			} else if (c == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.peek() != c) {
				return false;
			} 
		}
		return stack.isEmpty();
	}
}
