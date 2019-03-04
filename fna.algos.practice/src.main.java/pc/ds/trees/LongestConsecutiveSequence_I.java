package pc.ds.trees;

import common.utils.TreeNode;
/** Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
Example 2:

Input:

   2
    \
     3
    / 
   2    
  / 
 1

Output: 2 

Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
**/
public class LongestConsecutiveSequence_I {

	private int max = 0;
	// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/discuss/74468/Easy-Java-DFS-is-there-better-time-complexity-solution
	public int longestConsecutive_01(TreeNode root) {
		if (root == null)
			return 0;
		helper(root, 0, root.val);
		return max;
	}

	public void helper(TreeNode root, int cur, int target) {
		if (root == null)
			return;
		if (root.val == target)
			cur++;
		else
			cur = 1;
		max = Math.max(cur, max);
		helper(root.left, cur, root.val + 1);
		helper(root.right, cur, root.val + 1);
	}
	
	
	//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/discuss/74467/Simple-Recursive-DFS-without-global-variable
	
	public int longestConsecutive_02(TreeNode root) {
		return (root == null) ? 0 : Math.max(dfs(root.left, 1, root.val),
				dfs(root.right, 1, root.val));
	}

	public int dfs(TreeNode root, int count, int val) {
		if (root == null)
			return count;
		count = (root.val - val == 1) ? count + 1 : 1;
		int left = dfs(root.left, count, root.val);
		int right = dfs(root.right, count, root.val);
		return Math.max(Math.max(left, right), count);
	}

}
