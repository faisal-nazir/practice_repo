package pc.ds.trees;

import common.utils.TreeNode;

/** Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 
 **/
public class ConvertSortedArrayToBST {
	// From Laiq's LeetCode submission
	public TreeNode sortedArrayToBST(int[] num) {
        if(num == null) return null;
        return arrayToBST(num, 0, num.length - 1);
    }
    
    public TreeNode arrayToBST(int[] num, int start, int end) {
        if(start > end) return null;
        
        int mid = start + (end - start)/2;
        TreeNode t = new TreeNode(num[mid]);
        t.left = arrayToBST(num, start, mid - 1);
        t.right = arrayToBST(num, mid + 1, end);
        return t;
    }
}
