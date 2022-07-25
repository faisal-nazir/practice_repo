package algo.patterns.graphs.cycles;

import java.util.*;

public class DetectCycleInADirectdGraphUsingBFS {

	// Detect cycle in a directed graph using BFS

	public static boolean isCyclic(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> g = new HashMap<>();
        int[] indegree = new int[n];

		for(int i = 0; i < n; ++i) {
			g.put(i, new ArrayList<Integer>());
		}

		for(int i = 0; i < edges.length; ++i) {
			indegree[edges[i][0]]++;
			g.get(edges[i][1]).add(edges[i][0]);
		}

		Deque<Integer> q = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			if(indegree[i] == 0)
				q.offer(i);
		}

		if(q.isEmpty()) return true;

		int count = 0;
		while(!q.isEmpty()) {
			int u = q.poll();
			++count;

			for(int v : g.get(u)) {
				indegree[v]--;
				if(indegree[v] == 0) 
					q.offer(v);
			}
		}

		return count != n;
	} 
    

	public static void main(String[] args) {
		int[][] edges = { {0, 1}, {1, 2,}, {3, 2}, {4, 3}, {2, 4}};
		int n = 5;
		System.out.print(isCyclic(n, edges));
	}
}