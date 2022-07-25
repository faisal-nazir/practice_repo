package algo.patterns.dfs;

public class NumberofClosedIslands {

	public int closedIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int r = 1; r < m-1; ++r) {
            for(int c = 1; c < n-1; ++c) {
                if(grid[r][c] == 0 && !visited[r][c]) {
                    int count = dfs(r, c, m, n, grid, visited);
                    if(count > 0) 
                        ans += count;
                }
            }
        }    
        return ans;
    }
    
    public int dfs(int i, int j, int rows, int cols, int[][] grid, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= rows || j >= cols)
            return -1;
        
        if(grid[i][j] == 1 || visited[i][j])
            return 0;
        
        visited[i][j] = true;
        
        int top = dfs(i+1, j, rows, cols, grid, visited);
        int left = dfs(i, j-1, rows, cols, grid, visited);
        int down = dfs(i-1, j, rows, cols, grid, visited);
        int right = dfs(i, j+1, rows, cols, grid, visited);
        
        if(top < 0 || left < 0 || right < 0 || down < 0) return -1;
        
        return 1;
    }
}