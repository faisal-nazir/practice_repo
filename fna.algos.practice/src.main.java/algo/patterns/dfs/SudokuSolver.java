package algo.patterns.dfs;

import java.util.*;

public class SudokuSolver {

	public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
     private boolean isValid(char[][] board, int row, int col, char num) {
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
            if(board[row][i] == num) return false;
            if(board[blkrow + i / 3][blkcol + i % 3] == num) return false;
        }
        return true;
    }
}