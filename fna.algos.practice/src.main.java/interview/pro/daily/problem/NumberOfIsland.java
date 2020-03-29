package interview.pro.daily.problem;

import java.util.*;

public class NumberOfIsland {
	
	private static class Cell {
		int row;
		int col;
		
		Cell(int r, int c) {
			this.row = r;
			this.col = c;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null || o.getClass() != this.getClass()) return false;
			Cell other = (Cell)o;
			return this.row == other.row && this.col == other.col;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(this.row, this.col);
		}
	}
	
	public static int noOfIsland(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int count = 0;
	
		
		for(int i = 0; i < grid.length; ++i) {
			for(int j = 0; j < grid[i].length; ++j) {
				if(grid[i][j] == 1) {
					++count;
					solve(grid, i, j);
				}
			}
		}
		return count;
	}
	
	private static void solve(int[][] grid, int row, int col) {
		int[][] DIRS = new int[][] { {1, 0}, {0, 1}, { -1, 0}, {0, -1} };
		
		grid[row][col] = -1;
		for(int[] dir : DIRS) {
			Cell next = new Cell(row+dir[0], col+dir[1]);
			if(isValid(grid, next)) {
				solve(grid, next.row, next.col);
			}
		}
	}
	
	private static boolean isValid(int[][] grid, Cell c) {
		return c.row >= 0 && c.row < grid.length && c.col >= 0 && c.col < grid[0].length && grid[c.row][c.col] == 1;
	}
	
	public static void main(String[] args) {
		int[][] g = new int[][] { {1, 0, 0, 0, 1}, 
								  {1, 1, 0, 0, 0},
								  {1, 0, 1, 1, 0},
								  {0, 0, 0, 0, 0}};
		System.out.print(noOfIsland(g));
	}

}
