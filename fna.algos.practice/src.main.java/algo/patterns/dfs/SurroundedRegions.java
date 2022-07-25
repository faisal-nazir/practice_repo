package algo.patterns.dfs;

public class SurroundedRegions {

	// https://leetcode.com/submissions/detail/637618589/
	public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1)
                    dfs(board, i, j);
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                    
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '$')
                    board[i][j] = 'O';
                    
            }
        }
        
    }
    
    public void dfs(char a[][], int i, int j) {
        if(i < 0 || i >= a.length || j < 0 || j >= a[i].length || a[i][j] != 'O')
            return;

            a[i][j] = '$';

            dfs(a, i + 1, j);
            dfs(a, i - 1, j);
            dfs(a, i, j + 1);
            dfs(a, i, j - 1);
    }
}