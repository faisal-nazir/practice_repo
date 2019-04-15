package pc.ds.trees;

import common.utils.TreeNode;

/** Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
**/


// https://leetcode.com/problems/count-complete-tree-nodes/discuss/61948/Accepted-Easy-Understand-Java-Solution

public class CountCompleteTreeNodes {
	private static int countNodes(TreeNode root) {
	    int leftDepth = leftDepth(root);
		int rightDepth = rightDepth(root);
	
		if (leftDepth == rightDepth)
			return (1 << leftDepth) - 1;
		else {
			int count_leftTree = countNodes(root.left);
			int count_rightTree = countNodes(root.right);
			return count_leftTree + count_rightTree + 1;
		}
	}
	
	private static int rightDepth(TreeNode root) {
		if(root == null) return 0;
		return rightDepth(root.right) + 1; 
	}
	
	private static int leftDepth(TreeNode root) {
		if(root == null) return 0;
		return leftDepth(root.left) + 1; 
	}
}

