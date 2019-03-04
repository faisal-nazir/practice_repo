package pc.ds.arrays.twoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IsSubSequence {

	/***
	 * Given a string s and a string t, check if s is subsequence of t.
	 * 
	 * You may assume that there is only lower case English letters in both s
	 * and t. t is potentially a very long (length ~= 500,000) string, and s is
	 * a short string (<=100).
	 * 
	 * A subsequence of a string is a new string which is formed from the
	 * original string by deleting some (can be none) of the characters without
	 * disturbing the relative positions of the remaining characters. (ie, "ace"
	 * is a subsequence of "abcde" while "aec" is not).
	 * 
	 * Example 1: s = "abc", t = "ahbgdc"
	 * 
	 * Return true.
	 * 
	 * Example 2: s = "axc", t = "ahbgdc"
	 * 
	 * Return false.
	 * 
	 * Follow up: If there are lots of incoming S, say S1, S2, ... , Sk where k
	 * >= 1B, and you want to check one by one to see if T has its subsequence.
	 * In this scenario, how would you change your code?
	 */

	// https://leetcode.com/problems/is-subsequence/discuss/87254/Straight-forward-Java-simple-solution
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;
		int indexS = 0, indexT = 0;
		while (indexT < t.length()) {
			if (t.charAt(indexT) == s.charAt(indexS)) {
				indexS++;
				if (indexS == s.length())
					return true;
			}
			indexT++;
		}
		return false;
	}

	// https://leetcode.com/problems/is-subsequence/discuss/87302/Binary-search-solution-for-follow-up-with-detailed-comments
	// Follow-up: O(N) time for pre-processing, O(Mlog?) for each S.
	// Eg-1. s="abc", t="bahbgdca"
	// idx=[a={1,7}, b={0,3}, c={6}]
	// i=0 ('a'): prev=1
	// i=1 ('b'): prev=3
	// i=2 ('c'): prev=6 (return true)
	// Eg-2. s="abc", t="bahgdcb"
	// idx=[a={1}, b={0,6}, c={5}]
	// i=0 ('a'): prev=1
	// i=1 ('b'): prev=6
	// i=2 ('c'): prev=? (return false)
	public static boolean isSubsequence_02(String s, String t) {
		List<Integer>[] idx = new List[26]; // Just for clarity
		for (int i = 0; i < t.length(); i++) {
			if (idx[getIndex(t.charAt(i))] == null)
				idx[getIndex(t.charAt(i))] = new ArrayList<>();
			idx[getIndex(t.charAt(i))].add(i);
		}

		int prev = 0;
		for (int i = 0; i < s.length(); i++) {
			if (idx[getIndex(s.charAt(i))] == null)
				return false; // Note: char of S does NOT exist in T causing NPE
			int j = Collections.binarySearch(idx[getIndex(s.charAt(i))], prev);
			if (j < 0)
				j = -j - 1;
			if (j == idx[getIndex(s.charAt(i))].size())
				return false;
			prev = idx[getIndex(s.charAt(i))].get(j) + 1;
		}
		return true;
	}

	// The prev variable is an index where previous character was picked from
	// the sequence. And for the next character to be picked, you have to select
	// it only after this index is the string 'T'.

	// For instance, if S = "abcd" and T = "abdced".
	// The index list mapping looks like,
	//
	// a -> 0
	// b -> 1
	// c -> 3
	// d -> 2,5
	// e -> 4
	// After you pick a, and b, c will be picked, and index is 3. Now if you
	// have to pick d, you can't pick index 2 because c was picked at 3, so you
	// have to binary search for index which comes after 3. So it returns 5.

	public static int getIndex(char c) {
		return c - 'a';
	}

	public static void main(String[] args) {
		System.out.println(isSubsequence_02("abc", "bahgdcb"));
	}

	public static boolean isSubsequence_03(String s, String t) {
		int index = -1;
		for (char c : s.toCharArray()) {
			index = t.indexOf(c, index + 1);
			if (index == -1)
				return false;
		}
		return true;
	}
}
