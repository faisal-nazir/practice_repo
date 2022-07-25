package algo.patterns.graphs.cycles;

import java.util.*;

public class DetectCycleInADirectdGraphUsingDFS {

	// Detect cycle in a directed graph using DFS

	public static boolean isCyclic(int n, int[][] edges) {
		// maintain a visited array, 0 = unvisited, -1 = visting, 1 = visited
		int[] visited = new int[n];
		
		Map<Integer, ArrayList<Integer>> g = new HashMap<>();
		for(int i = 0; i < n; i++) {
			g.put(i, new ArrayList<Integer>());
		}

		for(int i = 0; i < edges.length; i++) {
			g.get(edges[i][1]).add(edges[i][0]);
		}

		// graph can be disconnected
		for(int i = 0; i < n; i++) {
			if(isCyclic(n, i, g, visited))
				return true;
		}
		return false;
	}

	public static boolean isCyclic(int n, int idx, Map<Integer, ArrayList<Integer>> g, int[] visited) {
		// if we run into a node that we have seen in this CURRENT DFS, then its a cycle
		if(visited[idx] == -1) return true;

		// if we come across a node that we saw in a separate DFS earlier, then there is no problem
		if(visited[idx] == 1) return false;

		// mark the current node as -1 (currently visiting (part of current exploration))
		// ================  Node Entery ================================
		visited[idx] = -1;

		// get all the neighbors of this node

		for(int v : g.get(idx)) {
			// dfs in to all neighbors and return true if we find a cycle

			// ================  Edge Entery ================================

			if(isCyclic(n, v, g, visited))
				return true;

			// ================  Edge Exit ================================
			// we bracktarck (un-choose) at this point
		}

		// if all its neighbors were visited and there are no issues
		// then we mark the current node as 1 (completely visited).

		// ================  Node Exit ================================
		visited[idx] = 1;

		return false;        
	} 
    

	public static void main(String[] args) {
		int[][] edges = { {0, 1}, {1, 2,}, {3, 2}, {4, 3}, {2, 4}};
		int n = 5;
		System.out.print(isCyclic(n, edges));
	}
}