package algo.patterns.dfs;

public class NumberOfEnclaves {

	// https://leetcode.com/problems/number-of-enclaves/submissions/
    // UPDATE: 02/2022 --> count the number of 1s that are not reachable from the border
	public static int numEnclaves(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int ans = 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int r = 1; r < m-1; ++r) { // ignoring first and last row (cause its walkable)
            for(int c = 1; c < n-1; ++c) { // ignoring first and last col (same reason)
                if(grid[r][c] == 1 && !visited[r][c]) {
                    int count = dfs(r, c, m, n, grid, visited);
                    if(count > 0) 
                        ans += count;
                }
            }
        }    
        return ans;
    }
    
    // UPDATE: 02/2022 This looks a bit complicated as the recursive dfs is trying to do more than one thing
    // using -ve numbers to detect out of bounds or number of connected ones that reach out to a border
    public static int dfs(int i, int j, int rows, int cols, int[][] grid, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= rows || j >= cols)
            return -1;
        
        if(grid[i][j] == 0 || visited[i][j])
            return 0;
        
        visited[i][j] = true;
        
        int top = dfs(i+1, j, rows, cols, grid, visited);
        int left = dfs(i, j-1, rows, cols, grid, visited);
        int down = dfs(i-1, j, rows, cols, grid, visited);
        int right = dfs(i, j+1, rows, cols, grid, visited);
        
        if(top < 0 || left < 0 || right < 0 || down < 0) return -1;
        
        return top+left+right+down+1;
    }

    // 02/08/2020: Simpler more standard form of DFS
    public int numEnclaves(int[][] grid) {
        
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1)
                    dfs(grid, i, j);
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    result++;
            }
        }
        
        return result;
    }
    
    public void dfs(int a[][], int i, int j) {
        if(i < 0 || i >= a.length || j < 0 || j >= a[i].length || a[i][j] == 0)
            return;

            a[i][j] = 0;

            dfs(a, i + 1, j);
            dfs(a, i - 1, j);
            dfs(a, i, j + 1);
            dfs(a, i, j - 1);
    }
}