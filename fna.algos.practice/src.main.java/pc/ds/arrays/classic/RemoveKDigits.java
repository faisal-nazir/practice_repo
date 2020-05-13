package pc.ds.arrays.classic;

import java.util.Deque;
import java.util.LinkedList;



public class RemoveKDigits {

	/**
	 * Given a non-negative integer num represented as a string, remove k digits
	 * from the number so that the new number is the smallest possible.
	 * 
	 * Note: The length of num is less than 10002 and will be >= k. The given
	 * num does not contain any leading zero. Example 1:
	 * 
	 * Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove the
	 * three digits 4, 3, and 2 to form the new number 1219 which is the
	 * smallest. Example 2:
	 * 
	 * Input: num = "10200", k = 1 Output: "200" Explanation: Remove the leading
	 * 1 and the number is 200. Note that the output must not contain leading
	 * zeroes. Example 3:
	 * 
	 * Input: num = "10", k = 2 Output: "0" Explanation: Remove all the digits
	 * from the number and it is left with nothing which is 0.
	 **/

	// https://leetcode.com/problems/remove-k-digits/discuss/88678/Two-algorithms-with-detailed-explaination
	// O(k*n)time
	public static String removeKdigits_01(String num, int k) {
		StringBuilder sb = new StringBuilder(num);

		while (k > 0) {
			int n = sb.length() - 1;
			int i = 0;
			while (i < n && sb.charAt(i) <= sb.charAt(i + 1))
				i++;
//			sb.delete(i, i + 1);
			sb.deleteCharAt(i);
			k--;
		}
		// trim leading zeros
		int s = 0;
		while (s < sb.length() - 1 && sb.charAt(s) == '0')
			s++;
		sb.delete(0, s);

		return (sb.length() == 0) ? "0" : sb.toString();
	}

	// https://leetcode.com/problems/remove-k-digits/discuss/88660/A-greedy-method-using-stack-O(n)-time-and-O(n)-space
	public static String removeKdigits_02(String num, int k) {
		int digits = num.length() - k;
		char[] stk = new char[num.length()];
		int top = 0;
		// k keeps track of how many characters we can remove
		// if the previous character in stk is larger than the current one
		// then removing it will get a smaller number
		// but we can only do so when k is larger than 0
		for (int i = 0; i < num.length(); ++i) {
			char c = num.charAt(i);
			while (top > 0 && stk[top - 1] > c && k > 0) {
				top -= 1;
				k -= 1;
			}
			stk[top++] = c;
		}
		// find the index of first non-zero digit
		int idx = 0;
		while (idx < digits && stk[idx] == '0')
			idx++;
		return idx == digits ? "0" : new String(stk, idx, digits - idx);
	}

	public static void main(String[] args) {
		String s = "1432219"; //234 //134 // 124 // 123
		System.out.print(removeKdigits(s, 3));
	}
	
	private static String removeKdigits(String num, int k) {
		Deque<Character> s = new LinkedList<>();
		char[] A = num.toCharArray();
		
		// remove peak elements
		for(int i = 0; i < A.length; ++i) {
			char c  = A[i];
			while(k > 0 && s.size() > 0 && s.peek() > c ) {
				s.pop();
				--k;
			}
			s.push(c);
		}
		
		// convert stack entries to string
		StringBuilder sb = new StringBuilder();
		while(!s.isEmpty()) {
			sb.insert(0, s.pop());
		}
		
		// remove leading zeros
		int i = 0;
		while(i < sb.length() && sb.charAt(i) == '0') {
			++i;
		}
		sb.delete(0, i);
		
		return (sb.length() == 0) ? "0" : sb.toString(); 
	}
}
