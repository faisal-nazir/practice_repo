package ctci.ds.tree;

import common.utils.TreeNode;

public class Successor {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		
		public Node(int val, Node parent) {
			this.value = val;
			this.parent = parent;
		}
	}
	
	public static Node findSuccessor(Node root) {
		if(root == null) return null;
		if(root.right != null) return getLeftMostNode(root.right);
		return getParentWithNextValue(root);
		
	}
	
	public static Node getLeftMostNode(Node n) {
		if(n == null) return n;
		while(n.left != null) n = n.left;
		return n;
	}
	
	public static Node getParentWithNextValue(Node n) {
		if(n == null) return null;
		Node curr = n;
		Node parent = curr.parent;
		while(parent != null && parent.left != curr) {
			curr = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	//TODO: test the successor method of BinarySearchTree class
	public static void main(String[] args) {
		Node root = new Node(5, null);
		root.left = new Node(2, root);
		root.left.left = new Node(1, root.left);
		root.left.right = new Node(3, root.left);
		root.left.right.right = new Node(4, root.left.right);
		root.right = new Node(7, root);
		root.right.left = new Node(6, root.right);
		root.right.right = new Node(8, root.right);
		root.right.right.right = new Node(9, root.right.right);
		
		Node result = findSuccessor(root.left);
		if(result != null)
			System.out.println(result.value);
		else
			System.out.println("Successor does not exist.");
	}
}
