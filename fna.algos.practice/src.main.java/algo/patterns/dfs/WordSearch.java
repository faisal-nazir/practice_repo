package algo.patterns.dfs;

public class WordSearch {

	private static final int[][] DIRS = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.length() == 0) return false;

        int m = board.length;
        int n = board[0].length;

        for(int r = 0; r < m; ++r) {
            for(int c = 0; c < n; ++c) {
                if(board[r][c] == word.charAt(0)) {
                    if(search(r, c, m, n, 0, board, word))
                        return true;
                }
            }
        }    
        return false;
    }

    public boolean search(int i, int j, int rows, int cols, int idx, char[][] grid, String word) {
        if(idx >= word.length()) return true;

        if(i < 0 || j < 0 || i >= rows || j >= cols)
            return false;

        if(grid[i][j] == '*' || grid[i][j] != word.charAt(idx)) return false;

        char t = grid[i][j];
        grid[i][j] = '*';
        
        for(int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            
            if(search(ni, nj, rows, cols, idx+1, grid, word))
                return true;
        }

        grid[i][j] = t;

        return false;
    }

}