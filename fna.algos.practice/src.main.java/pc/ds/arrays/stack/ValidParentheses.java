package pc.ds.arrays.stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

	/**
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * An input string is valid if:
	 * 
	 * Open brackets must be closed by the same type of brackets. Open brackets
	 * must be closed in the correct order. Note that an empty string is also
	 * considered valid.
	 **/
	// https://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/
	public static boolean isValid(String s) {

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);

			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}


		return stack.empty();
	}

	// https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution
	public boolean isValid_02(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
