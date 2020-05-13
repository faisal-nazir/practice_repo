package pc.ds.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import common.utils.TreeNode;

/** Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often 
and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?
**/

public class KthSmallestElementInBST_I {

	// https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63660/3-ways-implemented-in-JAVA-(Python)%3A-Binary-Search-in-order-iterative-and-recursive

	// Time complexity: O(N) best, O(N^2) worst - Not Preferable
	public int kthSmallest_01(TreeNode root, int k) {
		int count = countNodes(root.left);
		if (k <= count) {
			return kthSmallest_01(root.left, k);
		} else if (k > count + 1) {
			return kthSmallest_01(root.right, k - 1 - count); // 1 is counted as
																// current node
		}

		return root.val;
	}

	public int countNodes(TreeNode n) {
		if (n == null)
			return 0;

		return 1 + countNodes(n.left) + countNodes(n.right);
	}

	// better keep these two variables in a wrapper class
	private static int number = 0;
	private static int count = 0;

	// DFS in-order recursive:
	// Time complexity: O(N)
	public int kthSmallest_02(TreeNode root, int k) {
		count = k;
		helper(root);
		return number;
	}

	public void helper(TreeNode n) {
		if (n.left != null)
			helper(n.left);
		count--;
		if (count == 0) {
			number = n.val;
			return;
		}
		if (n.right != null)
			helper(n.right);
	}
	
	// DFS in-order iterative:
	//time complexity: O(N) best
	public int kthSmallest(TreeNode root, int k) {
	      Stack<TreeNode> st = new Stack<>();
	      
	      while (root != null) {
	          st.push(root);
	          root = root.left;
	      }
	          
	      while (k != 0) {
	          TreeNode n = st.pop();
	          k--;
	          if (k == 0) return n.val;
	          TreeNode right = n.right;
	          while (right != null) {
	              st.push(right);
	              right = right.left;
	          }
	      }
	      
	      return -1; // never hit if k is valid
	}
	
	// https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/790/
	// My submission
	class Solution {
	    int position;
	    TreeNode result;
	    
	    public int kthSmallest(TreeNode root, int k) {
	        position = 1;
	        result = new TreeNode(-1);
	        helper(root, k);
	        return result.val;
	    }
	    
	    private void helper(TreeNode root, int k) {
	        if(root == null) return;
	        helper(root.left, k);
	        if(position++ == k) {
	            result = root;
	            return;
	        }
	        helper(root.right, k);
	    }
	    
	    // https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/790/
	    public int kthSmallest_(TreeNode root, int k) {
	        if(root == null) return -1;
	        Deque<TreeNode> stack = new LinkedList<>();
	        TreeNode itr = root;
	        int position = 1;
	        
	        while(!stack.isEmpty() || itr != null) {
	            if(itr != null) {
	                stack.push(itr);
	                itr = itr.left;
	            } else {
	                itr = stack.pop();
	                if(k == position) return itr.val;
	                ++position;
	                itr = itr.right;    
	            }
	        }
	        
	        return -1;
	    }
	}
}
