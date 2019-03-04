package fna.algos.practice;

import java.util.Deque;
import java.util.LinkedList;

import common.utils.TreeNode;

public class LevelOrderTraversal {

	private static void print(TreeNode root) {
		if(root ==  null) return;
		
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(q.size() > 0) {
			int size = q.size();
			for(int i = 0; i < size; ++i) {
				TreeNode n = q.remove();
				System.out.print(n.val + ",");
				if(n.left != null) q.add(n.left);
				if(n.right != null) q.add(n.right);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		print(root);
	}
}
