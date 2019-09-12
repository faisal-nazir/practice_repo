package com.epi.heap;

import java.util.*;

public class KthLongestString {

	public static List<String> getKthLongest(List<String> names, int k) {
		PriorityQueue<String> minHeap = new PriorityQueue<String>(k, new Comparator<String> () {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});
		
		for(String s : names) {
			minHeap.add(s);
			if(minHeap.size() > k)
				minHeap.poll();
		}
		
		return new ArrayList<>(minHeap);
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("123");
		list.add("1234");
		list.add("1");
		list.add("12");
		list.add("2");
		print(getKthLongest(list, 2));
	}
	
	private static void print(List<String> list) {
		for(String s : list) {
			System.out.println(s);
		}
	}
}
