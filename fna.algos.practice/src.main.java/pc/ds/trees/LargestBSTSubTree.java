package pc.ds.trees;

import common.utils.TreeNode;

public class LargestBSTSubTree {
	
	public static int getLargestBST(TreeNode root) {
		if(root == null) return 0;
		if(isBST(root))
			return getCount(root);
		else
			return Math.max(getLargestBST(root.left), getLargestBST(root.right));
	}
	
	public static boolean isBST(TreeNode n) {
		if(n ==  null) return false;
		return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isBST(TreeNode n, int min, int max) {
		if(n == null) return true;
		if(n.val > max || n.val <= min) return false;
		return isBST(n.left, min, n.val)&& isBST(n.right, n.val, max); 
	}
	
	public static int getCount(TreeNode n) {
		if(n == null) return 0;
		return getCount(n.left) + getCount(n.right) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode r = createNewTree();
		System.out.print(getLargestBST(r));
	}
	
	private static TreeNode createNewTree() {
    	TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right.right = new TreeNode(7);
		
		return root;
    }
}
