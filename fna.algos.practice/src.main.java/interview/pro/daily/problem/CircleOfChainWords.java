package interview.pro.daily.problem;

import java.util.*;

public class CircleOfChainWords {

	public static boolean isChained(String[] words) {
		if(words == null || words.length == 0) return false;
		Map<Character, List<String>> map = new HashMap<>();
		
		for(String word: words) {
			char key = word.charAt(0);
			if(map.containsKey(key)) {
				map.get(key).add(word);
			} else {
				List<String> list = new ArrayList<>();
				list.add(word);
				map.put(key, list);
			}
		}
		
		String w = words[0];
		char key = w.charAt(w.length()-1);

		while(map.containsKey(key)) {
			List<String> values = map.get(key);
			values.remove(w);
			if(values.size() == 0) 
				map.remove(key);
		}
		return map.isEmpty();
	}
	
	public static void main(String[] args) {
//		String[] words = new String[] { "eggs", "karat", "apple", "snack", "tuna", "are" };
		String[] words ={"aaa", "bbb", "baa", "aab"};
		System.out.println(isChained(words));
	}
	
}
