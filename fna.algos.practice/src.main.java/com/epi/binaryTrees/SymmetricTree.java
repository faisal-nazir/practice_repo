package com.epi.binaryTrees;

public class SymmetricTree {

	private static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int val) {
			this.value = val;
		}
	}
	
	public static boolean isSymmetric(Node root) {
		return isSymmetric(root, root);
	}
	
	private static boolean isSymmetric(Node n, Node m) {
		if(m == null && n == null) return true;
		if(m == null || n == null) return false;
		return m.value == n.value && isSymmetric(n.left, m.right) && isSymmetric(n.right, m.left);
	}
	
	public static void main(String[] args) {
		Node t = getTree();
		
		System.out.print(isSymmetric(t, t));
	}
	
	public static Node getTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.right.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		
		return root;
	}
}
