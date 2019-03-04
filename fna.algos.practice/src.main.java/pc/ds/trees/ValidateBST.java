package pc.ds.trees;

import common.utils.TreeNode;

public class ValidateBST {
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}
	
	private static boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if(root == null) return true;
		if((min != null && root.val <= min) || (max != null && root.val > max)) return false;
		return isValidBST(root.left, min, root.val) || isValidBST(root.right, root.val, max);
	}
}
