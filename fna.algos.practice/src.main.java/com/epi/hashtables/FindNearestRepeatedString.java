package com.epi.hashtables;

import java.util.*;

public class FindNearestRepeatedString {

	//EPI-13.6: Find the nearest repeated enteries in an array
	
	public static int findNearestRepetition(List<String> sentence) {
		int dis = Integer.MAX_VALUE;
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < sentence.size(); ++i) {
			String s = sentence.get(i);
			if(map.containsKey(s)) {
				dis = Math.min(Math.abs(map.get(s) - i), dis);
			} 
			map.put(s, i);
		}
		return dis;
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("All", "work", "and", "no", "play", 
				"makes", "for", "no", "work", "no", "fun", "and", "no", "results");
		System.out.println(findNearestRepetition(list));
	}
}
