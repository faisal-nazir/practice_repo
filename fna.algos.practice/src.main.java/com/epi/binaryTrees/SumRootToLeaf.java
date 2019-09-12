package com.epi.binaryTrees;

public class SumRootToLeaf {
	
	
	// EPI-10.5: SUM THE ROOT-TO-LEAF PATHS IN A BINARY TREE
	
	private static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int v) {
			this.value = v;
		}
	}

	public static int sum(Node root) {
		return helper(root, 0);
	}
	
	private static int helper(Node n, int pathSum) {
		if (n == null) return 0;
		pathSum= pathSum*2 + n.value;
		if(n.left == null && n.right == null) return pathSum;
		
		int sum_left = helper(n.left, pathSum);
		int sum_right = helper(n.right, pathSum);
		return sum_left + sum_right; 
	}
}
