package pc.ds.arrays.stack.nestedObjects;

import java.util.Stack;

public class DecodeString {

	/**
	 * Given an encoded string, return it's decoded string.
	 * 
	 * The encoding rule is: k[encoded_string], where the encoded_string inside
	 * the square brackets is being repeated exactly k times. Note that k is
	 * guaranteed to be a positive integer.
	 * 
	 * You may assume that the input string is always valid; No extra white
	 * spaces, square brackets are well-formed, etc.
	 * 
	 * Furthermore, you may assume that the original data does not contain any
	 * digits and that digits are only for those repeat numbers, k. For example,
	 * there won't be input like 3a or 2[4].
	 * 
	 * Examples:
	 * 
	 * s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return "accaccacc". s
	 * = "2[abc]3[cd]ef", return "abcabccdcdcdef".
	 **/

	// https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack
	public static String decodeString_01(String s) {
		String res = "";
		Stack<Integer> countStack = new Stack<>();
		Stack<String> resStack = new Stack<>();
		int idx = 0;
		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int count = 0;
				while (Character.isDigit(s.charAt(idx))) {
					count = 10 * count + (s.charAt(idx) - '0');
					idx++;
				}
				countStack.push(count);
			} else if (s.charAt(idx) == '[') {
				resStack.push(res);
				res = "";
				idx++;
			} else if (s.charAt(idx) == ']') {
				StringBuilder temp = new StringBuilder(resStack.pop());
				int repeatTimes = countStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(res);
				}
				res = temp.toString();
				idx++;
			} else {
				res += s.charAt(idx++);
			}
		}
		return res;
	}

	// https://leetcode.com/problems/decode-string/discuss/87543/0ms-simple-C%2B%2B-solution
	public static String decodeString_02(String s, int i) {
		String res = "";

		while (i < s.length() && s.charAt(i) != ']') {
			if (!Character.isDigit(s.charAt(i)))
				res += s.charAt(i++);
			else {
				int n = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i)))
					n = n * 10 + s.charAt(i++) - '0';

				i++; // '['
				String t = decodeString_02(s, i);
				i++; // ']'

				while (n-- > 0)
					res += t;
			}
		}

		return res;
	}

	public static String decodeString_02(String s) {
		int i = 0;
		return decodeString_02(s, i);
	}

	public static void main(String[] args) {
		String s = "3[a2[c]]"; // "accaccacc"
		System.out.print(decodeString_01(s));
	}
}
