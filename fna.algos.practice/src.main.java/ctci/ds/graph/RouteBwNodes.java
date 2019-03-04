package ctci.ds.graph;

import common.utils.Graph;
import common.utils.GraphNode;
import common.utils.GraphNode.State;

import java.util.LinkedList;

public class RouteBwNodes {

	public static boolean search(Graph g, GraphNode start, GraphNode end) {
		if(start == null || end == null) return false;
		if(start == end) return true;
		LinkedList<GraphNode> q = new LinkedList<GraphNode>();
		
		for(GraphNode n : g.getAllNodes()) {
			n.state = State.UnExplored;
		}
		q.addFirst(start);
		start.state = State.Explored;
		GraphNode u;
		while(!q.isEmpty()) {
			u = q.removeLast();
			if(u != null) {
				for(GraphNode adj : u.getAdjacents()) {
					if(adj.state == State.UnExplored) {
						if(adj == end) {
							return true;
						}
						else {
							q.addFirst(adj);
							adj.state = State.Explored;
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
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
		b.addAdjacent(a);
		b.addAdjacent(c);
		c.addAdjacent(d);
		d.addAdjacent(a);
		d.addAdjacent(e);
		a.addAdjacent(f);
		e.addAdjacent(f);
		
		g.addNode(a);g.addNode(b);g.addNode(c);g.addNode(d);g.addNode(e);g.addNode(f);
		
		return g;
	}
	
	public static void main(String[] args) {
		Graph g = createGraph();
		GraphNode[] nodes = g.getAllNodes();
		GraphNode start = nodes[0];
		GraphNode end = nodes[5];
		System.out.println(search(g, start, end));
		
	}
}
