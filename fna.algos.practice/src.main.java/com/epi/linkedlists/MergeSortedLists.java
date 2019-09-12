package com.epi.linkedlists;

public class MergeSortedLists {

	private static class Node {
		int value;
		Node next;
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	public static Node merge(Node p1, Node p2) {
		Node p = new Node(0, null);
		Node head = p, n1 = p1, n2 = p2;
		while(n1 != null && n2 != null) {
			if(n1.value < n2.value) {
				p.next = n1;
				n1 = n1.next;
			} else {
				p.next = n2;
				n2 = n2.next;
			}
			p = p.next;
		}
//		if(n1 != null)
//			p.next = n1;
//		
//		if(n2 != null)
//			p.next = n2;
		
		p.next = (n1 != null)? n1 : n2;
		return head.next; 
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1, new Node(3, new Node(5, new Node(7, null))));
		Node n2 = new Node(2, new Node(4, new Node(6, new Node(8, null))));
		Node mergedList = merge(n1, n2);
		print(mergedList);
		print(n1);
		print(n2);
	}
	
	private static void print(Node n) {
		System.out.println();
		while(n != null) {
			System.out.print(n.value + ", ");
			n = n.next;
		}
	}
	
}
