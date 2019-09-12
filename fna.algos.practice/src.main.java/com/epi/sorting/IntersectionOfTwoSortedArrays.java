package com.epi.sorting;

import java.util.*;

public class IntersectionOfTwoSortedArrays {

	public static List<Integer> intersection(List<Integer> a, List<Integer> b) {
		List<Integer> smaller = (a.size() < b.size())? a : b;
		List<Integer> larger = (a.size() < b.size())? b : a;
		Set<Integer> res = new HashSet<>();
		
		for(int i = 0; i < smaller.size(); ++i) {
			if(i == 0 || Collections.binarySearch(larger, smaller.get(i)) >= 0 &&
					smaller.get(i) != smaller.get(i-1)) {
				res.add(smaller.get(i));
			}
		}
		
		return new ArrayList<Integer>(res);
	}
	
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[] { 2,3,3,5,5,6, 7, 7,8,12});
		List<Integer> b = Arrays.asList(new Integer[] { 5,5,6,8,8,9,10,10});
		print(intersection(a, b));
		
		
		
	}
	
	private static void print(List<Integer> list) {
		System.out.println();
		for(int num : list) {
			System.out.print(num + ", ");
		}
	}
}
