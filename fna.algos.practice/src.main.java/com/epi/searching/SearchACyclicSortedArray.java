package com.epi.searching;

public class SearchACyclicSortedArray {

	public static int searchSmallest(int[] arr) {
		int s = 0, e = arr.length-1;
		while(s < e) {
			int mid = (s+e) >>> 1;
			if(arr[mid] > arr[e]) {
				s = mid+1;
			} else {
				e = mid-1;
			}
		}
		return s;
	}
}
