package com.epi.graphs;

import java.util.*;

public class ComputeEnclosedRegions {

	// EPI-19.3: COMPUTE ENCLOSED REGIONS
	
	private static class Cell {
		int row;
		int col;
		
		Cell(int r, int c) {
			row = r;
			col = c;
		}
	}
	public static void computeRegions(char[][] A) {
		if(A == null || A.length == 0) return;
		boolean[][] visited = new boolean[A.length][A[0].length];
		for(int i = 0; i < A.length; ++i) {
			if(A[i][0] == 'W' && !visited[i][0]) {
				markRegion(i, 0, A, visited);
			}
			
			if(A[i][A[i].length-1] == 'W' && !visited[i][A[i].length-1]) {
				markRegion(i, A[i].length-1, A, visited);
			}
		}
		
		for(int j = 0; j < A[0].length; ++j) {
			if(A[0][j] == 'W' && !visited[0][j]) {
				markRegion(0, j, A, visited);
			}
			
			if(A[A.length-1][j] == 'W' && !visited[A.length-1][j]) {
				markRegion(A.length-1, j, A, visited);
			}
		}
		
		for(int i = 1; i < A.length-1; ++i) {
			for(int j = 1; j < A[i].length-1; ++j) {
				if(A[i][j] == 'W' && !visited[i][j])
					A[i][j] = 'B';
			}
		}
	}
	
	private static void markRegion(int r, int c, char[][] A, boolean[][] visited) {
		Deque<Cell> q = new LinkedList<>();
		int[][] directions = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
		
		visited[r][c] = true;
		q.add(new Cell(r,c));
		
		while(!q.isEmpty()) {
			Cell curr = q.poll();
			for(int[] dir : directions) {
				Cell next = new Cell(curr.row + dir[0], curr.col+ dir[1]);
				if(isValid(next, A, visited)) {
					q.add(next);
					visited[next.row][next.col] = true;
				}
			}
		}
	}
	
	private static boolean isValid(Cell c, char[][] A, boolean[][] visited) {
		if(c.row >= 0 && c.row < A.length && c.col >= 0 && c.col < A[c.row].length && A[c.row][c.col] == 'W' & !visited[c.row][c.col])
			return true;
		return false;
	}
}
