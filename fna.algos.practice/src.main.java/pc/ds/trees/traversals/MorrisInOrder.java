package pc.ds.trees.traversals;

import java.util.ArrayList;
import java.util.List;

import common.utils.TreeNode;

public class MorrisInOrder {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static List<Integer> traverse(TreeNode root) {
		List<Integer> res = new ArrayList();
		TreeNode current = root;
		
		while(current != null) {
			if(current.left == null) {
				res.add(current.val);
				current = current.right;
			} else {
				TreeNode pre = findInOrderPredecessor(current);
				
				if(pre.right == null) {
					pre.right = current;
					res.add(current.val);
					current = current.left;
				} else {
					pre.right = null;
					//res.add(current.val);
					current = current.right;
				}
			}
		}
		
		return res;
	}
	
	public static void traversePre(TreeNode n) {
		if(n == null) return;
		System.out.print(n.val + " ");
		traversePre(n.left);
		traversePre(n.right);
	}
	
	private static TreeNode findInOrderPredecessor(TreeNode n) {
		TreeNode p = n;
		p = p.left;
		while(p.right != null && p.right != n) {
			p = p.right;
		}
		return p;
	}
	
	// https://www.youtube.com/watch?v=wGXB9OWhPTg
	private static TreeNode getTree() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(30);
		
		root.left.left = new TreeNode(-2);
		root.left.right = new TreeNode(6);
		root.left.right.right = new TreeNode(8);
		root.left.left.right = new TreeNode(2);
		root.left.left.right.left = new TreeNode(-1);
		
		root.right.right = new TreeNode(40);
		
		return root;
	}
	
	public static void main(String[] args) {
		List<Integer> list = traverse(getTree());
		print(list);
		System.out.println();
		traversePre(getTree());
	}
	
	public static void print(List<Integer> values) {
		for(Integer val : values) {
			System.out.print(val + " ");
		}
	}
}
