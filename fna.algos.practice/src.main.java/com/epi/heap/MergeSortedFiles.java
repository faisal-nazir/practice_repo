package com.epi.heap;

import java.util.*;

public class MergeSortedFiles {
	
	static class ArrayEntry {
		int value;
		int arrayIndex;
		
		ArrayEntry(int value, int index) {
			this.value = value;
			this.arrayIndex = index;
		}
	}

	public List<Integer> mergeSortedList(List<List<Integer>> lists) {
		List<Integer> res = new ArrayList<Integer>();
		Queue<ArrayEntry> minHeap = new PriorityQueue<>(lists.size(), new Comparator<ArrayEntry>() {
			public int compare(ArrayEntry a, ArrayEntry b) {
				return a.value - b.value;
			}
		});
		List<Iterator<Integer>> iters = new ArrayList<Iterator<Integer>>();
		for(List<Integer> list : lists) {
			iters.add(list.iterator());
		}
		
		for(int i = 0; i < lists.size(); ++i) {
			if(iters.get(i).hasNext())
				minHeap.add(new ArrayEntry(iters.get(i).next(), i));
		}
		
		while(!minHeap.isEmpty()) {
			ArrayEntry rootEntry = minHeap.poll(); 
			res.add(rootEntry.value);
			if(iters.get(rootEntry.arrayIndex).hasNext())
				minHeap.add(new ArrayEntry(iters.get(rootEntry.arrayIndex).next(), rootEntry.arrayIndex));
		}
		
		return res;
	}
}
