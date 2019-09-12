package temp;

import java.util.Arrays;

public class UniquePaths {

	//https://leetcode.com/problems/unique-paths/
	
	public static int getUniquePaths(int m , int n) {
		int[][] table = new int[m][n];
		for(int i = 0; i < m; ++i) 
			Arrays.fill(table[i], -1);
		return solve(m-1, n-1, table);
	}
	
	private static int solve(int row, int col, int[][] table) {
		if(row == 0 && col == 0) return 1;
		if(row < 0 || col < 0) return 0;
		
		if(table[row][col] != -1) return table[row][col];
		
		table[row][col] =  solve(row-1, col, table) + solve(row, col-1,table);
		
		return table[row][col];
	}
	
	public static void main(String[] args) {
		int m = 5; int n = 5;
		System.out.println(getUniquePaths(m, n));
	}
}
