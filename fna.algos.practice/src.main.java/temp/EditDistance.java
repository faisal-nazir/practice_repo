package temp;

import java.util.Arrays;

public class EditDistance {
	// https://leetcode.com/problems/edit-distance/
	
	public static int getEditDistance(String A, String B) {
		int[][] dp = new int[A.length()+1][B.length()+1];
		
		for(int i = 0; i <= A.length(); ++i) {
			dp[i][0] = i;
		}
		
		for(int j = 0; j <= B.length(); ++j) {
			dp[0][j] = j;
		}
		
		for(int row = 1; row <= A.length(); ++row) {
			for(int col = 1; col <= B.length(); ++col) {
				if(A.charAt(row-1) == B.charAt(col-1)) {
					dp[row][col] = dp[row-1][col-1];
				}
				else {
					dp[row][col] = 1 + Math.min(Math.min(dp[row-1][col-1], dp[row][col-1]), dp[row-1][col]);
				}
			}
		}
		
		return dp[A.length()][B.length()];
	}
	
	public static void main(String[] args) {
//		String A = "benyam";
//		String B = "ephrem";
		String A = "biting";
		String B = "sitting";
		System.out.println(getEditDistance_Rec(A, B));
	}
	
	public static int getEditDistance_Rec(String A, String B) {
		int[][] table = new int[A.length()][B.length()];
		for(int i = 0; i < A.length(); ++i) {
			Arrays.fill(table[i], -1);
		}
		return solve(A, A.length()-1, B, B.length()-1, table);
	}
	
	private static int solve(String A, int idx_A, String B, int idx_B, int[][] table) {
		if(idx_A < 0)
			return idx_B+1;
		
		if(idx_B < 0) 
			return idx_A+1;
		
		if(table[idx_A][idx_B] == -1) {
			if(A.charAt(idx_A) == B.charAt(idx_B)) {
				table[idx_A][idx_B] = solve(A, idx_A-1, B, idx_B-1, table);
			} else {
				int substitueLast = solve(A, idx_A-1, B, idx_B-1, table);
				int deleteLast = solve(A, idx_A-1, B, idx_B, table);
				int insertLast = solve(A, idx_A, B, idx_B-1, table);
				
				table[idx_A][idx_B] = 1 + Math.min(Math.min(substitueLast, insertLast), deleteLast);
			}
			 
		}
		return table[idx_A][idx_B];
	}
}
