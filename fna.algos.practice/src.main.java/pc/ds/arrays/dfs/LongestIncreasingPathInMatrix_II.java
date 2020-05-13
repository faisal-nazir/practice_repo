package pc.ds.arrays.dfs;

public class LongestIncreasingPathInMatrix_II {

	// same problem as "LongestIncreasingPathInMatrix" with dp solution now
	
	
	// https://leetcode.com/explore/interview/card/top-interview-questions-hard/118/trees-and-graphs/849/
	// my leetcode submission
	public static int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int ans = 1;
        int count = 1;
        int R = matrix.length;
        int C = matrix[0].length;
        
        int[][] dp = new int[R][C];
        
        for(int i = 0; i < R; ++i) {
            for(int j = 0; j < C; ++j) {
                if(dp[i][j] == 0) {
                    count  = dfs(matrix, i, j, dp);
                    ans = Math.max(ans, count);    
                }
            }
        }
        return ans;
    }
    
    private static int dfs(int[][] matrix, int i, int j, int[][] dp) {
        
        if(dp[i][j] != 0) return dp[i][j];
                
        int[][] DIRS = new int[][] { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int max = 1;
        for(int[] dir : DIRS) {
            
            int ni = i + dir[0];
            int nj = j + dir[1];
            
            if(ni < 0 || ni >= matrix.length || nj < 0 || nj >= matrix[i].length) continue; 
            
            if(matrix[i][j] < matrix[ni][nj]) {
                max = Math.max(max, dfs(matrix, ni, nj, dp) + 1);
            }
        }
        dp[i][j] = max;
        return dp[i][j];
    }
}
