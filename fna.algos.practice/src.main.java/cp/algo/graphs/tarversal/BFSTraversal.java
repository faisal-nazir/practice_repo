package cp.algo.graphs.tarversal;

import java.util.Deque;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;


public class BFSTraversal {
	
	int[] d;
	int[] parents;
	boolean[] visited;
	
	public void search(List<List<Integer>> g, int s) {
		if(g == null || s < 0) return;
		int n = g.size();
		visited = new boolean[n];
		d = new int[n];
		parents = new int[n];
		
		Deque<Integer> q = new LinkedList<>();
		q.offer(s);
		visited[s] = true;
		parents[s] = -1;
		int level = 0;
		
		while(!q.isEmpty()) {
			int size = q.size(); // corresponds to the number of nodes at this level
			for(int i = 0; i < size; ++i) {
				int curr = q.poll();
				for(int node : g.get(curr)) {
					if(!visited[node]) {
						visited[node] = true;
						parents[node] = curr;
						q.offer(node);
						//d[node] = d[curr] + 1;
					}
				}
				d[curr] = level;
			}
			++level;
		}
	}
	
	public static void main(String[] args) {
		int[][] edges = { {1, 2}, {1, 3}, {1, 4}, {2, 4}, {3, 4}, {2, 5}, {5, 7}, {5, 6}, {6, 4}, {7, 6}};
		int n = 7;
		List<List<Integer>> g = new ArrayList<List<Integer>>();
		for(int i = 0; i <= n; ++i) {
			g.add(new ArrayList<Integer>());
		}
		for(int[] edge : edges) {
			int s = edge[0];
			int d = edge[1];
			g.get(s).add(d);
		}
		
		BFSTraversal sol = new BFSTraversal();
		sol.search(g, 1);
		
		sol.print(sol.d);
		sol.printPath(sol.parents, 6);
		
	}
	
	public void print(int[] arr) {
		for(int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
	
	public void printPath(int[] parents, int d) {
		if(!visited[d]) {
			System.out.print("No path from exists " + d);
			return;
		}
		
		Deque<Integer> path = new LinkedList<>();
		int i = d; 
		while(i != -1) {
			path.addFirst(i);
			i = parents[i];
		}
		for(int n : path) {
			System.out.print(n + " -> ");
		}
	}
	
	

}
