package pc.ds.arrays.dfs;

public class LongestIncreasingPathInMatrix {

	public static int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int ans = 1;
        int count = 1;
        int R = matrix.length;
        int C = matrix[0].length;
        
        //boolean[][] seen = new boolean[R][C];
        
        for(int i = 0; i < R; ++i) {
            for(int j = 0; j < C; ++j) {
                //if(!seen[i][j])
                
                count  = dfs(matrix, i, j);
                ans = Math.max(ans, count);
            }
        }
        
        return ans;
    }
    
    private static int dfs(int[][] matrix, int i, int j/*, boolean[][] seen*/) {
                
        int[][] DIRS = new int[][] { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int max = 1;
        
        for(int[] dir : DIRS) {
            
            int ni = i + dir[0];
            int nj = j + dir[1];
            
            if(ni < 0 || ni >= matrix.length || nj < 0 || nj >= matrix[i].length) continue; 
            
            if(matrix[i][j] < matrix[ni][nj]) {
                max = Math.max(max, dfs(matrix, ni, nj) + 1);
                System.out.println(max);
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
    	int[][] M = new int[][] { 
    	                           {9,9,4},
    	                           {6,6,8},
    	                           {2,1,1}
    							}; 
    	System.out.println(longestIncreasingPath(M));
    }
}
