package pc.ds.trees.traversals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import common.utils.TreeNode;

/** Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
**/

public class InOrder {
	public static void traverse(TreeNode root) {
		if(root == null) return;
		traverse(root.left);
		System.out.print(root.val + ",");
		traverse(root.right);
	}
	
	public static void print(TreeNode root) {
		if(root == null) return;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
		while(!stack.isEmpty()) {
			TreeNode n = stack.pop();
			System.out.print(n.val + ",");
			n = n.right;
			while(n != null) {
				stack.push(n);
				n = n.left;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println("recursive");
		traverse(root);
		System.out.println();
		System.out.println("iterative");
		print(root);
		System.out.println();
		System.out.println("iterative-refactored");
		print(root);
	}
	
	private static TreeNode createTree() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		
		return root;
	}
	
	public static void print02(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode itr = root;
		while(!stack.isEmpty() || itr != null) {
			if(itr != null) {
				stack.push(itr);
				itr = itr.left;
			} else {
				itr = stack.pop();
				System.out.print(itr.val + ",");
				itr = itr.right;
			}
			
		}
	}
	
	//https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    Deque<TreeNode> stack = new ArrayDeque<>();
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	        if(p != null) {
	            stack.push(p);
	            p = p.left;
	        } else {
	            TreeNode node = stack.pop();
	            result.add(node.val);  // Add after all left children
	            p = node.right;   
	        }
	    }
	    return result;
	}
}
