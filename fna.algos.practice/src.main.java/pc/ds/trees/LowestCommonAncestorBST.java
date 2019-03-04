package pc.ds.trees;

import common.utils.TreeNode;
/** Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]


 

Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
**/
public class LowestCommonAncestorBST {

	public static TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			return null;
		if (root.val < p.val && root.val < q.val)
			return getLCA(root.right, p, q);
		if (root.val > p.val && root.val > q.val)
			return getLCA(root.left, p, q);
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);

		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(9);

		root.left = new TreeNode(3);
		root.right = new TreeNode(12);

		root.left.left = p;
		root.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = q;

		root.right.right = new TreeNode(13);
		root.right.left = new TreeNode(11);

		TreeNode n = getLCA(root, p, q);
		if (n != null)
			System.out.print(n.val);
		else
			System.out.print("p and q does not exist");
	}
}
