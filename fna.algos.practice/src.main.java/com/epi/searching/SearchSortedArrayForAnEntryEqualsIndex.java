package com.epi.searching;

public class SearchSortedArrayForAnEntryEqualsIndex {

	// only distinct values are allowed
	public static int search(int[] arr) {
		int res = -1;
		int s = 0, e = arr.length-1;
		while(s <= e) {
			int mid = (s+e)>>>1;
			if(arr[mid] == mid) {
				return mid;
			} else if(arr[mid] < mid) {
				s = mid+1;
			} else {
				e = mid-1;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] A = { -3, -1, 0, 2, 3, 5 };
		System.out.print(search(A));
	}
	
	// when array may contain duplicate elements
	// we can divide the search space in to half
	// the worst case would be to search the whole array.
	// below is the optimization on the worst case.
	
	private static int search_with_duplicates(int[] arr) {
		return helper(arr, 0, arr.length-1);
	}
	
	private static int helper(int[] arr, int s, int e) {
		if(s > e) return -1;
		int mid = (s+e) >>> 1;
		if(arr[mid] == mid) return mid;
		int left = helper(arr, s, Math.min(arr[mid], mid-1));
		if(left >= 0) return left;
		return  helper(arr, Math.max(arr[mid], mid+1), e);
	}
}
