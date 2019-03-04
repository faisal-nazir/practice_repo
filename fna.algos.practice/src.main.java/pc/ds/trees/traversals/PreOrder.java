package pc.ds.trees.traversals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import common.utils.TreeNode;
import common.utils.TreeUtil;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * Input: [1,null,2,3] 1 \ 2 / 3
 * 
 * Output: [1,2,3] Follow up: Recursive solution is trivial, could you do it
 * iteratively?
 **/
public class PreOrder {

	public static void traverse(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + ",");
		traverse(root.left);
		traverse(root.right);
	}

	public static void print(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode n = stack.pop();
			System.out.print(n.val + ",");
			if (n.right != null)
				stack.push(n.right);
			if (n.left != null)
				stack.push(n.left);
		}
	}

	public static void main(String[] args) {

		TreeNode root = createTree();
		System.out.println("recursive");
		traverse(root);
		System.out.println("iterative");
		print(root);
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
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				result.add(p.val); // Add before going to children
				p = p.left;
			} else {
				TreeNode node = stack.pop();
				p = node.right;
			}
		}
		return result;
	}
}
