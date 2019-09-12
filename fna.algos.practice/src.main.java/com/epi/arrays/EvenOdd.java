package com.epi.arrays;


public class EvenOdd {

	public static int[] reArrange(int[] arr) {
		if(arr == null || arr.length == 0) return arr;
		int idx_even = 0;
		int idx_odd = arr.length-1;
		while(idx_even < idx_odd) {
			while(idx_even < idx_odd && arr[idx_even]%2 == 0) {
				++idx_even;
				
			}
			while(idx_even < idx_odd && arr[idx_odd]%2 != 0) {
				--idx_odd;
			}
			if(idx_even >= idx_odd) break;
			swap(arr, idx_even, idx_odd);
		}
		return arr;
	}
	
	private static void swap(int[] arr, int i, int j) {
		if(i < 0 || j < 0 || i >= arr.length || j >= arr.length) return;
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static int[] reArrangeByPartition(int[] arr) {
		if(arr == null || arr.length == 0) return arr;
		int si = 0;
		for(int i = 0; i < arr.length; ++i) {
			if(arr[i]%2 == 0) {
				swap(arr, si, i);
				++si;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 5};
		print(reArrange(input));
	}
	
	private static void print(int[] arr) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		
	}
}
