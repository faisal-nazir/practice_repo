package com.epi.binarySearchTree;

public class ConstructBSTFromTraversalData {

	// EPI-15.5: RECONSTRUCT A BST FROM TRAVERSAL DATA
	
	private static class Node {
		int value; 
		Node left;
		Node right;
		
		Node(int val) {
			this.value = val;
		}
	}
	
	public static Node constructFromPreOrder(int[] preOrder) {
		return helper(preOrder, 0, preOrder.length-1);
	}
	
	private static Node helper(int[] preOrder, int start, int end) {
		if(start >= end) return null;
		Node root = new Node(preOrder[start]);
		int p = start+1;
		while(p < end && preOrder[p] < preOrder[start]) {
			++p;
		}
		root.left = helper(preOrder, start+1, p);
		root.right = helper(preOrder, p, end);
		
		return root;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {4, 3, 1, 2, 6, 5, 8};
		Node r = constructFromPreOrder(arr);
		print(r);
	}
	
	public static void print(Node r) {
		if(r == null) return;
		print(r.left);
		System.out.print(r.value + " ");
		print(r.right);
	}
	
}
