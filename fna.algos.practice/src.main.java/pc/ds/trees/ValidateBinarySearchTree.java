package pc.ds.trees;

import java.util.Stack;

import common.utils.TreeNode;

/** Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
*/
public class ValidateBinarySearchTree {

	private static boolean isBST(TreeNode root) {
		return isBST(root, null, null);
	}
	
	private static boolean isBST(TreeNode root, Integer min, Integer max) {
		if(root == null) return true;
		if((min != null && root.val <= min) || (max != null && root.val > max)) return false;
		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
	}
	
	
	//https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
	// in-order iterative traversal is utilized to solve many question
	// for this problem, in-order traversal will only work if tree does not have any duplicate values.
	// see ctci 4.5 for more details
	public boolean isValidBST(TreeNode root) {
		   if (root == null) return true;
		   Stack<TreeNode> stack = new Stack<>();
		   TreeNode pre = null;
		   while (root != null || !stack.isEmpty()) {
		      while (root != null) {
		         stack.push(root);
		         root = root.left;
		      }
		      root = stack.pop();
		      if(pre != null && root.val <= pre.val) return false;
		      pre = root;
		      root = root.right;
		   }
		   return true;
		}
	
}
