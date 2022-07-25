package algo.patterns.graphs.cycles;

import java.util.*;

public class DetectCycleInAnUnDirectdGraphUsingDFS {

	// Detect cycle in an un-directed graph using DFS

	public static boolean isCyclic(int n, int[][] edges) {
		boolean[] visited = new boolean[n];
		
		Map<Integer, ArrayList<Integer>> g = new HashMap<>();
		for(int i = 0; i < n; i++) {
			g.put(i, new ArrayList<Integer>());
		}

		for(int i = 0; i < edges.length; i++) {
			g.get(edges[i][0]).add(edges[i][1]);
			g.get(edges[i][1]).add(edges[i][0]);
		}

		// graph can be disconnected
		for(int i = 0; i < n; i++) {
			if(!visited[i])
				isCyclic(n, i, -1, g, visited);
					return true;
		}
		return false;
	}

	public static boolean isCyclic(int n, int idx, int parent, Map<Integer, ArrayList<Integer>> g,
									 boolean[] visited) {

		visited[idx] = true;

		for(int v : g.get(idx)) {
			// If an adjacent is not visited, then recur for that adjacent
			if(!visited[v]) {
				if(isCyclic(n, v, idx, g, visited))
					return true;
			}
			// If an adjacent is visited and not parent of current vertex, then there is a cycle
			else if(v != parent)
				return true;
		}

		return false;        
	} 
    
	public static void main(String[] args) {
		int[][] edges = { {0, 2}, {1, 2}, {2, 3}, {3, 4}, {5, 6}};
		int n = 7;
		System.out.print(isCyclic(n, edges));
	}
}