package interview.pro.daily.problem;

import java.util.*;

public class MinimumRemovalsforValidParenthesis {

	public static int minRemovals(String s) {
		if(s == null || s.length() == 0) return 0;
		Deque<Character> stack = new LinkedList<>();
		
		for(char c : s.toCharArray()) {
			if( c == '(') {
				stack.push(c);
			} else if( c == ')') {
				if(stack.size() > 0 && stack.peek() == '(')
					stack.pop();
				else 
					stack.push(c);
			} else {
				throw new IllegalArgumentException("Not a valid character" + c);
			}
		}
		
		return stack.size();
	}
	
	public static void main(String[] args) {
		String input = "))(((()()())";
		System.out.println(minRemovals(input));
		System.out.println(minAddToMakeValid(input));
	}
	
	//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/discuss/181132/C%2B%2BJavaPython-Straight-Forward-One-Pass	

	
	/* Intuition:
		To make a string valid,
		we can add some ( on the left,
		and add some ) on the right.
		We need to find the number of each.
		
		
		Explanation:
		left records the number of ( we need to add on the left of S.
		right records the number of ) we need to add on the right of S,
		which equals to the number of current opened parentheses.
		
		
		Loop char c in the string S:
		if (c == '('), we increment right,
		if (c == ')'), we decrement right.
		When right is already 0, we increment left
		Return left + right in the end
		
		
		Time Complexity:
		Time O(N)
		Space O(1)
		
	*/
	public static int minAddToMakeValid(String s) {
		int left = 0, right = 0;
		for(char c : s.toCharArray()) {
			if(c == '(') {
				++right;
			} else if(right > 0) {
				--right;
			} else {
				left++;
			}
		}
		return left+right;
	}
}
