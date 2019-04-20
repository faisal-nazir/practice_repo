package pc.ds.graph.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/** Given a reference of a node in a connected undirected graph, 
 * return a deep copy (clone) of the graph. 
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

Example:



Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"}
,{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 

Note:

The number of nodes will be between 1 and 100.
The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
You must return the copy of the given node as a reference to the cloned graph.

**/

public class CloneGraph {
	// https://leetcode.com/problems/clone-graph/discuss/42309/Depth-First-Simple-Java-Solution
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return clone_dfs(node);
	}

	private UndirectedGraphNode clone_dfs(UndirectedGraphNode node) {
		if (node == null)
			return null;

		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(clone.label, clone);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			clone.neighbors.add(clone_dfs(neighbor));
		}
		return clone;
	}

	// https://leetcode.com/problems/clone-graph/discuss/42482/Java-BFS-solution
	// https://www.youtube.com/watch?v=vma9tCQUXk8
	public UndirectedGraphNode cloneGraph_bfs(UndirectedGraphNode root) {
		if (root == null)
			return null;

		// use a queue to help BFS
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(root);

		// use a map to save cloned nodes
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

		// clone the root
		map.put(root, new UndirectedGraphNode(root.label));

		while (!queue.isEmpty()) {
			UndirectedGraphNode node = queue.poll();

			// handle the neighbors
			for (UndirectedGraphNode neighbor : node.neighbors) {
				if (!map.containsKey(neighbor)) {
					// clone the neighbor
					map.put(neighbor, new UndirectedGraphNode(neighbor.label));
					// add it to the next level
					queue.add(neighbor);
				}

				// copy the neighbor
				map.get(node).neighbors.add(map.get(neighbor));
			}
		}

		return map.get(root);
	}

	static class UndirectedGraphNode {
		public int label;
		public List<UndirectedGraphNode> neighbors;

		public UndirectedGraphNode() {
		}

		public UndirectedGraphNode(int _label) {
			label = _label;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}

		public UndirectedGraphNode(int _val,
				List<UndirectedGraphNode> _neighbors) {
			label = _val;
			neighbors = _neighbors;
		}
	}
}
