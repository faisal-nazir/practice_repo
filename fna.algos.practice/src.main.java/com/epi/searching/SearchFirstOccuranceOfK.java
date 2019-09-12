package com.epi.searching;

public class SearchFirstOccuranceOfK {

	public static int search(int[] arr, int key) {
		int start = 0, end = arr.length-1;
		int idx = -1;
		while(start <= end) {
			int mid = start + end >>> 1;
			if(arr[mid] == key) {
				idx = mid;
				end = mid-1;
			} else if(arr[mid] < key) {
				start = mid +1;
			} else {
				end = mid-1;
			}
		}
		return idx;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 };
		System.out.print(search(A, 285));
	}
}
