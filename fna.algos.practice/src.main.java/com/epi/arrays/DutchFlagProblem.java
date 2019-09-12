package com.epi.arrays;

public class DutchFlagProblem {

	public static int[] partition(int[] input, int pivot) {
		int smaller = 0, equal = 0, larger = input.length;
		while(equal < larger) {
			if(input[equal] < pivot) {
				swap(input, equal++, smaller++);
			} else if (input[equal] == pivot) {
				++equal;
			} else {
				swap(input, equal, --larger);
			}
		}
		return input;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	public static void main(String[] args) {
		int[] A = {2,  1, 0, 1, -1, 3, 4 };
		// {4,  1, 0, 1, -1, 3, 2 }
		// {-1,  0, 1, 1, 3, 4, 2 }
		print(partition(A, 1));
		
	}
	
	private static void print(int[] arr) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
	}
}
