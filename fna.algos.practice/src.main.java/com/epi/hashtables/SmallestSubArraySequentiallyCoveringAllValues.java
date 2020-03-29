package com.epi.hashtables;

import java.util.*;

public class SmallestSubArraySequentiallyCoveringAllValues {

	// EPI- 13.8: FIND SMALLEST SUBARRAY SEQUENTIALLY COVERING ALL VALUES
	private static class SubArray {
		int start; 
		int end;
		
		SubArray(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	public SubArray findMinSubArray(List<String> paragraph, List<String> keywords) {
		Map<String, Integer> keywordsToIdx = new HashMap<>();
		List<Integer> latestOccurance = new ArrayList<>(keywords.size());
		List<Integer> minLengthSubArray = new ArrayList<>(keywords.size());
		
		// initialize maps
		for(int i = 0; i < keywords.size(); ++i) {
			keywordsToIdx.put(keywords.get(i), i);
			latestOccurance.add(-1);
			minLengthSubArray.add(Integer.MAX_VALUE);
		}
		
		int shortestDistance = Integer.MAX_VALUE;
		SubArray res = new SubArray(-1, -1);
		
		for(int i = 0; i < paragraph.size(); ++i) {
			Integer keywordIdx = keywordsToIdx.get(paragraph.get(i));
			
			if(keywordIdx != null) {
				if(keywordIdx == 0) { // if it is the first keyword
					minLengthSubArray.set(0, 1);
				} else if(minLengthSubArray.get(keywordIdx-1) != Integer.MAX_VALUE) {
					int addedLength = i - latestOccurance.get(keywordIdx-1);
					minLengthSubArray.set(keywordIdx, minLengthSubArray.get(keywordIdx-1) + addedLength);
				}
				latestOccurance.set(keywordIdx, i);
				
				// if last keyword then look for improved sub-array
				if(keywordIdx == keywords.size()-1 && minLengthSubArray.get(keywords.size()-1) < shortestDistance) {
					shortestDistance = minLengthSubArray.get(keywords.size()-1);
					res.start = i - minLengthSubArray.get(keywords.size()-1) + 1;
					res.end = i;
				}
			}
		}
		
		return res;
		
	}
}
