package com.amazon.online;

import java.util.*;
import java.util.Map.Entry;

public class TopKFrequentWords {

	// asked by 'CarGurus' during telephone session
	public static List<String> getFrequentElements(List<String> vins, int k){
		Map<String, Integer> map = new HashMap<String, Integer>();
		Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>
														(k, new Comparator<Entry<String, Integer>> () {
				public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
					int diff = e1.getValue() - e2.getValue();
					return diff;
				}
			}
		);
		
		List<String> result = new ArrayList<String>();
		for(String vin : vins) {
			map.put(vin, map.getOrDefault(vin, 0) + 1);
		}
		
		for(Entry<String, Integer> e : map.entrySet()) {
			minHeap.add(e);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		while(k > 0) {
			result.add(minHeap.poll().getKey());
			k--;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Faisal");
		names.add("Farhan");
		names.add("Laiq");
		names.add("Rashid");
		names.add("Afaq");
		names.add("Ehtisham");
		names.add("Laiq");
		names.add("Farhan");
		names.add("Faisal");
		names.add("Junaid");
		names.add("Faisal");
		
		List<String> res = getFrequentElements(names, 3);
		for(String s : res) {
			System.out.println(s);
		}
	}
	
	// my submission
	// https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/
	// O(n log k)
	public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length < k ) return null;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>(k,
                                                       (a, b)-> map.get(a) - map.get(b));
        
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for(int key : map.keySet()) {
            minHeap.offer(key);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int [] res = new int[k];
        int i = 0;
        while(minHeap.size() > 0) {
            res[i++] = minHeap.poll(); 
        }
        
        return res;
    }
}
