package pc.ds.arrays.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumMinimumElements {

	/** Sum of the minimum elements in all connected components of an undirected graph **/
	//private static int min = Integer.MAX_VALUE;
	
	public static int SumMinimumElements(int N, String[] connections) {
		if(N < 1 || connections.length == 0) return 0;
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int ans = 0;		
		int min = 0;
		
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
				//min = i;
				min = dfs(graph, i, seen, N);
				System.out.println(min);
				ans += min;
			}
		}
		
		return ans;
	}
	
	private static int dfs(Map<Integer, List<Integer>> graph, int curr_node, boolean[] seen, int N) {
		if(curr_node < 1 || curr_node > N) return Integer.MAX_VALUE;
		
		if(seen[curr_node]) return Integer.MAX_VALUE;
		
		seen[curr_node] = true;
	
		int min = curr_node;
		for(Integer adj : graph.get(curr_node)) {
			min = Math.min(min, dfs(graph, adj, seen, N));
		}
		return min;
	}
	
	public static void main(String[] args) {
		int N = 8;
		String[] connections = new String[] { "2 8", "8 6", "3 7", "5 8", "1 4"};
		System.out.println(SumMinimumElements(8, connections));
	}
}
