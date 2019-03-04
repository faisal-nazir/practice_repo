package ctci.ds.tree;

import common.utils.TreeNode;

public class PathsWithSum {

	public static int count = 0;
	
	public static int getPathSum(TreeNode root, int target) {
		count = 0;
		getPathSum(root, target, 0);
		getPathSum(root.left, target, 0);
		getPathSum(root.right, target, 0);
		return count;
	}
	
	public static void getPathSum(TreeNode root, int target, int sum) {
		if(root == null) return;
		sum += root.val;
		if(sum == target) ++count;
		getPathSum(root.left, target, sum);
		getPathSum(root.right, target, sum);
	}
	
	public static TreeNode createNewTree() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);	
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(-2);
		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(2);
		
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode t = createNewTree();
		getPathSum(t, 5);
		System.out.print(count);
	}
}
