package pc.ds.trees;

import common.utils.TreeNode;

public class SumRootToLeafNodes {

	public static int sumPaths(TreeNode root) {
		if(root == null) return -1;
		return helper(root, 0);
	}
	
	public static int helper(TreeNode root, int pathSum) {
		if(root == null) return 0;
		pathSum *= 10;
		pathSum += root.val;
		if(root.left == null && root.right == null) return pathSum;
		int left_sum = helper(root.left, pathSum);
		int right_sum = helper(root.right, pathSum);
		return left_sum + right_sum;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		
		System.out.println(sumPaths(root));
	}
}
