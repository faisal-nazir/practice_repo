package pc.ds.trees;

import java.util.Deque;
import java.util.LinkedList;

import common.utils.TreeNode;
/** Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
**/

public class SymmetricTree {
	// https://leetcode.com/problems/symmetric-tree/discuss/33054/Recursive-and-non-recursive-solutions-in-Java
	// check above link for iterative version of the solution
	public static boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}
	
	private static boolean isSymmetric(TreeNode m, TreeNode n) {
		if(m == null && n == null) return true;
		if(m == null || n == null) return false;
		if(m.val != n.val) return false;
		return isSymmetric(m.left, n.right) && isSymmetric(m.right, n.left);
	}
	
	public static void main(String[] args) {
		TreeNode root = getTree();
		System.out.println(isSymmetric(root));
	}
	
	private static TreeNode getTree() {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
				
		return root;
	}
	
	public boolean isSymmetric_iterative(TreeNode root) {
	       if(root == null) return true;
	      Deque<TreeNode> st = new LinkedList<>();
	      st.addFirst(root.left);
	      st.addFirst(root.right);
	      while(!st.isEmpty()) {
	          TreeNode t1,t2;
	          t1= st.removeFirst();
	          t2 = st.removeFirst();
	          if(t1 == null && t2 == null && st.isEmpty()) break;
	          if(t1 == null && t2 == null && !st.isEmpty()) continue;
	          if(t1 == null && t2 != null) return false;
	          if(t1 != null && t2 == null) return false;
	          if(t1.val != t2.val) return false;
	          st.addFirst(t1.left);
	          st.addFirst(t2.right);                        
	          st.addFirst(t1.right);
	          st.addFirst(t2.left);
	      }
	      return true;
	  }
}
