package ctci.ds.linkedlist;

import common.utils.Node;

public class DeleteMiddleNode {
	
	public static void deleteMiddleNode(Node n) {
		if(n == null || n.next == null) return;
		n.val = n.next.val;
		n.next = n.next.next;
	}
	
	public static void main(String[] args) {
		Node n = new Node(3);
		n.next = new Node(4);
		Node head = new Node(1, new Node(2, n));
		print(head);
		deleteMiddleNode(n);
		print(head);
		
	}
	
	public static void print(Node head) {
		while(head != null) {
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println();
	}
}
