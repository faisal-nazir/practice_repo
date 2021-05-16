package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PrintCharacters {

	public static Node foo(String s, int p) {
		count++;
		if(p >= s.length()) return null;
		
		Node root = new Node(s.charAt(p));
		enter(p);
		for(int i = 0; i < s.length(); ++i) {
			root.children.add(foo(s, p+1));
		}
		leave(p);
		return root;
	}
	
	public static Node foo2(String s, int p) {
		++count;
		if(p >= s.length()) return null;
		
		Node root = new Node(s.charAt(p));
		enter(p);
		for(int i = p; i < s.length(); ++i) {
			root.children.add(foo2(s, i+1));
		}
		leave(p);
		return root;
	}
	
	public static Node foo3(String s, int p) {
		if(p < 0) return null;

		Node root = new Node(s.charAt(p));
		enter(p);
		for(int i = p; i >= 0; i--) {
			root.children.add(foo3(s, i-1));
		}
		leave(p);
		return root;
	}
	
	static String indent = "";
	static int count = 0;
	
	static class Node { 
		char val;
		List<Node> children;
		
		Node(char val) {
			this.val = val;
			this.children = new ArrayList<Node>();
		}
	}
	
	
	public static void main(String[] args) {
		indent = "";
		count = 0;
		String s = " ABCDE";
		Node root = foo(s, 0);
		print(root);
		System.out.println(count);
	}
	
	
	static void print(Node root) {
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
