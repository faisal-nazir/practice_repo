package temp;

import java.util.Arrays;

public class UniquePathsInAGrid {

	public static int getPaths(int x, int y, int[][] dp) {
		if(x == 0 && y == 0) return 1;
		if(x < 0 || y < 0) return 0;
		
		if(dp[x][y] < 0) {
			dp[x][y] = getPaths(x-1, y, dp) + getPaths(x, y-1, dp);
		}
		return dp[x][y];
	}
	
	public static int getUniquePaths(int x, int y) {
		int[][] dp = new int[x][y];
		for(int i = 0; i < x; ++i) {
			Arrays.fill(dp[i], -1);
		}
		return getPaths(x-1, y-1, dp);
	}
	
	public static void main(String[] args) {
		int rows = 7, cols = 3;
		System.out.println(getPaths_up(rows, cols));
	}
	
	public static int getPaths_up(int x, int y) {
		if(x <= 0 || y <= 0) return 0;
		
		int[] count = new int[y];
		Arrays.fill(count, 1);
		
		for(int i = 1; i < x; ++i) {
			for(int j = 1; j < y; ++j) {
				count[j] += count[j-1];
			}
		}
		return count[y-1];
	}
}
