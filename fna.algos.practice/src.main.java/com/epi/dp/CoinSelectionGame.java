package com.epi.dp;

public class CoinSelectionGame {

	// EPI- 17.9: Pick up coins for maxium gain
	public static int getMaxScore(int[] coins) {
		return helper(coins, 0, coins.length-1, new int[coins.length][coins.length]);
	}
	
	private static int helper(int[] coins, int a , int b, int[][] dp) {		
		if(a > b) return 0;
		
		if(dp[a][b] == 0) {
			int A = coins[a] + Math.min(helper(coins, a+2, b, dp), helper(coins, a+1, b-1, dp));
			int B = coins[b] + Math.min(helper(coins, a+1, b-1, dp), helper(coins, a, b-2, dp));
			
			dp[a][b] = Math.max(A, B);
		}
		
		return dp[a][b];
	}
		
	public static void main(String[] args) {
//		int[] coins = new int[]{ 5, 25, 10 , 1};
//		int[] coins = new int[]{ 8, 15, 3, 7 };
		int[] coins = new int[]{ 20, 30, 2, 2, 2, 10 };
		System.out.println(getMaxScore(coins));
	}
	
	// TODO: https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
	// Try bottom up verion for the solution.
}
