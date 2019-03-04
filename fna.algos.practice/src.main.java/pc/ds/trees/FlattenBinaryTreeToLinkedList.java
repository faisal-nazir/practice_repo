package pc.ds.trees;

import java.util.Deque;
import java.util.LinkedList;
import common.utils.TreeNode;

/** Given a binary tree, flatten it to a linked list in-place.

For example,
Given

          1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 **/

public class FlattenBinaryTreeToLinkedList {

	// https://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
		public static void flatten(TreeNode root) {
			Deque<TreeNode> stack = new LinkedList<TreeNode>();
			TreeNode p = root;

			while (p != null || !stack.isEmpty()) {

				if (p.right != null) {
					stack.push(p.right);
				}

				if (p.left != null) {
					p.right = p.left;
					p.left = null;
				} else if (!stack.isEmpty()) {
					TreeNode temp = stack.pop();
					p.right = temp;
				}

				p = p.right;
			}
		}

		// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
		// recursive solution - bottom up approach building right sub tree first
		// i.e. postOrder with visiting right node first
		private static TreeNode prev = null;

		public static void flatten2(TreeNode root) {
			if (root == null)
				return;
			flatten2(root.right);
			flatten2(root.left);
			root.right = prev;
			root.left = null;
			prev = root;
		}

		// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/37010/Share-my-simple-NON-recursive-solution-O(1)-space-complexity!
		// so what this solution is basically doing is putting the right subtree
		// next to the rightmost node on the left subtree and then making the left
		// subtree the right subtree and then making the left one null. Neat!
		public void flatten_03(TreeNode root) {
			while (root != null) {
				if (root.left != null) {
					TreeNode prev = root.left;
					while (prev.right != null) {
						prev = prev.right;
					}
					prev.right = root.right;
					root.right = root.left;
					root.left = null;
				}
				root = root.right;
			}
		}
}
