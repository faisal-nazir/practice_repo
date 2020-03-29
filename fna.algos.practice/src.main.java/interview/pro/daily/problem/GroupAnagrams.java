package interview.pro.daily.problem;

import java.util.*;

public class GroupAnagrams {
	
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

	public static List<List<String>> groupAnagrams(List<String> input) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for(String s : input) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String key = new String(c);
			if(map.containsKey(key)) {
				map.get(key).add(s);
			} else {
				map.put(key, new ArrayList<String>());
				map.get(key).add(s);
			}
		}
		
		for(List<String> list : map.values()) {
			res.add(list);
		}
		
		//return res;
		return new ArrayList<>(map.values());
	}
	
	public static void main(String[] args) {
		List<String> input = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
		List<List<String>> res = groupAnagrams(input);
		print(res);
	}
	
	private static void print(List<List<String>> lists) {
		for(List<String> list : lists) {
			for(String s : list) {
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}
}
