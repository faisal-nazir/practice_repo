package interview.pro.daily.problem;

import java.util.*;

public class HIndex {
	
	//[Daily Problem] H-Index

	public static int index(int[] citations) {
		if(citations == null || citations.length == 0) return 0;
		
		Arrays.sort(citations);
		int hindex = 0;
		int n = citations.length;
		for(int i = 0; i < n; ++i) {
			if(n-i >= citations[i])
				hindex = Math.max(hindex, citations[i]);
		}
		return hindex;
	}
	
	public static void main(String[] args) {
		int[] A = {4, 5, 0, 1, 4, 4};
		System.out.print(index(A));
	}
	
	// https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation
	
	public static int compute(int[] citations) {
		if(citations == null || citations.length == 0) return 0;
		int n = citations.length;
		int[] buckets = new int[n+1];
		for(int c : citations) {
			if(c >= n) {
				++buckets[n]; 
			} else {
				++buckets[c];
			}
		}
				
		int count = 0;
		for(int i = n-1; i >=0; --i) {
			count += buckets[i];
			if(count >= i) {
				return i;
			}
		}
		return 0;
	}
}
