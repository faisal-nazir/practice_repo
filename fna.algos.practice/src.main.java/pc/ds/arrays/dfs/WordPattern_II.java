package pc.ds.arrays.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern_II {

	/**
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a
	 * letter in pattern and a non-empty substring in str.
	 * 
	 * Example 1:
	 * 
	 * Input: pattern = "abab", str = "redblueredblue" Output: true Example 2:
	 * 
	 * Input: pattern = pattern = "aaaa", str = "asdasdasdasd" Output: true
	 * Example 3:
	 * 
	 * Input: pattern = "aabb", str = "xyzabcxzyabc" Output: false Notes: You
	 * may assume both pattern and str contains only lowercase letters.
	 **/

	// https://leetcode.com/problems/word-pattern-ii/discuss/73664/Share-my-Java-backtracking-solution
	public boolean wordPatternMatch(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();

		return isMatch(str, 0, pattern, 0, map, set);
	}

	boolean isMatch(String str, int si, String pat, int pi,
			Map<Character, String> map, Set<String> set) {
		// base case
		if (si == str.length() && pi == pat.length())
			return true;
		if (si == str.length() || pi == pat.length())
			return false;

		// get current pattern character
		char c = pat.charAt(pi);

		// if the pattern character exists
		if (map.containsKey(c)) {
			String s = map.get(c);

			// then check if we can use it to match str[i...i+s.length()]
			if (!str.startsWith(s, si)) {
				return false;
			}

			// if it can match, great, continue to match the rest
			return isMatch(str, si + s.length(), pat, pi + 1, map, set);
		}

		// pattern character does not exist in the map
		for (int k = si; k < str.length(); k++) {
			String subStr = str.substring(si, k + 1);

			if (set.contains(subStr)) {
				continue;
			}

			// create or update it
			map.put(c, subStr);
			set.add(subStr);

			// continue to match the rest
			if (isMatch(str, k + 1, pat, pi + 1, map, set)) {
				return true;
			}

			// backtracking
			map.remove(c);
			set.remove(subStr);
		}

		// we've tried our best but still no luck
		return false;
	}
}
