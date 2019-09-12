package com.epi.graphs;

import java.util.*;


public class SearchAMaze {
	
	// EPI-19.1: Search a maze

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
			if(o == null || getClass() != o.getClass()) return false;
			Cell other = (Cell)o;
			if(this.row != other.row || this.col != other.col) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(this.row, this.col);
		}
	}
	
	public static enum Color { WHITE, BLACK }
	
	public List<Cell> search(Color[][] maze, Cell s, Cell e) {
		List<Cell> path = new ArrayList<>();
		Set<Cell> visited = new HashSet<>();
		path.add(s);
		visited.add(s);
		if(!helper(maze, s, e, visited, path)) {
			path.remove(path.size()-1);
		}
		return path;
	}
	
	private boolean helper(Color[][] maze, Cell curr, Cell end, Set<Cell> visited, List<Cell> path) {
	
		if(curr.equals(end)) return true;
		
		int[][] states = new int[][] { {0, 1}, {1, 0}, { 0, -1}, {-1, 0}};
		
		for(int[] state : states) {
			Cell next = new Cell(curr.row + state[0], curr.col + state[1]);
			if(isValid(maze, next, visited)) {
				path.add(next);
				visited.add(next);
				if(helper(maze, next, end, visited, path))
					return true;
				path.remove(path.size()-1);
			}
		}
		return false;
	}
	
	private static boolean isValid(Color[][] maze, Cell c, Set<Cell> visited) {
		if(c.row < 0 || c.col < 0 || c.row >= maze.length || c.col >= maze[0].length || maze[c.row][c.col] == Color.BLACK || visited.contains(c))
			return false;
		return true;
	}
}
