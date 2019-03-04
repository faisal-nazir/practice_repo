package pc.ds.trees;

import java.util.HashMap;
import java.util.Map;

import common.utils.TreeNode;

/** Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
**/

public class ConstructBTFromInPostTraversals {
	// From Laiq's LeetCode submission
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; ++i)
			inOrderMap.put(inorder[i], i);

		return buildTree(postorder, inOrderMap, 0, postorder.length - 1,
				postorder.length - 1);

	}

	public static TreeNode buildTree(int[] postOrder,
			Map<Integer, Integer> inOrderMap, int start, int end, int postIndex) {
		if (start > end)
			return null;

		int iIndex = inOrderMap.get(postOrder[postIndex]);

		TreeNode t = new TreeNode(postOrder[postIndex]);
		t.left = buildTree(postOrder, inOrderMap, start, iIndex - 1,
				postIndex - (end - iIndex) - 1);
		t.right = buildTree(postOrder, inOrderMap, iIndex + 1, end,
				postIndex - 1);

		return t;
	}
}
