package pc.ds.trees;

import java.util.Deque;
import java.util.LinkedList;

import common.utils.TreeNode;
/** You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
**/
public class PopulatingNextRightPointers_I {
	
	public static class LinkTreeNode {
		LinkTreeNode left;
		LinkTreeNode right;
		LinkTreeNode next;
		int val;
		
		public LinkTreeNode(int value) {
			this.val = value;
		}
	}

	public static void populate(LinkTreeNode root) {
		if(root == null) return;
		LinkTreeNode h_currLevel = root;
		LinkTreeNode h_nextLevel = root.left;
		LinkTreeNode itr = null;
		
		while(h_nextLevel != null) {
			itr = h_currLevel;
			while(itr != null) {
				itr.left.next = itr.right;
				if(itr.right != null && itr.next != null)
					itr.right.next = itr.next.left;
				itr = itr.next;
			}
			h_currLevel = h_nextLevel;
			h_nextLevel = h_nextLevel.left;
		}
	}
	
	public static void main(String[] args) {
		LinkTreeNode root = getTree();
		
	}
	
	private static void print(TreeNode root) {
		if(root ==  null) return;
		
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(q.size() > 0) {
			int size = q.size();
			for(int i = 0; i < size; ++i) {
				TreeNode n = q.remove();
				System.out.print(n.val + ",");
				if(n.left != null) q.add(n.left);
				if(n.right != null) q.add(n.right);
			}
			System.out.println();
		}
	}
	
	private static LinkTreeNode getTree() {
		LinkTreeNode root = new LinkTreeNode(1);
		
		root.left = new LinkTreeNode(2);
		root.right = new LinkTreeNode(3);
		
		root.left.left = new LinkTreeNode(4);
		root.left.right = new LinkTreeNode(5);
		
		root.right.left = new LinkTreeNode(6);
		root.right.right = new LinkTreeNode(7);
			
		return root;
	}
}
