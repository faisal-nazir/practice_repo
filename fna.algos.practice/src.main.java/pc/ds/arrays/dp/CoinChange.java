package pc.ds.arrays.dp;

import java.util.*;

/** 
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.

	Example 1:
	
	Input: coins = [1, 2, 5], amount = 11
	Output: 3 
	Explanation: 11 = 5 + 5 + 1
	Example 2:
	
	Input: coins = [2], amount = 3
	Output: -1
	Note:
	You may assume that you have an infinite number of each kind of coin.
 * 
 *
 */

public class CoinChange {

	// https://leetcode.com/problems/coin-change/solution/
  public static int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
        	System.out.println("amount= " + i + " , " + "coin = " + coins[j]);
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
      print(dp);
      System.out.println();
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
  
  public static void main(String[] args) {
	  int[] coins = {1, 2, 5};
	  int amount = 11;
	  System.out.println(coinChange(coins, amount));
  }
  
  private static void print(int[] A) {
	  for(int val : A) {
		  System.out.print(val + " ");
	  }
  }
}