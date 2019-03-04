package pc.ds.trees;

import common.utils.TreeNode;
import common.utils.TreeUtil;
/** Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
**/
public class InvertBinaryTree {

	public static void invert(TreeNode root) {
		if(root == null) return;
		TreeNode n = root.left;
		root.left = root.right;
		root.right = n;
		invert(root.left);
		invert(root.right);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = createTree();
		System.out.println("Original");
		TreeUtil.print(root);
		invert(root);
		System.out.println("Inverted");
		TreeUtil.print(root);
	}
	
	private static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		
		return root;
	}
}
