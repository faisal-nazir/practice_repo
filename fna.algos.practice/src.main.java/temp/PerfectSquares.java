package temp;

import java.util.Arrays;

public class PerfectSquares {

	// https://leetcode.com/problems/perfect-squares/
	
	public static int compute(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j*j <= i; ++j) {
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
			}
		}
		return dp[n];
	}
}
