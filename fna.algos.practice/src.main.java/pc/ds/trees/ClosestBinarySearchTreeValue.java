package pc.ds.trees;

import common.utils.TreeNode;

/** Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3
**/

public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
	    int ret = root.val;   
	    while(root != null){
	        if(Math.abs(target - root.val) < Math.abs(target - ret)){
	            ret = root.val;
	        }      
	        root = root.val > target? root.left: root.right;
	    }     
	    return ret;
	}
}

