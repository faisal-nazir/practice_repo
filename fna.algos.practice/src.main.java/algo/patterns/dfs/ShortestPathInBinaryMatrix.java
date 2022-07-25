package algo.patterns.dfs;

public class ShortestPathInBinaryMatrix {

private static int[][] DIRECTIONS = { {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    
    // DFS will explore all paths to destination and we will need to take a min from these paths.
    // better solution will be to use BFS instead.

    // 
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return search(0, 0, m, n, visited, grid);
    }
    
    private static int search(int i, int j, int m, int n, boolean[][] visited, int[][] grid) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 1 || visited[i][j]) 
            return -1;
        
        if(i == m-1 && j == n-1) return 1;
        
        visited[i][j] = true;
        
        int len = Integer.MAX_VALUE;
        for(int[] dir : DIRECTIONS) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            int t = search(x, y, m, n, visited, grid);
            if( t > 0) {
                len = Math.min(len, t);
            }
        }
        
        visited[i][j] = false;
        
        return len == Integer.MAX_VALUE ? -1 : len+1;
    }
    
    public static void main(String[] args) {
    	int[][] grid = { {0, 1}, {1, 0}};
    	System.out.print(shortestPathBinaryMatrix(grid));
    }
}
