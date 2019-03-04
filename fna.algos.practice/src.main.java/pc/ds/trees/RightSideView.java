package pc.ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import common.utils.TreeNode;

/** Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
**/

public class RightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root == null)
			return result;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (queue.size() > 0) {
			// get size here
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode top = queue.remove();

				// the first element in the queue (right-most of the tree)
				if (i == 0) {
					result.add(top.val);
				}
				// add right first
				if (top.right != null) {
					queue.add(top.right);
				}
				// add left
				if (top.left != null) {
					queue.add(top.left);
				}
			}
		}

		return result;
	}

	// https://leetcode.com/problems/binary-tree-right-side-view/discuss/56012/My-simple-accepted-solution(JAVA)
	// using depth first serach
	public List<Integer> rightSideView_dfs(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
		if (curr == null) {
			return;
		}
		if (currDepth == result.size()) {
			result.add(curr.val);
		}

		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);

	}

	public static void main(String[] args) {
		RightSideView s = new RightSideView();
		TreeNode root = getTree();
		List<Integer> rightList = s.rightSideView(root);
		s.print(rightList);

	}

	private void print(List<Integer> list) {
		for (int i : list)
			System.out.print(i + " ");
	}

	private static TreeNode getTree() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);

		return root;
	}
}
