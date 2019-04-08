package ctci.ds.tree;

import common.utils.TreeNode;
/** Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
**/

public class MaxDepthofBinaryTree {

	public static int getDepth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1; 
	}
	
}
