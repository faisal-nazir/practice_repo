package interview.pro.daily.problem;

import java.util.*;

public class ArrayIntersection {

	
	public static List<Integer> intersection(int[] A, int [] B) {
		if(A == null || A.length == 0 || B == null || B.length == 0) return Collections.emptyList();
		List<Integer> res = new ArrayList<>();
		Arrays.sort(A);
		Arrays.sort(B);
		int i = 0, j = 0;
		while(i < A.length & j < B.length) {
			if(A[i] == B[j]) {
				res.add(A[i]);
				++i; ++j;
				while(i < A.length && A[i-1] == A[i]) ++i;
				while(j < B.length && B[j-1] == B[j]) ++j;
				
			} else if(A[i] < B[j]) {
				++i;
			} else {
				++j;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
//		int[] A = {4, 9, 5};
//		int[] B = {9, 4, 9, 8, 4};
		
		int[] A = {1, 2, 2, 1};
		int[] B = {2, 2};
		
		List<Integer> res = intersection(A, B);
		for(int n : res) {
			System.out.print(n + " ");
		}
	}
}
