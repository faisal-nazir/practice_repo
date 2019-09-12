package com.epi.hashtables;

import java.util.*;

public class PalindromicPermutation {

	public static boolean isPalindromicPermutation(String str) {
	
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		int oddCount = 0;
		for(Map.Entry<Character, Integer> e : map.entrySet()) {
			if(e.getValue()%2 != 0 && ++oddCount > 1) {
				return false;
			}
		}
		return true;
	}
}
