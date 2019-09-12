package temp;

import java.util.Arrays;

public class CoinChange_02 {
	
	public static int getCoinChange_recursive(int amount, int[] coins) {		
		Arrays.sort(coins);
		return solve(amount, 0, coins);
	}
	
	
	private static int solve(int amount, int index, int[] coins) {
		if(amount == 0) return 1;
		
		if(index == coins.length) return 0;
		
		int count = 0;
		for(int i = index; i < coins.length; ++i) {
			if(amount < coins[i]) break;
			
			int times = 1;
			while(times * coins[i] <= amount) {
				count += solve(amount- times * coins[i], i+1 , coins);
				times++;
			}
				
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] coins = {1, 2, 4};
		int amount = 5; 
		System.out.println(getCoinChange_bottomUp(amount, coins));
	}
	
	public static int getCoinChange_bottomUp(int amount, int[] coins) {
		if(amount == 0) return 1;
		
		int[][] dp = new int[coins.length+1][amount+1];
		dp[0][0] = 1;
		
		for(int r = 1; r <= coins.length; ++r) {
			dp[r][0] = 1;
			for(int c = 1; c <= amount; ++c) {
				int currCoinValue = coins[r-1];
				
				int withoutCoin = dp[r-1][c];
				int withCoin = (c - currCoinValue < 0) ? 0 : dp[r][c-currCoinValue];
				
				dp[r][c] = withoutCoin + withCoin;
			}
		}
		return dp[coins.length][amount];
		
	}
}
