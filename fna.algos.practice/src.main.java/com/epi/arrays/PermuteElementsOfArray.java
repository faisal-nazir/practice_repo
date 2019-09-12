package com.epi.arrays;

import java.util.*;

public class PermuteElementsOfArray {

	// EPI-6.9: Permute the elements of an array 
	// Revisit this one - unable to graps it completely for now
	public static void permute(List<Integer> perm, List<Character> A) {
		for(int i = 0; i < A.size(); ++i) {
			int next = i;
			while(perm.get(next) >= 0) {
				Collections.swap(A, i, perm.get(next));
				int temp = perm.get(next);
				perm.set(next, perm.get(next) - perm.size());
				next = temp;
			}
		}
		
		for(int i = 0; i < perm.size(); ++i) {
			perm.set(i, perm.get(i) + perm.size());
		}
	}
	
	public static void main(String[] args) {
		List<Character> A = Arrays.asList('a', 'b', 'c', 'd');
		List<Integer> perm = Arrays.asList(3, 2, 1, 0);
		permute(perm, A);
		for(char c : A) {
			System.out.print(c + " ");
		}
	}
}
