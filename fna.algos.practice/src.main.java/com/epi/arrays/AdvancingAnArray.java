package com.epi.arrays;

public class AdvancingAnArray {

	// EPI-6.4 Advancing through an array
	
	public static boolean advance(int[] arr) {
		int max_so_far = 0;
		for(int i = 0; i <= max_so_far && max_so_far <= arr.length-1; ++i) {
			System.out.print(max_so_far + ", ");
			max_so_far = Math.max(max_so_far, i + arr[i]);
		}
		return max_so_far >= arr.length-1;
	}
	
	public static void main(String[] args) {	
		int[] arr = new int[] { 3, 3, 1, 0, 2, 0, 1 };
//		int[] arr = new int[] { 3, 2, 0, 0, 2, 0, 1 };
		System.out.println(advance(arr));
	}
}
