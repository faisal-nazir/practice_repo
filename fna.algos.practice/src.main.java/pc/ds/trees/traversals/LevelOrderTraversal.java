package pc.ds.trees.traversals;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import common.utils.TreeNode;

/** Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
**/
public class LevelOrderTraversal {

	// simple one - where you don't need to track individual levels of the tree
	public void levelOrder(TreeNode n) {
		if (null == n)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(n);
		while (!q.isEmpty()) {
			TreeNode current = q.poll();
			System.out.print(current.val + ",");
			if (current.left != null)
				q.add(current.left);
			if (current.right != null)
				q.add(current.right);
		}
	}

	// using two queues - to maintain each individual level
	public void levelOrder_02(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			Deque<TreeNode> parents = q;
			q = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				System.out.print(parent.val);
				if (parent.left != null)
					q.offer(parent.left);
				if (parent.right != null)
					q.offer(parent.right);
			}
			System.out.println();
		}
	}

	// same as above but using single queue and 'size' variable
	public static void levelOrder_03(TreeNode root) {
		if (root == null)
			return;

		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (q.size() > 0) {
			int size = q.size();
			for (int i = 0; i < size; ++i) {
				TreeNode n = q.remove();
				System.out.print(n.val + ",");
				if (n.left != null)
					q.add(n.left);
				if (n.right != null)
					q.add(n.right);
			}
			System.out.println();
		}
	}
}
