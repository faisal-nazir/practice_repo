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
					stack.push(top.right);
				} else {
					System.out.print(top.val + ",");
					prev = stack.pop();
				}
			}

		}
	}

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println("recursive");
		traverse(root);
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);

		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);

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
}
