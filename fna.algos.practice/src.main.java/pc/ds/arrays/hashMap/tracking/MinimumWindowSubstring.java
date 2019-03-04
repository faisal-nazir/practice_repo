package pc.ds.arrays.hashMap.tracking;

public class MinimumWindowSubstring {

	/**
	 * Given a string S and a string T, find the minimum window in S which will
	 * contain all the characters in T in complexity O(n).
	 * 
	 * Example:
	 * 
	 * Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC" Note:
	 * 
	 * If there is no such window in S that covers all characters in T, return
	 * the empty string "". If there is such window, you are guaranteed that
	 * there will always be only one unique minimum window in S.
	 **/

	// https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
	public static String minWindow(String s, String t) {
		int[] map = new int[128];
		for (char c : t.toCharArray())
			map[c]++;
		int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
		while (end < s.length()) {
			if (map[s.charAt(end++)]-- > 0)
				counter--; // in 't'
			while (counter == 0) { // valid
				if (end - begin < d)
					d = end - (head = begin);
				if (map[s.charAt(begin++)]++ == 0)
					counter++; // make it invalid
			}
		}
		return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.print(minWindow(s, t));
	}
}
