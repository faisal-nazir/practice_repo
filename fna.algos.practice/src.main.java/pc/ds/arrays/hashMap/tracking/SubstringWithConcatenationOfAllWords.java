package pc.ds.arrays.hashMap.tracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

	/**
	 * You are given a string, s, and a list of words, words, that are all of
	 * the same length. Find all starting indices of substring(s) in s that is a
	 * concatenation of each word in words exactly once and without any
	 * intervening characters.
	 * 
	 * Example 1:
	 * 
	 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
	 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and
	 * "foobar" respectively. The output order does not matter, returning [9,0]
	 * is fine too. Example 2:
	 * 
	 * Input: s = "wordgoodgoodgoodbestword", words =
	 * ["word","good","best","word"] Output: []
	 **/

	// https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13658/Easy-Two-Map-Solution-(C%2B%2BJava)
	// O(mn) time complexity. 'n' is size of string s, and 'm' is length of word len. Thanks for sharing, seems Leetcode is OK with O(mn) solution here.
	public static List<Integer> findSubstring(String s, String[] words) {
		final Map<String, Integer> counts = new HashMap<>();
		for (final String word : words) {
			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}
		final List<Integer> indexes = new ArrayList<>();
		final int n = s.length(), num = words.length, len = words[0].length();
		for (int i = 0; i < n - num * len + 1; i++) {
			// Read More
			// Consider this case
			// a) s.length = 10 -->(0-9 indexes) and
			// b) given words[] = {"aa", "aa", "aa"}....
			// c) The total length of substring is (3 words * 2 char len each) =
			// 6.
			//
			// So when searching for subString in 's' the window should contain
			// at least 6 chars.
			// So possible start positions of subString in 's' are 0,1,2,3,4
			// only. From 5th position, there are only 5 chars or less to
			// search...
			// So no point searching sections of 's' which have insufficient
			// number of chars to required to find the subString
			// +1 is required because array indexes start from 0 and not 1... an
			// array of length 5 has index 0-4

			final Map<String, Integer> seen = new HashMap<>();
			int j = 0;
			while (j < num) {
				final String word = s.substring(i + j * len, i + (j + 1) * len);
				// Lets consider words of length = 3
				// then the above start and end indices will like multiplication table of 3
				// Like for j = 0, start index will be (0*3) = 0 and End Index will be (1*3) = 3
				// for j = 1, start index will be (1*3) = 3 and End Index will be (2*3) = 6 and so on.
				if (counts.containsKey(word)) {
					seen.put(word, seen.getOrDefault(word, 0) + 1);
					if (seen.get(word) > counts.getOrDefault(word, 0)) {
						break;
					}
				} else {
					break;
				}
				j++;
			}
			if (j == num) {
				indexes.add(i);
			}
		}
		return indexes;
	}

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = { "bar", "foo" };
		List<Integer> res = findSubstring(s, words);
	}
}
