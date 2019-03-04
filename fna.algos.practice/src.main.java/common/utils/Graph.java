package common.utils;

public class Graph {
	private static int MAX_VERTICES = 6;
	private GraphNode[] vertices;
	private int count;
	
	public Graph() {
		vertices = new GraphNode[MAX_VERTICES];
		count = 0;
	}
	
	public GraphNode[] getAllNodes() {
		return vertices;
	}
	
	public void addNode(GraphNode n) {
		if(count < vertices.length){
			vertices[count++] = n;
		} else {
			System.out.println("Garph is full");
		}
	}
	
}
