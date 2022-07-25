package algo.patterns.bfs;

import java.util.*;

// Another good example of running BFS on a matrix
// few things to note here: 
// 1) The way Set<String> is used to keep track of seen/visited.
// 2) We don't need Queue to run level by level BFS if we are not interested in the which order child nodes are explored.
// 3) A new BFS will start form every orange that was rotten initially.

public class RottingOranges {

	private static final int[][] DIRS = { {0,1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();
        
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                if(grid[i][j] == 1) {
                    fresh.add("" + i + j);
                } else if (grid[i][j] == 2) {
                    rotten.add("" + i + j);
                }
            }
        }
        
        int minutes = 0;
        while(fresh.size() > 0) {
            Set<String> infected = new HashSet<>();
            for(String orange : rotten) {
                int x = orange.charAt(0) - '0'; 
                int y = orange.charAt(1) - '0';
                
                for(int[] dir : DIRS) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                
                    if(fresh.contains("" + nx + ny)) {
                        infected.add("" + nx + ny);
                        fresh.remove("" + nx + ny);
                    }    
                }
            }
            if(infected.size() == 0) return -1;
            rotten = infected;
            ++minutes;
        }
        
        return minutes;
    }

}