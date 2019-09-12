package com.epi.heap;

import java.util.*;

public class KIncreasingDecreasingArray {
	
	private static enum SubArrayType { INCREASING, DECREASING }
	
	private static class ArrayEntry {
		int arrayValue;
		int arrayIndex;
		
		ArrayEntry(int value, int index) {
			this.arrayValue = value;
			this.arrayIndex = index;
		}
	}

	public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> list) {
		List<List<Integer>> subLists = new ArrayList<>();
		SubArrayType subArrayType = SubArrayType.INCREASING;
		int si = 0;
		for(int i = 1; i <= list.size(); ++i) {
			if(i == list.size() || (list.get(i-1) < list.get(i) && subArrayType == SubArrayType.DECREASING) 
					|| (list.get(i-1) >= list.get(i) && subArrayType == SubArrayType.INCREASING)) {
				List<Integer> subList = list.subList(si, i);
				subLists.add(subList);
				si = i;
				
				if(subArrayType == SubArrayType.DECREASING)
					Collections.reverse(subList);
				
				subArrayType = (subArrayType == SubArrayType.INCREASING)? SubArrayType.DECREASING : SubArrayType.INCREASING;
			}
		}
		return mergeKSortedLists(subLists);
	}
	
	private static class EntryComparator implements Comparator<ArrayEntry> {
		public int compare(ArrayEntry e1, ArrayEntry e2) {
			return Integer.compare(e1.arrayValue, e2.arrayValue);
		}
		
	}
	
	public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
		List<Integer> res = new ArrayList<>();
		List<Iterator<Integer>> iters = new ArrayList<>();
		for(int i = 0; i < lists.size(); ++i) {
			iters.add(lists.get(i).iterator());
		}
		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(iters.size(), new EntryComparator());
		for(int i = 0; i < iters.size(); ++i) {
			if(iters.get(i).hasNext()) {
				minHeap.add(new ArrayEntry(iters.get(i).next(), i));
			}
			
		}
		
		while(!minHeap.isEmpty()) {
			ArrayEntry top = minHeap.poll();
			res.add(top.arrayValue);
			if(iters.get(top.arrayIndex).hasNext())
				minHeap.add(new ArrayEntry(iters.get(top.arrayIndex).next(), top.arrayIndex));
		}
		return res;
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(new Integer[] { 57, 131, 493, 294, 221, 339, 418, 452, 442, 190 });
		List<Integer> sorted = sortKIncreasingDecreasingArray(list);
		print(list);
		print(sorted);
	}
	
	private static void print(List<Integer> list) {
		System.out.println();
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
}
