package com.amazon.online;
/** Give m balls and n bins. Find out how many ways to assign balls to bins.
 *  Notice the buckets has no order. Like (1,2,3) and (3,2,1) are considered the same. 
eg, m = 3, n = 2, return 2. (1, 2) and (3, 0)
**/
public class BallsAndBins {
	public static int assignBins(int balls, int bins) {
		if(balls == 0 || bins == 1) 
			return 1;
		if(balls < bins)
			return assignBins(bins, bins);
		return assignBins(balls, bins-1) + assignBins(balls-bins, bins);
	}
	
	public static void main(String[] args) {
		System.out.println(assignBins(4,3));
	}
}
