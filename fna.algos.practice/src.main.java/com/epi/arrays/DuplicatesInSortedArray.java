package com.epi.arrays;

public class DuplicatesInSortedArray {

	public static int deDuplicate(int[] arr) {
		int si = 1;
		for(int i = si; i < arr.length; ++ i) {
			if(arr[i] != arr[i-1])
				arr[si++] = arr[i];
		}
		return si;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 1, 1, 3, 5, 5, 5, 7, 9, 11};
		int n = deDuplicate(a);
		
		print(a, n);
	}
	
	private static void print(int[] a, int n) {
		for(int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
	}
}
