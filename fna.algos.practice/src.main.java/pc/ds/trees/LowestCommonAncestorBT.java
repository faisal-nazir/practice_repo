package pc.ds.trees;

import common.utils.TreeNode;
/** Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: �The lowest common ancestor is defined between two nodes p and q as the 
lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).�

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
public class LowestCommonAncestorBT {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		
		TreeNode p = new TreeNode(6);
		TreeNode q = new TreeNode(4);
		
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		
		root.left.left = p;
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = q;
		
		root.right.right = new TreeNode(8);
		root.right.left = new TreeNode(0);
		
		TreeNode n = lowestCommonAncestor2(root, p, q);
		if(n != null)
			System.out.print(n.val);
	}
	
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //base case
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
    }
	
	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
}
