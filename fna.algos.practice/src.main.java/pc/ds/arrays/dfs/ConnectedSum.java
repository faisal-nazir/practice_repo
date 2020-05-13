package pc.ds.arrays.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectedSum {

	// Assume a set of nodes from 1 to N.
	// Count number of nodes in each connected component
	// Take square root of each count then apply ceiling function
	// return sum of these computed numbers
	
	private static int count = 0;
	
	public static int connectedSum(int N, String[] connections) {
		if(N < 1 || connections.length == 0) return 0;
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int ans = 0;
		int singleNodes = 0;
		
		for(int i = 1; i <= N; ++i) {
			graph.put(i, new ArrayList<Integer>());
		}
		
		for(String connection : connections) {
			int u = connection.charAt(0) - '0';
			int v = connection.charAt(2) - '0';
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		boolean[] seen = new boolean[N+1];
		
		for(int i = 1; i <= N; ++i) {
			if(!seen[i]) {
				count = 0;
				dfs(graph, i, seen, N);
				System.out.println(count);
				if(count > 1) {
					ans += Math.ceil(Math.sqrt(count));
				} else if (count == 1) {
					++singleNodes;
				}
			}
		}
		
		ans += Math.ceil(Math.sqrt(singleNodes));
		return ans;
	}
	
	private static void dfs(Map<Integer, List<Integer>> graph, int curr_node, boolean[] seen, int N) {
		if(curr_node < 1 || curr_node > N) return;
		
		if(seen[curr_node]) return;
		
		++count;
		
		seen[curr_node] = true;
	
		for(Integer adj : graph.get(curr_node)) {
			dfs(graph, adj, seen, N);
		}
	}
	
	public static void main(String[] args) {
		int N = 8;
		String[] connections = new String[] { "1 8", "8 6", "3 7", "5 8"};
		System.out.println(connectedSum(8, connections));
	}
}
