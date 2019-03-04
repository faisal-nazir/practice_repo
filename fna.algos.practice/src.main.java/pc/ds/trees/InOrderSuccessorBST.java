package pc.ds.trees;

import common.utils.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

public class InOrderSuccessorBST {

	public static TreeNode findSuccessor(TreeNode root, TreeNode p) {
		if(p == null || root == null) return null;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		while(root != null && root != p) {
			stack.push(root);
			if(p.val < root.val)
				root = root.left;
			else 
				root = root.right;
		}
		if(root == null) return root;
		if(root.right != null) return min(root.right);
		while(!stack.isEmpty() && stack.peek().val < p.val) stack.pop();
		return (stack.isEmpty())? null : stack.peek(); 
	}
	
	public static TreeNode min(TreeNode n) {
		if(n == null || n.left == null) return n;
		return min(n.left);
	}
}
