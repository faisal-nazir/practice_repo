package ctci.ds.tree;

import common.utils.TreeNode;

public class MaxDepthofBinaryTree {

	public static int getDepth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1; 
	}
	
	
	
}
