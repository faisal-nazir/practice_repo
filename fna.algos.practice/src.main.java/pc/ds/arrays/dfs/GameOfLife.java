package pc.ds.arrays.dfs;

public class GameOfLife {

	/** According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
	 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

		Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
		Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the 
		following four rules (taken from the above Wikipedia article):
		
		Any live cell with fewer than two live neighbors dies, as if caused by under-population.
		Any live cell with two or three live neighbors lives on to the next generation.
		Any live cell with more than three live neighbors dies, as if by over-population..
		Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
		Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
		
		Example:
		
		Input: 
		[
		  [0,1,0],
		  [0,0,1],
		  [1,1,1],
		  [0,0,0]
		]
		Output: 
		[
		  [0,0,0],
		  [1,0,1],
		  [0,1,1],
		  [0,1,0]
		]
	 **/
	
	// https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation
	// below solution is combination of Laiq's submission and the one mentioned above.
	public static void gameOfLife(int[][] board) {
	    if (board == null || board.length == 0) return;
	    int r = board.length, c = board[0].length;
	    
	    int dx[] = {-1, -1, 0, +1, +1, +1,  0, -1};
        int dy[] = { 0, +1, 1, +1,  0, -1, -1, -1};

	    for (int i = 0; i < r; i++) {
	        for (int j = 0; j < c; j++) {
	            int lives = 0;
	            for(int k = 0; k < 8; ++k) {
	            	int ni = i+dx[k];
                    int nj = j+dy[k];
                    if (ni<0 || ni>=r) continue;
                    if (nj<0 || nj>=c) continue;
                    
                    lives += (board[ni][nj] & 1);
	            }

	            // In the beginning, every 2nd bit is 0;
	            // So we only need to care about when will the 2nd bit become 1.
	            if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
	                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
	            }
	            if (board[i][j] == 0 && lives == 3) {
	                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
	            }
	        }
	    }

	    for (int i = 0; i < r; i++) {
	        for (int j = 0; j < c; j++) {
	            board[i][j] >>= 1;  // Get the 2nd state.
	        }
	    }
	}

}
