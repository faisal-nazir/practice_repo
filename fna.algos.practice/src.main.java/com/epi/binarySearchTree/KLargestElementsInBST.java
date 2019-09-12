package com.epi.binarySearchTree;

import java.util.*;

public class KLargestElementsInBST {

	private static class Node { 
		int value; 
		Node left;
		Node right;
		
		Node(int val) {
			this.value = val;
		}
	}
	
	public static List<Integer> findKLargest(Node root, int k) {
		List<Integer> res = new ArrayList<>();
		find(root, k, res);
		return res;
	}
	private static int c = 0;
	public static void find(Node root, int k, List<Integer> res) {
		if(root == null || k == 0) return;
		++c;
		find(root.right, k, res);
		res.add(root.value);
		if(res.size() < k)
			find(root.left, k, res);
	}
	
	public static void main(String[] args) {
		Node t = getTree();
		List<Integer> res = findKLargest(t, 2);
		print(res);
		///System.out.println(c);
	}
	
	private static void print(List<Integer> list) {
		System.out.println();
		for(Integer val : list) {
			System.out.print(val + " ");
		}
	}
	
	private static Node getTree() {
		Node root = new Node(5);
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right = new Node(7);
		root.right.left = new Node(6);
		root.right.right = new Node(8);
		
		return root;
	}
	
}
