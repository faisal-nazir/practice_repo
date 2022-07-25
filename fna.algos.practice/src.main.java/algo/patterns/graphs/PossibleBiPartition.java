package algo.patterns.graphs;

import java.util.*;

public class PossibleBiPartition {

	// Check if a mapraph is Bi-Partitie
	public static boolean biPartitieGraph(int N, int[][] dislikes) {

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			map.put(i, new ArrayList<Integer>());
		}

		for(int i = 0; i < dislikes.length; i++) {
			map.get(dislikes[i][0]).add(dislikes[i][1]);
			map.get(dislikes[i][1]).add(dislikes[i][0]);
		}

		// create visited array where 0: Not Visited, -1: 'maproup A', 1:'maproup B'
		int[] visited = new int[N];

		// attempt to DFS from each node so we can find different connected components
		for(int i = 0; i < N; i++) {
			// if the DFS finds two neighbors with the same group, then return false.
			// since we haven't visited this connected component yet, it doesn't matter whether 
			// we assimapn this first node a '1' or '-1'.
			if(visited[i] == 0)
				if(!cangroup(i, -1, map, visited))
					return false;
		}
		return true;
	}

	public static boolean cangroup(int person, int group, Map<Integer, ArrayList<Integer>> map, int[] visited) {
		// put this person in indicated group/color
		visited[person] = group;

		// check all neighbors of this node
		for(int v : map.get(person)) {
			// if any of those neighbors belong to the same group, party's over
			if(visited[v] == group)
				return false;
			// if any of the neighbor is not being visited yet, visit it and assign it to the opposite group
			if(visited[v] == 0 && !cangroup(v, -group, map, visited))
				return false;
			// the third case is if a neighbor is alreay in the opposite group, no need to DFS there
		} 

		// if every thing works out and the DFS didn't run into any issues with the neighbors, the we are good	
		return true;        
	} 
    
	public static void main(String[] args) {
		int[][] edges = { {0, 2}, {1, 2}, {2, 3}, {2, 4}, {3, 4}, {5, 6}};
		int n = 7;
		System.out.print(biPartitieGraph(n, edges));
	}
}