package com.epi.binaryTrees;

import java.util.*;

public class InorderTraversal {

	private static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int val) {
			value = val;
		}
	}
	
	public static void traverse(Node root) {
		if(root == null) return;
		Deque<Node> stack = new LinkedList<Node>();
		Node itr = root;
		while(itr != null) {
			stack.push(itr);
			itr = itr.left;
		}
		while(!stack.isEmpty()) {
			Node top = stack.pop();
			System.out.print(top.value + " ");
			itr = top.right;
			while(itr != null) {
				stack.push(itr);
				itr = itr.left;
			}
		}
	}
	
	private static Node getTree() {
		Node root = new Node(4);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		root.right = new Node(6);
		root.right.left = new Node(5);
		return root;
	}
	
	private static void print(Node n) {
		if(n == null) return;
		Deque<Node> q = new LinkedList<>();
		q.add(n);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; ++i) {
				Node curr = q.poll();
				System.out.print(curr.value + " ");
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Node root = getTree();
		traverse(root);
	}
	
	private List<Integer> inOrder_Traversal(Node root) {
		List<Integer> res = new ArrayList<>();
		return res;
	}
}
