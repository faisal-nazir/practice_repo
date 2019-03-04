package ctci.ds.tree;

import common.utils.TreeNode;

public class ValidateBST {

	public static boolean isBST(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean helper(TreeNode root, int min, int max) {
		if(root == null) return true;
		if(root.val <= min || root.val > max) return false;
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		
		
		
		System.out.println(isBST(root));
	}
	
}
