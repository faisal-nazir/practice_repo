package ctci.ds.linkedlist;

import common.utils.Node;

public class KthToLastElement {

	public static int kthElement(Node head, int k) {
		if(head == null || k <= 0) return -1;
		Node slow = head, fast = head;
		while(fast != null && k > 0) {
			fast = fast.next;
			--k;
		}
		
		if(fast == null && k > 0) return -1;
	
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.val;
	}
	
	public static void main(String[] args) {
		Node head = new Node(4, new Node (5, new Node(9, new Node(7, new Node(1)))));
		int val = kthElement(head, -1);
		System.out.print(val);
	}
}
