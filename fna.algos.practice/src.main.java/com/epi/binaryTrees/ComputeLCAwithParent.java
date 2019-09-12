package com.epi.binaryTrees;

public class ComputeLCAwithParent {

	private static class Node {
		int value;
		Node right;
		Node left;
		Node parent;
		
		Node(int val) {
			this.value = val;
		}
	}
	public static Node getLCA(Node root, Node p, Node q) {
		int dep_p = getDepth(p);
		int dep_q = getDepth(q);
		Node shallower = (dep_p < dep_q)? p : q;
		Node deeper = (dep_p < dep_q)? q : p;
		int diff = (dep_p > dep_q)? dep_p - dep_q : dep_q - dep_p;
		while(diff-- > 0) {
			deeper = deeper.parent;
		}
		
		while(shallower != deeper) {
			shallower = shallower.parent;
			deeper = deeper.parent;
		}
		
		return shallower;
	}
	
	public static int getDepth(Node n) {
		int dep = 0;
		while(n.parent != null) {
			++dep;
			n = n.parent;
		}
		return dep;
	}
}
