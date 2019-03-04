package ctci.ds.graph;

import common.utils.Graph;
import common.utils.GraphNode;
import common.utils.GraphNode.State;

import java.util.LinkedList;

public class GraphComponents {

	public static int getNumberofComponents(Graph g) {
		if(g == null) return 0;
		clearStatus(g);
		int count = 0;
		for(GraphNode n : g.getAllNodes()) {
			if(n.state == State.UnExplored) {
				++count;
				bfs(n);
			}
		}
		return count;
	}
	
	public static void bfs(GraphNode n) {
		LinkedList<GraphNode> q = new LinkedList<>();
		n.state = State.Explored;
		q.addLast(n);
		GraphNode u;
		while(!q.isEmpty()) {
			u = q.removeFirst();
			if(u != null) {
				for(GraphNode adj : u.getAdjacents()) {
					if(adj.state == State.UnExplored) {
						q.addLast(adj);
						adj.state = State.Explored;
					}
				}
				u.state = State.Visited;
			}
		}
	}
	
	public static void clearStatus(Graph g) {
		for(GraphNode n : g.getAllNodes()) {
			n.state = State.UnExplored;
		}
	}
	
	public static Graph createGraph() {
		Graph g = new Graph();
		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");
		GraphNode c = new GraphNode("c");
		GraphNode d = new GraphNode("d");
		GraphNode e = new GraphNode("e");
		GraphNode f = new GraphNode("f");
		
		a.addAdjacent(b);
		b.addAdjacent(c);
		c.addAdjacent(d);
		e.addAdjacent(f);
		
		g.addNode(a);g.addNode(b);g.addNode(c);g.addNode(d);g.addNode(e);g.addNode(f);
		
		return g;
	}
	
	public static void main(String[] args) {
		Graph g = createGraph();
		System.out.println(getNumberofComponents(g));
		
	}
}
