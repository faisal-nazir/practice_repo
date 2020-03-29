package interview.pro.daily.problem;

import java.util.*;

public class FullBinaryTree {

	private static class Node {
		int value;
		Node left; 
		Node right;
		
		Node(int val) {
			value = val;
		}
	}
	
	public static Node convert(Node root) {
		if(root == null) return root;
		Node left = convert(root.left);
		Node right = convert(root.right);
		if(left == null && right != null) {
			root.value = root.right.value;
			root.right = null;
		} else if(left != null && right == null) {
			root.value = root.left.value;
			root.left = null;
		}
		return root;	
	}
	
	public static void main(String[] args) {
		Node n = getTree();
		print(n);
		Node res = convert(n);
		print(res);
	}
	
	private static Node getTree() {
		Node tree = new Node(1);
		tree.left = new Node(2);
		tree.right = new Node(3);
		tree.right.right = new Node(4);
		tree.right.left = new Node(9);
		tree.left.left = new Node(0);
		
		return tree;
	}
	
	private static void print(Node n) {
		if(n == null) return;
		Deque<Node> q = new LinkedList<>();
		q.add(n);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; ++i) {
				Node c = q.poll();
				System.out.print(c.value + " ");
				if(c.left != null) q.add(c.left);
				if(c.right != null) q.add(c.right);
			}
			System.out.println();
		}
		
	}
}
