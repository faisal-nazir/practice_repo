package com.epi.binaryTrees;

public class ComputeLCAInBinaryTree {

	
	// EPI-10.3: Compute the lowest common ancestor in a binary tree
	
	private static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int val) {
			this.value = val;
		}
	}
	
	public static Node computeLCA(Node root, Node p, Node q) {
		if(root == null || root == p || root == q) return root;
		Node left = computeLCA(root.left, p, q);
		Node right = computeLCA(root.right, p, q);
		
		if(left != null && right != null) return root;
		return (left == null)? right : left;
	}
}
