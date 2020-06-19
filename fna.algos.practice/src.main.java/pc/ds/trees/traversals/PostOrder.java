package pc.ds.trees.traversals;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import common.utils.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * Input: [1,null,2,3] 1 \ 2 / 3
 * 
 * Output: [3,2,1] Follow up: Recursive solution is trivial, could you do it
 * iteratively?
 **/

public class PostOrder {
	public static void traverse(TreeNode root) {
		if (root == null)
			return;
		traverse(root.left);
		traverse(root.right);
		System.out.print(root.val + ",");
	}

	// 02222019 - Laiq's leetcode submission is equivalent to the solution below
	// but I remember him doing it differently during our discussions.
	public static void print(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		stack.push(root);
		TreeNode itr = root, prev = null;
		while (!stack.isEmpty() || itr != null) {
			if (itr != null) {
				stack.push(itr);
				itr = itr.left;
			} else {
				TreeNode top = stack.peek();
				if (top.right != null && prev != top.right) {
					itr = top.right;
				} else {
					System.out.print(top.val + ",");
					prev = stack.pop();
					itr = null;
				}
			}

		}
	}

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println("recursive");
		traverse(root);
		System.out.println();
		print(root);
//		print(postOrderWithStack(root));
//		System.out.println();
//		print(postOrderWithQueue(root));
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		

		root.right.left = new TreeNode(4);

		return root;
	}

	// https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				result.addFirst(p.val); // Reverse the process of preorder
				p = p.right; // Reverse the process of preorder
			} else {
				TreeNode node = stack.pop();
				p = node.left; // Reverse the process of preorder
			}
		}
		return result;
	}
	
	//
	public static List<Integer> postOrderWithStack(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		if(root == null) return res;
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode n = stack.pop();
			res.addFirst(n.val);
			if(n.left != null)
				stack.push(n.left);
			if(n.right != null) 
				stack.push(n.right);
		}
		
		return res;
		
	}
	
	public static List<Integer> postOrderWithQueue(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		if(root == null) return res;
		Deque<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode n = q.poll();
			res.addFirst(n.val);
			if(n.right != null)
				q.add(n.right);
			if(n.left != null) 
				q.add(n.left);
		}
		
		return res;
		
	}
	
	private static void print(List<Integer> list) {
		for(Integer n : list) {
			System.out.print(n + ",");
		}
	}
}
