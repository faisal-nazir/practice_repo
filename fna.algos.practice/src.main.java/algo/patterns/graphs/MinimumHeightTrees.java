package algo.patterns.graphs;

import java.util.*;

public class MinimumHeightTrees {

	public static List<Integer> minHeightTrees(int n, int[][] edges) {
		// if there is only one node then that is the root
		if (n == 1) return Collections.singletonList(0);
		// set up the adjacency list
		List<Set<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			graph.add(i, new HashSet<>());
		}
		for(int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		// keep track of all the leaves (nodes on the edges of the graph with only one neighbor)
		List<Integer> leaves = new ArrayList<>();
		for(int i = 0; i < n; ++i) {
			// if this node has only one neighbor i.e indegree == 1 then its a leaf
			if(graph.get(i).size() == 1) {
				leaves.add(i);
			}
		}

		// keep removing leaves until there is at most 2 nodes left on the graph
		while(n > 2) {
			// update the total number of nodes in the graph, after we remove the leaves
			n -= leaves.size();

			// temperory array to hold the new leaves for next level
			List<Integer> newLeaves = new ArrayList<>();

			// remove each of the current leaves
			for(int i : leaves) {
				// get this leaf's one and only one neighbor
				int j = graph.get(i).iterator().next();
				// remove this leaf form its neighbor's list
				graph.get(j).remove(i);
				// check if the neighbor has become leaf it self i.e indegree == 1
				if(graph.get(j).size() == 1) {
					newLeaves.add(j);
				}
			}
			// once the current leaves are removed, contiue the process with the new leaves until we reach the root
			leaves = newLeaves;
		}
		// at the end there will be only 1 or 2 leaves left
		return leaves;
	}

	public static void main(String[] args) {
		int[][] edges = { {3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
		int n = 6;
		List<Integer> res = minHeightTrees(n, edges);
		print(res);
	}

	private static void print(List<Integer> list) {
		for(int n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}