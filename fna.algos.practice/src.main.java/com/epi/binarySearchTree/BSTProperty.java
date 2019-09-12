package com.epi.binarySearchTree;


public class BSTProperty {
	
	
	// EPI- 15.1: Test if a binary tree satisfies BST property.
	private static class Node {
		int value;
		Node left;
		Node right;
	}

	public static boolean isBST(Node root) {
		return helper(root, null, null);
	}
	
	private static boolean helper(Node root, Integer min, Integer max) {
		if(root == null) return true;
		if((min != null && root.value <= min) || (max != null && root.value > max)) return false;
		return helper(root.left, Integer.MIN_VALUE, root.value) && helper(root.right, root.value, Integer.MAX_VALUE);
	}
}
