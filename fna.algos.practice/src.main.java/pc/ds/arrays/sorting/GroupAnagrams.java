package pc.ds.arrays.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Given an array of strings, group anagrams together.

	Example:
	
	Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	Output:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	Note:
	
	All inputs will be in lowercase.
	The order of your output does not matter.
**/

public class GroupAnagrams {
	//https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
	public List<List<String>> groupAnagrams_01(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
	
	//https://leetcode.com/problems/group-anagrams/discuss/19183/Java-beat-100!!!-use-prime-number
	public static List<List<String>> groupAnagrams_02(String[] strs) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53,
				59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };

		List<List<String>> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (String s : strs) {
			int key = 1;
			for (char c : s.toCharArray()) {
				key *= prime[c - 'a'];
			}
			List<String> t;
			if (map.containsKey(key)) {
				t = res.get(map.get(key));
			} else {
				t = new ArrayList<>();
				res.add(t);
				map.put(key, res.size() - 1);
			}
			t.add(s);
		}
		return res;
	}
}
