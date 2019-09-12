package com.epi.binaryTrees;

public class FindRootToLeafPathWithSum {

	// EPI-10.6: 
	private static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int v) {
			this.value = v;
		}
	}
	public static boolean find(Node root, int target) {
		if(root == null) return false;
		if(root.left == null && root.right == null && target-root.value == 0) return true;
		return find(root.left, target-root.value) || find(root.right, target-root.value);
	}
}
