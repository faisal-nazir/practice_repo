package com.epi.dp;

public class NoOfMovesToClimbStairs {
	
	// EPI- 17.10: COUNT THE NUMBER OF MOVES TO CLIMB STAIRS
	
	public static int countMoves(int stairs, int max_step) {
		return count(stairs, max_step, new int[stairs+1]);
	}
	
	private static int count(int n, int k, int[] dp) {
		if(n <= 1) return 1;
		if(dp[n] == 0) {
			for(int i = 1; i <= k && n-i >= 0; ++i) {
				dp[n] += count(n-i, k, dp);
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int stairs = 4, max_steps = 2;
		System.out.print(countMoves(stairs, max_steps));
	}

}
