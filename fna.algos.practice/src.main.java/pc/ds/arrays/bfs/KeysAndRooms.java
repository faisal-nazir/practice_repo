package pc.ds.arrays.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

	// my accepted solution - classic BFS
	//https://leetcode.com/problems/keys-and-rooms/
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        Queue<Integer> keys = new LinkedList<>();
        seen[0] = true;
        keys.add(0);
        while(!keys.isEmpty()) {
            int curr_key = keys.poll();
            for(int newKey : rooms.get(curr_key)) {
                if(!seen[newKey]) {
                    seen[newKey] = true;
                    keys.add(newKey);
                }    
            }
        }
        
        for(boolean visited : seen) {
            if(!visited) 
                return false;
        }
        
        return true;
    }
}
