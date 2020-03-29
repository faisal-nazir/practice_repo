package interview.pro.daily.problem;

import java.util.Collections;

public class SortColors {

	public static void sort(int[] A, int pivot) {
		int smaller = 0, equal = 0, larger = A.length-1;
		while(equal < larger) {
			if(A[equal] < pivot) {
				swap(A, equal++, smaller++);
			} else if(A[equal] == pivot) {
				++equal;
			} else {
				swap(A, equal++, larger--);
			}
		}
	}
	
	public static void partition(int[] A, int pivot) {
		int si = 0;
		for(int i = 0; i < A.length; ++i) {
			if(A[i] < pivot) {
				swap(A, si++, i);
			}
		}
		int li = A.length-1;
		for(int j = li; j >= 0; j--) {
			if(A[j] > pivot) {
				swap(A, li--, j);
			}
		}
	}
	private static void swap(int[] A, int i, int j) {
		if(i != j) {
			A[i] ^= A[j];
			A[j] ^= A[i];
			A[i] ^= A[j];
		}
	}
	public static void main(String[] args) {
		int[] A = {2,0,2,1,1,0};
		partition(A, 1);
		for(int val : A) {
			System.out.print(val + " ");
		}
		
	}
}
