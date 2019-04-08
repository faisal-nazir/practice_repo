package pc.ds.trees;

import common.utils.TreeNode;

/** Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.

Example:

Input: [10,5,15,1,8,null,7]

   10 
   / \ 
  5  15 
 / \   \ 
1   8   7

Output: 3
Explanation: The Largest BST Subtree in this case is the highlighted one.
             The return value is the subtree's size, which is 3.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?

**/

public class LargestBSTSubTree {
	
	
	public static int getLargestBST(TreeNode root) {
		if(root == null) return 0;
		if(isBST(root))
			return getCount(root);
		else
			return Math.max(getLargestBST(root.left), getLargestBST(root.right));
	}
	
	public static boolean isBST(TreeNode n) {
		if(n ==  null) return false;
		return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isBST(TreeNode n, int min, int max) {
		if(n == null) return true;
		if(n.val > max || n.val <= min) return false;
		return isBST(n.left, min, n.val)&& isBST(n.right, n.val, max); 
	}
	
	public static int getCount(TreeNode n) {
		if(n == null) return 0;
		return getCount(n.left) + getCount(n.right) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode r = createNewTree();
		System.out.print(getLargestBST(r));
	}
	
	private static TreeNode createNewTree() {
    	TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right.right = new TreeNode(7);
		
		return root;
    }
	
	//https://leetcode.com/problems/largest-bst-subtree/discuss/78891/Share-my-O(n)-Java-code-with-brief-explanation-and-comments
	class Solution {
	    
	    class Result {  // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
	        int size;
	        int lower;
	        int upper;
	        
	        Result(int size, int lower, int upper) {
	            this.size = size;
	            this.lower = lower;
	            this.upper = upper;
	        }
	    }
	    
	    int max = 0;
	    
	    public int largestBSTSubtree(TreeNode root) {
	        if (root == null) { return 0; }    
	        traverse(root);
	        return max;
	    }
	    
	    private Result traverse(TreeNode root) {
	        if (root == null) { return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE); }
	        Result left = traverse(root.left);
	        Result right = traverse(root.right);
	        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
	            return new Result(-1, 0, 0);
	        }
	        int size = left.size + 1 + right.size;
	        max = Math.max(size, max);
	        return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
	    }
	}
}
