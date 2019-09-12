package com.epi.binaryTrees;

public class BalancedBinaryTree {

	// EPI-10.1: Test if binary tree is height balanced.
	private static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int val) {
			this.value = val;
		}
	}
	
	public static boolean isBalanced(Node root) {
		
		return helper(root) >= 0;
	}
	
	public static int helper(Node root) {
		if(root == null) return 0;
		
		int h_left = helper(root.left);
		if(h_left < 0) return h_left;
		
		int h_right = helper(root.right);
		if(h_right < 0) return h_right;
		
		int diff = Math.abs(h_left - h_right);
		return diff > 1 ? -1 : Math.max(h_left, h_right)+1;
	}
	
	public static void main(String[] args) {
		Node t = getTree();
		System.out.print(isBalanced(t));
	}
	
	public static Node getTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(5);
		return root;
	}
}
