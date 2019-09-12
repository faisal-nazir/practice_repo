package com.epi.hashtables;

import java.util.*;

public class AnonymousLetter {
	
	// EPI-13.2: Is an anonymous letter constructible?
	
	public static boolean isConstructable(String letterText, String magzineText) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c : letterText.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		for(char c : magzineText.toCharArray()) {
			if(map.containsKey(c)) {
				if(map.get(c) == 1) 
					map.remove(c);
				else
					map.put(c, map.get(c)-1);
			}
		}
		
		return map.isEmpty();
	}
}
