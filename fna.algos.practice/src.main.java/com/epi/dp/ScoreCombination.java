package com.epi.dp;

import java.util.Arrays;

public class ScoreCombination {
	
	// EPI-17.1: Count the number of score combinations 
	
	// https://www.youtube.com/watch?v=DJ4a7cmjZY0&list=PLiQ766zSC5jM2OKVr8sooOuGgZkvnOCTI&index=8&t=0s
	// Coin Change 2 on leetcode

	public static int compute(int[] plays, int score) {
		if(score <= 0) return 0;
		int[][] dp = new int[plays.length+1][score+1];
		dp[0][0] = 0;
		for(int r = 1; r <= plays.length; ++r) {
			dp[r][0] = 1;
			
			int currentPlay = plays[r-1];
			
			for(int c = 1; c <= score; ++c) {
				int withOutPlay = dp[r-1][c];
				int withPlay = (c < currentPlay) ? 0 : dp[r][c-currentPlay];
				dp[r][c] = withOutPlay + withPlay;
			}
		}
		
		return dp[plays.length][score];
		
	}
	
	public static int compute_rec(int[] plays, int score) {
	
		int[][] dp = new int[plays.length][score+1];
		for(int i = 0; i < dp.length; ++i) {
			Arrays.fill(dp[i], -1);
		}
		return helper(plays, 0, score, dp);
	}
	
	
	// https://leetcode.com/problems/coin-change-2/discuss/204986/Simple-Java-solution-explanation-of-recursive-to-bottoms-up-DP-approach
	private static int helper(int[] plays, int idx, int score, int[][] dp) {
		//System.out.println("idx = " + idx + ", " + "score = " + score);
		if(score == 0) return 1;
		if(idx >= plays.length) return 0;
		
		if(dp[idx][score] != -1) return dp[idx][score];
		
		int count = helper(plays, idx+1, score,dp); // don't take it.
		if(score - plays[idx] >= 0) 
			count += helper(plays, idx, score - plays[idx], dp); // take it.
		
		dp[idx][score] = count;
		
		return dp[idx][score];
	}
	
	public static void main(String[] args) {
		int[] p = new int[] { 2, 3, 7};
		int score = 12;
		System.out.print(compute_rec(p, score));
	}
	
	
}
