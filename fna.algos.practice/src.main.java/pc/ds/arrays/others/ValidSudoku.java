package pc.ds.arrays.others;

import java.util.HashSet;

public class ValidSudoku {

	public static boolean isValidSudoku(String[][] board) {
        if(board == null || board.length == 0) return false;
        
        for(int i = 0; i < board.length; i++) {
            HashSet<String> rows = new HashSet();
            HashSet<String> cols = new HashSet();
            HashSet<String> box = new HashSet();
            
            for(int j = 0; j < board[i].length; ++j) {
                if(board[i][j] != "." && !rows.add(board[i][j]))
                    return false;
                if(board[j][i] != "." && !cols.add(board[j][i]))
                    return false;
                
                int topRow = 3 * (i / 3);
                int topCol = 3 * (i % 3);
                
               
                System.out.println("Top Row = " + topRow + " , " + "Top Col = " + topCol + " , " + "i = " + i + " , " + "j = " + j + " Box Entry: " + (topRow + j/3) + " , " + (topCol + j%3));
                
                if(board[topRow + j/3][topCol + j%3] != "." && !box.add(board[topRow + j/3][topCol + j%3]))        
                    return false;
                
            }
            System.out.println();
        }
        return true;
	}
	
	public static void main(String[] args) {
		String[][] board = { 
				{"5","3",".",".","7",".",".",".","."},
				{"6",".",".","1","9","5",".",".","."},
				{".","9","8",".",".",".",".","6","."},
				{"8",".",".",".","6",".",".",".","3"},
				{"4",".",".","8",".","3",".",".","1"},
				{"7",".",".",".","2",".",".",".","6"},
				{".","6",".",".",".",".","2","8","."},
				{".",".",".","4","1","9",".",".","5"},
				{".",".",".",".","8",".",".","7","9"}
				 };
						
		isValidSudoku(board);
	}
}
