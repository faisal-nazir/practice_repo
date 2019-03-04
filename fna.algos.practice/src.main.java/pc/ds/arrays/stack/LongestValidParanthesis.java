package pc.ds.arrays.stack;

import java.util.Stack;

public class LongestValidParanthesis {

	/**
	 * Given a string containing just the characters '(' and ')', find the
	 * length of the longest valid (well-formed) parentheses substring.
	 * 
	 * Example 1:
	 * 
	 * Input: "(()" Output: 2 Explanation: The longest valid parentheses
	 * substring is "()" Example 2:
	 * 
	 * Input: ")()())" Output: 4 Explanation: The longest valid parentheses
	 * substring is "()()"
	 **/

	// https://leetcode.com/articles/longest-valid-parentheses/
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else if (!stack.empty() && stack.peek() == '(') {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.empty();
	}

	// Approach 1: Brute Force
	// Time: O(n3) Space: O(n)
	public int longestValidParentheses_01(String s) {
		int maxlen = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 2; j <= s.length(); j += 2) {
				if (isValid(s.substring(i, j))) {
					maxlen = Math.max(maxlen, j - i);
				}
			}
		}
		return maxlen;
	}

	// Approach 2: Using Dynamic Programming
	// Time: O(n) Space: O(n)
	public int longestValidParentheses_02(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0
						&& s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1]
							+ ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0)
							+ 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}

	// Approach 3: Using Stack
	// Time: O(n) Space: O(n)
	public int longestValidParentheses_03(String s) {
		int maxans = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}
		return maxans;
	}

	// Approach 4: Without extra space
	// Time complexity : O(n). Two traversals of the string.
	// Space complexity : O(1). Only two extra variables left and
	// right are needed.
	public int longestValidParentheses_04(String s) {
		int left = 0, right = 0, maxlength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * right);
			} else if (right >= left) {
				left = right = 0;
			}
		}
		left = right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * left);
			} else if (left >= right) {
				left = right = 0;
			}
		}
		return maxlength;
	}

}
