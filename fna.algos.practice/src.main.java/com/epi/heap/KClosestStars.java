package com.epi.heap;

import java.util.*;

public class KClosestStars {

	private static class Star implements Comparable<Star>{
		double x;
		double y;
		double z;
		
		Star(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public double getDistance() {
			return Math.sqrt(x*x + y*y + z*z);
		}
		
		@Override
		public int compareTo(Star rhs) {
			return Double.compare(this.getDistance(), rhs.getDistance());
		}
		
	}
	
	public List<Star> getKClosestStars(int k, Iterator<Star> iterator) {
		PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
		while(iterator.hasNext()) {
			maxHeap.add(iterator.next());
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		List<Star> res = new ArrayList<>(maxHeap);
		Collections.sort(res);
		return res;
		
	}
	
	
}
