package common.utils;

import java.util.LinkedList;

public class GraphNode {
	
	public static enum State  { UnExplored, Explored, Visited };

	private String id;
	public State state;
	private LinkedList<GraphNode> adjacents;
	
	public GraphNode(String idx) {
		this.id = idx;
		this.state = State.UnExplored;
		adjacents = new LinkedList<GraphNode>();
	}
	
	public LinkedList<GraphNode> getAdjacents() {
		return adjacents;
	}
	
	public String getVertex() {
		return id;
	}
	
	public void addAdjacent(GraphNode n) {
		adjacents.addFirst(n);
	}
}
