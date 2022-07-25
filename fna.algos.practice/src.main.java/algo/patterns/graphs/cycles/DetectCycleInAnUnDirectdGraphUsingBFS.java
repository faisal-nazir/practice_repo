package algo.patterns.graphs.cycles;

import java.util.*;

public class DetectCycleInAnUnDirectdGraphUsingBFS {

	// Detect cycle in an un-directed graph using BFS

	public static boolean isCyclic(int n, int[][] edges) {
		boolean[] visited = new boolean[n];
		int[] parent = new int[n];
		Arrays.fill(parent, -1);


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
				isCyclic(n, i, g, visited, parent);
					return true;
		}

		return false;
	}

	public static boolean isCyclic(int n, int s, Map<Integer, ArrayList<Integer>> g, boolean[] visited, int[] parent) {
        
		Deque<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.offer(s);

		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v : g.get(u)) {
				if(!visited[v]) {
					visited[v] = true;
					q.offer(v);
					parent[v] = u;
				} else {
					if(parent[u] != v)
						return true;
				}
			}
		}

		return false;
	} 
    

	public static void main(String[] args) {
		int[][] edges = { {1, 2}, {2, 3}, {3, 1}, {3, 4}, {5, 6}};
		int n = 7;
		System.out.print(isCyclic(n, edges));
	}
}