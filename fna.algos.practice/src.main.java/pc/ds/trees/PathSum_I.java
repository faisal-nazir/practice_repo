package pc.ds.trees;

import common.utils.TreeNode;
/** Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 *  such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
**/
public class PathSum_I {

	public static boolean pathSumExists(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (sum == root.val && root.left == null && root.right == null)
			return true;
		return pathSumExists(root.left, sum - root.val)
				|| pathSumExists(root.right, sum - root.val);
	}

}
