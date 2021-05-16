package ctci.ds.graph;

public class ShortestPathWithKEdges {

	/** Shortest path with exactly k edges in a directed and weighted graph
	 * https://www.geeksforgeeks.org/shortest-path-exactly-k-edges-directed-weighted-graph/
	 */
	public static final Integer INF = Integer.MAX_VALUE;
	
	public int shortestPath(int[][] graph, int u, int v, int k) {
		if(graph == null || graph.length == 0 || k < 0) return INF;
		return helper(graph, u, v, k);
	}
	
	public int helper(int[][] graph, int u, int v, int k) {
		if(u == v && k == 0) return 0;
		if(k == 1 && graph[u][v] != INF) return graph[u][v];
		if(k <= 0) return 0;	
		
		int min = INF;
		for(int i = 0; i < graph.length; ++i) {
			if(graph[u][i] != INF && u != i && v != i) {
				int rec_min = helper(graph, i, v, k-1);
				if(rec_min != INF)
					min = Math.min(min, rec_min + graph[u][i]);
			}
		}
		return min;
	}
	
	public static void main (String[] args) 
    { 
        /* Let us create the graph shown in above diagram*/
        int graph[][] = new int[][]{ {0, 10, 3, 2}, 
                                     {INF, 0, INF, 7}, 
                                     {INF, INF, 0, 6}, 
                                     {INF, INF, INF, 0} 
                                   }; 
        ShortestPathWithKEdges t = new ShortestPathWithKEdges(); 
        int u = 0, v = 3, k = 2; 
        System.out.println("Weight of the shortest path is "+ 
                           t.shortestPath(graph, u, v, k)); 
    } 
}
