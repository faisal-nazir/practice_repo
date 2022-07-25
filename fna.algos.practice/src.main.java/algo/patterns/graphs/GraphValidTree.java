package algo.patterns.graphs;

import java.util.*;

public class GraphValidTree {

	// A un-directed graph is valid tree if
	// 1. All nodes are connected
	// 2. There are no cycles

	public static boolean graphValidTree(int n, int[][] edges) {
		boolean[] visited = new boolean[n];
		
		Map<Integer, ArrayList<Integer>> g = new HashMap<>();
		for(int i = 0; i < n; i++) {
			g.put(i, new ArrayList<Integer>());
		}

		for(int i = 0; i < edges.length; i++) {
			g.get(edges[i][0]).add(edges[i][1]);
			g.get(edges[i][1]).add(edges[i][0]);
		}

		// start the DFS from any node since we are expecting the graph to be reachable from any starting node.
		if(isCyclic(n, 0, -1, g, visited))
			return false;

		// graph CAN NOT be disconnected to be a valid tree
		for(int i = 0; i < n; i++) {
			if(!visited[i])
				return false;
		}

		return true;
	}

	public static boolean isCyclic(int n, int idx, int parent, Map<Integer, ArrayList<Integer>> g, boolean[] visited) {

		visited[idx] = true;

		for(int v : g.get(idx)) {
			if(!visited[v]) {
				if(isCyclic(n, v, idx, g, visited))
					return true;
			}
			else if(v != parent)
				return true;
		}

		return false;        
	} 
    
	public static void main(String[] args) {
		int[][] edges = { {0, 2}, {1, 2}, {2, 3}, {2, 4}, {3, 4}, {4, 5}, {5, 6}};
		int n = 7;
		System.out.print(graphValidTree(n, edges));
	}
}