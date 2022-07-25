package algo.patterns.dfs;

public class IslandPerimeter {

    private static final int[][] DIR =  { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
	// https://leetcode.com/problems/island-perimeter/submissions/
	public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int ans = 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int i = 0, j = 0;
        
        for(int r = 0; r < m; ++r) {
            for(int c = 0; c < n; ++c) {
                if(grid[r][c] == 1) {
                    return dfs(r, c, m, n, grid, visited);
                }
            }
        }
        
        return 0;
        
    }
    
    public int dfs(int i, int j, int rows, int cols, int[][] grid, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0)
            return 1;
        
        if(visited[i][j])
            return 0;
        
        visited[i][j] = true;
        
        int count = 0;
        for(int[] dir : DIR) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            
            int tmp = dfs(ni, nj, rows, cols, grid, visited);
            count += tmp;
        }
        
        return count;
    }
}