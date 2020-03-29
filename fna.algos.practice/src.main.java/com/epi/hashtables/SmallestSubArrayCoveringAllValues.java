package com.epi.hashtables;

import java.util.*;

public class SmallestSubArrayCoveringAllValues {
	
	// EPI-13.7: FIND THE SMALLEST SUBARRAY COVERING ALL VALUES
	private static class SubArray {
		int start;
		int end;
		
		SubArray(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static SubArray find(List<String> words, List<String> keywords) {
		Map<String, Integer> map = new HashMap<>();
		for(String keyword : keywords) {
			map.put(keyword, map.getOrDefault(keyword, 0)+1);
		}
		int i = 0, j = 0, d = Integer.MAX_VALUE, toCover = map.size();
		Integer count = 0;
		String s = "";
		SubArray res = new SubArray(-1, -1);
		
		while(j < keywords.size()) {
			s = words.get(j);
			count = map.get(s);
			if(count != null) {
				map.put(s, --count);
				if(count >= 0)
					--toCover;
			}
			while(toCover == 0) {
				if(d < j-i) {
					d = j-i;
					res.start = i;
					res.end = j;
				}
				
				s = words.get(i);
				count = map.get(s);
				if(count != null) {
					map.put(s, ++count);
					if(count > 0)
						++toCover;
				}
				++i;
			}
			++j;
		}
		return res;
	}
}
