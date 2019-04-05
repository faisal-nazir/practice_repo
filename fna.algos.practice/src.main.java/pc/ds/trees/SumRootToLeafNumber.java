package pc.ds.trees;

import common.utils.TreeNode;

/** Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

**/

public class SumRootToLeafNumber {
	//https://leetcode.com/problems/sum-root-to-leaf-numbers/discuss/41363/Short-Java-solution.-Recursion.
		// comment by ndec09
		private static int sumNumbers(TreeNode root) {
			return sumNodes(root, 0);
		}
	
		private static int sumNodes(TreeNode root, int currentSum) {
			if (root == null) return 0;
			currentSum = currentSum * 10 + root.val;
			if (root.left == null && root.right == null) return currentSum;
			int leftSum = sumNodes(root.left, currentSum);
			int rightSum = sumNodes(root.right, currentSum);
			return leftSum + rightSum;
		}
}
