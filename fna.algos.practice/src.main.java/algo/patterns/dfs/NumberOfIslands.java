package algo.patterns.dfs;

public class NumberOfIslands {

	private static int[][] DIRS = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if(grid[i][j] == '1') {
                    ++count;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1')
            return;
        
        grid[i][j] = 'x';
        
        for(int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            dfs(grid, ni, nj);
        }
    }

    public static void main(String[] args) {
		char[][] g = new char[][] { {'1', '0', '0', '0', '1'}, 
									{'1', '0', '0', '0', '1'},
									{'1', '0', '0', '0', '1'},
									{'1', '0', '0', '0', '1'}};
		System.out.print(numIslands(g));
	}
}