package com.epi.arrays;

import java.util.*;

public class MultiplyArrays {

	public static List<Integer> multiply(List<Integer> A, List<Integer> B) {
	
		int sign = (A.get(0) < 0) ^ (B.get(0) < 0) ? -1 : 1;
		A.set(0, Math.abs(A.get(0)));
		B.set(0, Math.abs(B.get(0)));
		
		int m = A.size();
		int n = B.size();
		
		List<Integer> res = new ArrayList<>(Collections.nCopies(m+n, 0));
		
		for(int i = m-1; i >= 0; --i) {
			for(int j = n-1; j >=0; --j) {
				res.set(i+j+1, res.get(i+j+1) + A.get(i) * B.get(j));
				res.set(i+j, res.get(i+j) + res.get(i+j+1)/10);
				res.set(i+j+1, res.get(i+j+1)%10);
			}
		}
		
		// remove the leading zeros
		int non_zero = 0;
		while(non_zero < res.size() && res.get(non_zero) == 0) {
			++non_zero;
		}
		
		res = res.subList(non_zero, res.size());
		
		if(res.isEmpty()) return Arrays.asList(0);
		
		res.set(0, res.get(0) *  sign);
		return res;
	}
	
	public static void main(String[] args) {
		Integer a[] = new Integer[] { 1, 2, 3};
		Integer b[] = new Integer[] { 9, 8, 7};
		List<Integer> res = multiply(Arrays.asList(a), Arrays.asList(b));
		
		print(res);
	}
	
	private static void print(List<Integer> list) {
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
}
