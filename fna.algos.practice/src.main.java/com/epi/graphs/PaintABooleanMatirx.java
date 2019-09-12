package com.epi.graphs;

import java.util.*;

public class PaintABooleanMatirx {

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
			if(o == null || o.getClass() != Cell.class) return false;
			Cell c = (Cell)o;
			return Integer.compare(row, c.row) == 0 && 
						Integer.compare(col, c.col) == 0;
			
		}
		
		@Override
		public int hashCode( ) {
			return Objects.hash(row, col);
		}
	}
	
	public static void paint_bfs(boolean[][] matrix, int x, int y) {
		int[][] directions = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		boolean color = matrix[x][y];
		Queue<Cell> q = new LinkedList<>();
		Set<Cell> visited = new HashSet<>();
		
		
		matrix[x][y] = !color;
		q.add(new Cell(x, y));
		visited.add(new Cell(x, y));
		
		while(!q.isEmpty()) {
			Cell curr = q.poll();
			for(int[] dir : directions) {
				Cell next = new Cell(curr.row + dir[0], curr.col+ dir[1]);
				if(isValid(next, matrix, visited, color)) {
					matrix[next.row][next.col] = !color;
					q.add(next);
					visited.add(next);
				}
			}
		}
	}
	
	
	public static void paint_dfs(boolean[][] matrix, int x, int y) {
		Set<Cell> visited = new HashSet<>();
		helper(matrix, x, y, visited);
	}
	
	private static void helper(boolean[][] matrix, int x, int y, Set<Cell> visited) {
		int[][] directions = new int[][] { {1, 0}, { 0, 1}, {-1, 0}, {0, -1}};
		boolean color = matrix[x][y];
		
		matrix[x][y] = !color;
		visited.add(new Cell(x,y));
		
		for(int[] dir : directions) {
			Cell next = new Cell(dir[0]+x, dir[1]+y);
			if(isValid(next, matrix, visited, color)) {
				helper(matrix, next.row, next.col, visited);
			}
		}
	}
	
	private static boolean isValid(Cell c, boolean[][] matrix, Set<Cell> set, boolean color) {
		if(c.row < 0 || c.col < 0 || c.row >= matrix.length || c.col >= matrix[0].length || set.contains(c) || !color)
			return false;
		return true;
	}
}
