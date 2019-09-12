package com.epi.binarySearchTree;

public class BSTSuccessor {

	public static Node search(Node root, int key) {
	
		Node biggerSoFar = null; Node p = root;
		while(p != null) {
			if(p.value > key) {
				biggerSoFar = p;
				p = p.left;
			} else {
				p = p.right;
			}
		}
		
		return biggerSoFar;
	}
	
	private static class Node {
		int value;
		Node right;
		Node left;
		
		Node(int val) {
			this.value = val;
		}
	}
}
