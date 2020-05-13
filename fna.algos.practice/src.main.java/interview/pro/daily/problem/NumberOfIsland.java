package interview.pro.daily.problem;

import java.util.*;

/* 
 ***** Number of Islands ********
 * Given a 2d grid map of '1's (land) and '0's (water), 
 * count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.

	Example 1:
	
	Input:
	11110
	11010
	11000
	00000
	
	Output: 1
	Example 2:
	
	Input:
	11000
	11000
	00100
	00011
	
	Output: 3
*/

public class NumberOfIsland {
	
//	private static class Cell {
//		int row;
//		int col;
//		
//		Cell(int r, int c) {
//			this.row = r;
//			this.col = c;
//		}
//		
//		@Override
//		public boolean equals(Object o) {
//			if(this == o) return true;
//			if(o == null || o.getClass() != this.getClass()) return false;
//			Cell other = (Cell)o;
//			return this.row == other.row && this.col == other.col;
//		}
//		
//		@Override
//		public int hashCode() {
//			return Objects.hash(this.row, this.col);
//		}
//	}
	
	public static int noOfIsland(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int count = 0;
	
		for(int i = 0; i < grid.length; ++i) {
			for(int j = 0; j < grid[i].length; ++j) {
				if(grid[i][j] == '1') {
					++count;
					System.out.println(i + "," + j);
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}
	
	private static void dfs(char[][] grid, int row, int col) {
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) 
			return;
		
		if(grid[row][col] != '1')
			return;
		
		grid[row][col] = 'x';
		
		int[][] DIRS = new int[][] { {1, 0}, {0, 1}, { -1, 0}, {0, -1} };
		
		for(int[] dir : DIRS) {
		
			int nr = row + dir[0];
			int nc = col + dir[1];
			
			dfs(grid, nr, nc);
			
		}
	}
	
	public static void main(String[] args) {
		char[][] g = new char[][] { {'1', '0', '0', '0', '1'}, 
									{'1', '0', '0', '0', '1'},
									{'1', '0', '0', '0', '1'},
									{'1', '0', '0', '0', '1'}};
		System.out.print(noOfIsland(g));
	}

}
