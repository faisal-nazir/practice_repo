package pc.ds.trees;

import common.utils.TreeNode;

public class SameTree {

	public static boolean isSameTree(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		
		if(t1.val != t2.val) return false;
		return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		t1.right.right = new TreeNode(4);
	
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(3);
		t2.right.left = new TreeNode(4);
		
		System.out.print(isSameTree(t1, t2));
	}
}
