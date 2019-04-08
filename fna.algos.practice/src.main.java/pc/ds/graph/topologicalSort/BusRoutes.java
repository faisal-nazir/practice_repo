package pc.ds.graph.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. 
 * For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed)
 * travels in the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T. 
Travelling by buses only, what is the least number of buses we must take to reach our destination?
Return -1 if it is not possible.

Example:
Input: 
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation: 
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Note:

1 <= routes.length <= 500.
1 <= routes[i].length <= 500.
0 <= routes[i][j] < 10 ^ 6.

 */
public class BusRoutes {
	//https://leetcode.com/problems/bus-routes/discuss/122712/Simple-Java-Solution-using-BFS
	
	// [FNA]: The idea is to build graph by tracking what other stops are reachable from the start location.
	// then building the reachable stops for each of these stops in similar manner. Traverse the graph in 
	// a level order fashion, starting form the 'S' stop and finding the destination stop 
	// would yield the answer in the form of 'level'.
	public int numBusesToDestination(int[][] routes, int S, int T) {
	       HashSet<Integer> visited = new HashSet<>();
	       Queue<Integer> q = new LinkedList<>();
	       HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	       int count = 0; 
	        
	       if (S==T) return 0; 
	        
	       for(int i = 0; i < routes.length; i++){
	            for(int j = 0; j < routes[i].length; j++){
	                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<Integer>());
	                buses.add(i);
	                map.put(routes[i][j], buses);                
	            }       
	        }
	                
	       q.offer(S); 
	       while (!q.isEmpty()) {
	           int len = q.size();
	           count++;
	           for (int i = 0; i < len; i++) {
	               int cur = q.poll();
	               ArrayList<Integer> buses = map.get(cur);
	               for (int bus: buses) {
	                    if (visited.contains(bus)) continue;
	                    visited.add(bus);
	                    for (int j = 0; j < routes[bus].length; j++) {
	                        if (routes[bus][j] == T) return count;
	                        q.offer(routes[bus][j]);  
	                   }
	               }
	           }
	        }
	        return -1;
	    }
}

