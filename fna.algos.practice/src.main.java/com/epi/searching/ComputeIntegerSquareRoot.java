package com.epi.searching;

public class ComputeIntegerSquareRoot {

	// EPI-12.4: COMPUTE THE INTEGER SQUARE ROOT
	
	// https://www.geeksforgeeks.org/square-root-of-an-integer/
	public static int floorSquareRoot(int k) {
		 int s = 0, e = k;
		 int ans = -1;
		 while(s <= k) {
			 int mid = (s+e) >>> 1;
			 int square = mid*mid;
			 if(square == k)
				 return square;
			 if(square < k) {
				 s  = mid + 1;
				 ans = s;
			 } else {
				 e = mid -1;
			 }
		 }
		 return ans;
	}
}
