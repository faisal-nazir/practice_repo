package temp;

import java.util.Stack;

public class Solution_03 {

	static class TreeNode {
		int val;
		TreeNode right;
		TreeNode left;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void traverse(TreeNode root) {
		if(root == null) return;
		traverse(root.left);
		System.out.print(root.val + " ");
		traverse(root.right);
	}
	
	
	public static void iterative(TreeNode root) {
		if(root == null) return;
		Stack<TreeNode> stack = new Stack();
		
		TreeNode itr =  root;
		while(!stack.isEmpty() || itr != null) {
			if(itr != null) {
				stack.push(itr);
				itr = itr.left;
			} else {
				TreeNode top = stack.pop();
				System.out.print(top.val + " ");
				if(top.right != null) {
					itr = top.right;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode t = getTree();
		iterative(t);
	}
	
	public static TreeNode getTree() {
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		
		return root;
	}
}
