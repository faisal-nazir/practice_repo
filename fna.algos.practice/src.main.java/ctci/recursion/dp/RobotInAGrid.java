package ctci.recursion.dp;

import java.util.ArrayList;
import java.util.HashSet;

import common.utils.Point;

public class RobotInAGrid {
	
	private static class Question_A {
		public static ArrayList<Point> getPath(boolean[][] maze) {
			if (maze == null || maze.length == 0) return null;
			ArrayList<Point> path = new ArrayList<Point>();
			if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
				return path;
			}
			return null;
		}	
		
		public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
			// If out of bounds or not available, return.
			if (col < 0 || row < 0 || !maze[row][col]) {
				return false;
			}
			
			boolean isAtOrigin = (row == 0) && (col == 0);
			
			// If there's a path from the start to my current location, add my location.
			if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) { 
				Point p = new Point(row, col);
				path.add(p);
				return true;
			}
			
			return false;
		}
	}
	
	private static class Question_B {
		public static ArrayList<Point> getPath(boolean[][] maze) {
			if (maze == null || maze.length == 0) return null;
			ArrayList<Point> path = new ArrayList<Point>();
			HashSet<Point> failedPoints = new HashSet<Point>();
			if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
				return path;
			}
			return null;
		}
		
		public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
			/* If out of bounds or not available, return.*/
			if (col < 0 || row < 0 || !maze[row][col]) {
				return false;
			}
			
			Point p = new Point(row, col);
			
			/* If we've already visited this cell, return. */
			if (failedPoints.contains(p)) { 
				return false;
			}	
			
			boolean isAtOrigin = (row == 0) && (col == 0);
			
			/* If there's a path from the start to my current location, add my location.*/
			if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
				path.add(p);
				return true;
			}
			
			failedPoints.add(p); // Cache result
			return false;
		}
	}
	
}
