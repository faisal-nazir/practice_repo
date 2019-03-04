package pc.ds.arrays.dfs;

import java.util.Arrays;

public class WildCardMatching {

	/**
	 * Given an input string (s) and a pattern (p), implement wildcard pattern
	 * matching with support for '?' and '*'.
	 * 
	 * '?' Matches any single character. '*' Matches any sequence of characters
	 * (including the empty sequence). The matching should cover the entire
	 * input string (not partial).
	 * 
	 * Note:
	 * 
	 * s could be empty and contains only lowercase letters a-z. p could be
	 * empty and contains only lowercase letters a-z, and characters like ? or
	 * *. Example 1:
	 * 
	 * Input: s = "aa" p = "a" Output: false 
	 * Explanation: "a" does not match the entire string "aa".
	 * Example 2:
	 * 
	 * Input: s = "aa" p = "*" Output: true Explanation: '*' matches any
	 * sequence.
	 */

	// https://leetcode.com/problems/wildcard-matching/discuss/17810/Linear-runtime-and-constant-space-solution
	// complexity is O(M*N) not linear - see the worst case below
	// String s = "aaaaaaaaaaaaa";
	// String p = "*aaab";
	// see the analysis with example at
	// http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
	public static boolean comparison(String str, String pattern) {
		int s = 0, p = 0, match = 0, starIdx = -1;
		while (s < str.length()) {
			// advancing both pointers
			if (p < pattern.length()
					&& (pattern.charAt(p) == '?' || str.charAt(s) == pattern
							.charAt(p))) {
				s++;
				p++;
			}
			// * found, only advancing pattern pointer
			else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starIdx = p;
				match = s;
				p++;
			}
			// we have seen an * before, advancing string pointer
			else if (starIdx != -1) {
				p = starIdx + 1;
				match++;
				s = match;
			}
			// current pattern pointer is not star, last patter pointer was not
			// *
			// characters do not match
			else
				return false;
		}

		// check for remaining characters in pattern
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;

		return p == pattern.length();
	}

	// https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/WildCardMatching.java
	// bottom up DP solution
	// O(m*n) Time and Space complexity
	// sample DP example: s = "xaylmz" , p = "x?y*z";
	public boolean isMatch(String s, String p) {
		char[] str = s.toCharArray();
		char[] pattern = p.toCharArray();

		// replace multiple * with one *
		// e.g a**b***c --> a*b*c
		int writeIndex = 0;
		boolean isFirst = true;
		for (int i = 0; i < pattern.length; i++) {
			if (pattern[i] == '*') {
				if (isFirst) {
					pattern[writeIndex++] = pattern[i];
					isFirst = false;
				}
			} else {
				pattern[writeIndex++] = pattern[i];
				isFirst = true;
			}
		}

		boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

		if (writeIndex > 0 && pattern[0] == '*') {
			T[0][1] = true;
		}

		T[0][0] = true;

		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					T[i][j] = T[i - 1][j] || T[i][j - 1];
				}
			}
		}

		return T[str.length][writeIndex];
	}

	// transformed form Laiq's leetcode submission
	public boolean isMatch_02(String s, String p) {
		int[][] memo = new int[s.length()][p.length()];
//		for (int[] row : memo)
//			Arrays.fill(row, -1);
		return isMatch(s.toCharArray(), p.toCharArray(), s.length() - 1,
				p.length() - 1, memo) > 0;
	}

//	boolean isMatch(char[] S, char[] P, int si, int pi, int[][] memo) {
//
//		if (si < 0) {
//			if (pi < 0)
//				return true;
//			if (P[pi] == '*')
//				return isMatch(S, P, si, pi - 1, memo);
//			return false;
//		}
//
//		if (pi < 0)
//			return false;
//
//		if (memo[si][pi] != -1)
//			return memo[si][pi] == 1;
//
//		if (P[pi] == '?' || P[pi] == S[si]) {
//			boolean res = isMatch(S, P, si - 1, pi - 1, memo);
//			memo[si][pi] = (res) ? 1 : 0;
//			return res;
//		}
//
//		if (P[pi] == '*') {
//			boolean res = isMatch(S, P, si - 1, pi, memo)
//					|| isMatch(S, P, si, pi - 1, memo);
//			memo[si][pi] = (res) ? 1 : 0;
//			return res;
//		}
//
//		return memo[si][pi] == 1;
//	}
	
	int isMatch(char[] S, char[] P, int si, int pi, int[][] memo) {

		if (si < 0) {
			if (pi < 0)
				return 1;
			if (P[pi] == '*')
				return isMatch(S, P, si, pi - 1, memo);
			return -1;
		}

		if (pi < 0)
			return -1;

		if (memo[si][pi] != 0)
			return memo[si][pi];

		if (P[pi] == '?' || P[pi] == S[si]) {
			memo[si][pi] =  isMatch(S, P, si - 1, pi - 1, memo);
			return memo[si][pi];
		}

		if (P[pi] == '*') {
			memo[si][pi] = (isMatch(S, P, si - 1, pi, memo) > 0) ? 1 :
				(isMatch(S, P, si, pi - 1, memo) > 0) ? 1 : -1;
			return memo[si][pi];
		}

		return memo[si][pi];
	}

	public static void main(String[] args) {
		String s = "abefcdgiescdfimde";
		String p = "ab*cd?i*de";
		System.out.print(comparison(s, p));
		
		System.out.println();
		
		WildCardMatching wc = new WildCardMatching();
		System.out.print(wc.isMatch_02(s, p));
	}
}
