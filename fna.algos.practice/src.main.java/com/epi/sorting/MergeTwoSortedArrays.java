package com.epi.sorting;

import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArrays {

	public static void merge(List<Integer> bigger, int m, List<Integer> smaller, int n) {
		int write_idx = m+n-1, bi = m-1, si= n-1;
		
		while(bi >= 0 && si >= 0) {
			bigger.set(write_idx--, (bigger.get(bi) > smaller.get(si)) ? bigger.get(bi--) : smaller.get(si--));
		}
		while(si >= 0) {
			bigger.set(write_idx--, smaller.get(si--));
		}
	}
	
	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[] {5, 13, 17, 0, 0, 0, 0, 0});
		List<Integer> B = Arrays.asList(new Integer[] {3, 7, 11, 19});
		merge(A, 3, B, 4);
		print(A);
	}
	
	private static void print(List<Integer> list) {
		System.out.println();
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
}
