package pc.ds.matrix.dp;

public class UniquePaths {

	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * Note: m and n will be at most 100.
	 * 
	 * Input: m = 2, n = 3
	 * 
	 * Output: 3 Explanation: From the top-left corner, there are a total of 3
	 * ways to reach the bottom-right corner: 1. Right -> Right -> Down 2. Right
	 * -> Down -> Right 3. Down -> Right -> Right
	 **/

	// https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/NumberOfPathsInMxNMatrix.java
	public int uniquePathsRec(int m, int n) {
		if (m < 0 || n < 0)
			return 0;

		if (m == 0 && n == 0)
			return 1;

		return uniquePathsRec(m - 1, n) + uniquePathsRec(m, n - 1);
	}

	public static void main(String[] args) {
		UniquePaths s = new UniquePaths();
		int rows = 4;
		int col = 3;
		System.out.println(s.uniquePathsRec(rows - 1, col - 1));
		System.out.println(s.uniquePaths(rows - 1, col - 1));
		System.out.println(s.uniquePaths_OptimizedSpace(rows - 1, col - 1));
		System.out
				.println(s.uniquePaths_More_OptimizedSpace(rows - 1, col - 1));
	}

	// same idea as Solution# 06.
	public int uniquePaths(int m, int n) {

		int table[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			table[0][i] = 1;
		}

		for (int i = 0; i <= m; i++) {
			table[i][0] = 1;
		}
		// computing new numbers row wise
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				table[i][j] = table[i - 1][j] + table[i][j - 1];
			}
		}
		return table[m][n];
	}

	// optimizing space complexity as suggest here
	// ->
	// https://leetcode.com/problems/unique-paths/discuss/22954/0ms-5-lines-DP-Solution-in-C++-with-Explanations
	public int uniquePaths_OptimizedSpace(int m, int n) {

		int curr[] = new int[m + 1];
		int pre[] = new int[m + 1];

		for (int i = 0; i <= m; i++) { // starting out with 1 for column values
			curr[i] = 1;
			pre[i] = 1;
		}

		// computing new numbers column wise
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				curr[j] = curr[j - 1] + pre[j];
			}
			pre = curr;
		}
		return pre[m];
	}

	public int uniquePaths_More_OptimizedSpace(int m, int n) {

		int curr[] = new int[m + 1];

		for (int i = 0; i <= m; i++) { // starting out with 1 for column values
			curr[i] = 1;
		}

		// computing new numbers column wise
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				curr[j] += curr[j - 1];
			}
		}
		return curr[m];
	}
}
