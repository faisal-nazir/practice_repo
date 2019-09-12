package com.epi.dp;

public class ComputeBinomialCoefficients {

	// compute n choose k
	// EPI-17.4: COMPUTE THE BINOMIAL COEFFICIENTS
	
	public static int computeBinomialCoefficient(int n, int k) {
		return compute(n, k, new int[n+1][k+1]);
	}
	
	private static int compute(int n, int k, int[][] dp) {
		if(k == 0 || n == k) return 1;
		if(dp[n][k] == 0) {
			int withK = compute(n-1, k-1, dp);
			int withOutK = compute(n-1, k, dp);
			dp[n][k] = withK + withOutK;
		}
		
		return dp[n][k];
	}
	
	public static void main(String[] args) {
		System.out.println(computeBinomialCoefficient(5, 2));
	}
}
