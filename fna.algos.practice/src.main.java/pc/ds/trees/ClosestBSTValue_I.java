package pc.ds.trees;

import common.utils.TreeNode;

public class ClosestBSTValue_I {

	private static class Result {
		int diffSoFar = Integer.MAX_VALUE;
		int closestValue = -1;
	}
	public static int getClosestBSTValue(TreeNode root, int target) {
		if(root == null) return -1;
		Result res = new Result();
		helper(root, target, res);
		return res.closestValue;
	}
	
	public static void helper(TreeNode root, int target, Result r) {
		if(root == null) return;
		if(root.val == target) {
			r.closestValue = target;
			return;
		}
		
		int diff = root.val - target;
		if(Math.abs(diff) < r.diffSoFar) {
			r.diffSoFar = Math.abs(diff);
			r.closestValue = root.val;
		}
		
		if(diff > 0)
			helper(root.left, target, r);
		else
			helper(root.right, target, r);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(5);
		
		System.out.println(getClosestBSTValue(root, 200));
	}
}
