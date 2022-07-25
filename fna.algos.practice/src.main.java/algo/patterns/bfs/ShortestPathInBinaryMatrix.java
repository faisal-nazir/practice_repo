package algo.patterns.bfs;

import java.util.*;

// Good Example of running BFS on a matrix
// Detailed explanation along with different techniques to maintain 2 levels
// https://leetcode.com/problems/shortest-path-in-binary-matrix/solution/
public class ShortestPathInBinaryMatrix {

	private int[][] DIRECTIONS = { {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    private int COLS = 0;
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int n = grid.length; // its an n*n matrix
        boolean[] visited = new boolean[n*n];
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
        COLS = n;
        Deque<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.add(0);
        
        int len = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            ++len;
            for(int i = 0; i < size; ++i) {
                int t = q.remove();
                
                if(getX(t) == n-1 && getY(t) == n-1) 
                    return len;
                
                for(int[] dir : DIRECTIONS) {
                    int nx = getX(t) + dir[0];
                    int ny = getY(t) + dir[1];
                    
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[getIndex(nx, ny)] || grid[nx][ny] != 0)
                        continue;
                    
                    q.add(getIndex(nx, ny));
                    visited[getIndex(nx, ny)] = true;
                }
            }
        }
        return -1;
    }
    
    private int getIndex(int r, int c) {
        return r * COLS + c;
    }
    
    private int getX(int idx) {
        return idx / COLS;
    }
    
    private int getY(int idx) {
        return idx % COLS;
    }

	
}