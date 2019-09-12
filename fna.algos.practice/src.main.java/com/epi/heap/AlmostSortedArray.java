package com.epi.heap;

import java.util.*;

public class AlmostSortedArray {

	// EPI-11.3: SORT AN ALMOST-SORTED ARRAY
	public static List<Integer> sort (List<Integer> list, int k) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		List<Integer> res = new ArrayList<>();
		
		Iterator<Integer> sequence = list.iterator();
		
		for(int i = 0; i < k && sequence.hasNext(); ++i) {
			minHeap.add(sequence.next());
		}
		
		while(sequence.hasNext()) {
			minHeap.add(sequence.next());
			res.add(minHeap.remove());
		}
		
		while(!minHeap.isEmpty())
			res.add(minHeap.remove());
		
		return res;
	}
}
