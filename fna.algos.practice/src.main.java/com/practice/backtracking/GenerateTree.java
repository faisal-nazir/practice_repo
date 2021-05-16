package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GenerateTree {
	
	static String indent = "";
	
	static class Node { 
		int val;
		List<Node> children;
		
		Node(int val) {
			this.val = val;
			this.children = new ArrayList<Node>();
		}
	}
	
	public Node generateNumberTree(int h, int n) {
		if(h <= 0) return null;
		Node root = new Node(h);
		enter(h);
		for(int i = 0; i < n; ++i) {
			Node child = generateNumberTree(h-1, n);
			root.children.add(child);
		}
		leave(h);
		return root;
	}
	
	public static void main(String[] args) {
		indent = "";
		GenerateTree t = new GenerateTree();
		Node root = t.generateNumberTree(3, 3);
		t.print(root);
	}
	
	
	void print(Node root) {
		if(root == null) return;
		Deque<Node> q = new LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; ++i) {
				Node curr = q.poll();
				System.out.print(curr.val + " ");
				for(Node child : curr.children) {
					if(child != null)
						q.offer(child);
				}
			}
			System.out.println();
		}
	}
	
	public static void enter(int a) {
		System.out.println(indent + "Entering foo(" + a + ")");
		indent = indent + "|  ";
	}
	
	public static void leave(int a) {
		indent = indent.substring(3);
		System.out.println(indent + "Leaving foo(" + a + ")");
	}
}

