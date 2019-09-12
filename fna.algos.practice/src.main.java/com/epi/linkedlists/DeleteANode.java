package com.epi.linkedlists;

public class DeleteANode {

	// EPI-8.6 Delete a node from singly linked list
	
	private static class Node {
		int value;
		Node next;
		
		Node(int v, Node n) {
			value = v;
			next = n;
		}
	}
	public static void delete(Node n) {
		if(n == null || n.next == null) return;
		n.value = n.next.value;
		n.next = n.next.next;
	}
}
