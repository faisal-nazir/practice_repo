package com.epi.heap;

import java.util.*;

public class ComputeMedianOfOnlineData {

	public static List<Double> compute(List<Integer> nums) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(nums.size());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.size(), Collections.reverseOrder());
		List<Double> res = new ArrayList<>();
		
		Iterator<Integer> iter = nums.iterator();
		while(iter.hasNext()) {
			int n = iter.next();
			if(minHeap.isEmpty()) {
				minHeap.add(n);
			} else {
				if(n >= minHeap.peek())
					minHeap.add(n);
				else 
					maxHeap.add(n);
			}
			
			if(minHeap.size() - maxHeap.size() > 1) {
				maxHeap.add(minHeap.poll());
			} else if(maxHeap.size() > minHeap.size()) {
				minHeap.add(maxHeap.poll());
			}
			
			Double m = (minHeap.size() ==  maxHeap.size())? 0.5 * (minHeap.peek() + maxHeap.peek()) :
							(double) minHeap.peek();
			res.add(m);
		}
		return res;
	}
	
	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(1, 0, 3, 5, 2, 0, 1);
		List<Double> res = compute(input);
		for(Double d : res) {
			System.out.print(d + " ");
		}
	}
}
