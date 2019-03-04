package pc.ds.arrays.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern_I {

	/**
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a
	 * letter in pattern and a non-empty word in str.
	 * 
	 * Example 1:
	 * 
	 * Input: pattern = "abba", str = "dog cat cat dog" Output: true Example 2:
	 * 
	 * Input:pattern = "abba", str = "dog cat cat fish" Output: false Example 3:
	 * 
	 * Input: pattern = "aaaa", str = "dog cat cat dog" Output: false Example 4:
	 * 
	 * Input: pattern = "abba", str = "dog dog dog dog" Output: false Notes: You
	 * may assume pattern contains only lowercase letters, and str contains
	 * lowercase letters separated by a single space.
	 **/

	// Running with first case above:
	// put also returns the previously associated value
	// idea is to keep mapping values at same index
	// like ("a", 0) and ("dog", 0)
	// then ("b", 1) and ("cat", 1)
	// checking previously associated value 1 and then ("b", 2) and ("cat", 2)
	// checking previously associated value 0 and then ("a", 3) and ("dog", 3)
	// https://leetcode.com/problems/word-pattern/discuss/73402/8-lines-simple-Java
	public static boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map<String, Integer> index = new HashMap<>();
		for (Integer i = 0; i < words.length; ++i)
			if (index.put(String.valueOf(pattern.charAt(i)), i) != index.put(
					words[i], i))
				return false;
		return true;
	}

	public static void main(String[] args) {
		String s = "dog cat cat dog";
		String p = "abba";

		System.out.print(wordPattern(p, s));
	}

	// https://leetcode.com/problems/word-pattern/discuss/73399/Very-fast-(3ms)-Java-Solution-using-HashMap
	// containsValue() method increases time complexity
	public boolean wordPattern_02(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char key = pattern.charAt(i);
			String word = words[i];
			if (map.containsKey(key) && !map.get(key).equals(word))
				return false;
			if (!map.containsKey(key) && map.containsValue(word))
				return false;
			map.put(key, word);
		}
		return true;
	}

	// https://leetcode.com/problems/word-pattern/discuss/73533/Java-Solution-with-a-hashmap-and-a-hashset
	public boolean wordPattern_03(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length()) {
			return false;
		}

		Map<Character, String> dict = new HashMap<>();
		Set<String> set = new HashSet<>();

		for (int i = 0; i < words.length; ++i) {
			char c = pattern.charAt(i);
			if (!dict.containsKey(c)) {
				if (!set.add(words[i])) {
					return false;
				}
				dict.put(c, words[i]);
			} else if (!dict.get(c).equals(words[i])) {
				return false;
			}
		}

		return true;
	}
}
