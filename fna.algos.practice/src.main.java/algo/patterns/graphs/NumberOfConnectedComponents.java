package algo.patterns.graphs;

import java.util.*;

public class NumberOfConnectedComponents {
	
	public static int connectedComponents(int n, int[][] edges) {
		if(edges == null || edges.length == 0 || n <= 0) return 0;

		Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
		for(int i = 0; i < n; i++) {
			adj.put(i, new ArrayList<Integer>());
		}

		for(int i = 0; i < edges.length; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}

		boolean[] visited = new boolean[n];

		int count = 0;
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				++count;
				dfs(adj, visited, i);
			}
		}

		return count;
	}

	public static void dfs(Map<Integer, ArrayList<Integer>> adj, boolean[] visited, int idx) {
		visited[idx] = true;

		for(int j : adj.get(idx)) {
			if(!visited[j]) {
				dfs(adj, visited, j);
			}
		}
	}

	public static void main(String[] args) {
		int[][] edges = { {0, 1}, {1, 2}, {2, 0}, {3, 4}};
		int n = 5;
		System.out.println(connectedComponents(n, edges));
	}	

}