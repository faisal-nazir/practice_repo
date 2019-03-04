package ctci.ds.tree;

import common.utils.TreeNode;

public class CheckBalanced {
	
	public static int getHeight(TreeNode root) {
		if(root == null) return -1;
		int hl = getHeight(root.left);
		if (hl == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int hr = getHeight(root.right);
		if (hr == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if(Math.abs(hl - hr) > 1) return Integer.MIN_VALUE;
		return Math.max(hl, hr) + 1;
	}
	
	public static boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
		return isBalanced(root.left) || isBalanced(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
//		root.right = new TreeNode(4);
//		root.right.right = new TreeNode(7);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.left.left.left = new TreeNode(5);
		System.out.println(getHeight(root) != Integer.MIN_VALUE);
	}
}
