package pc.ds.linkedlist;

import common.utils.Node;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 **/
public class SwapNodesInPairs {

	public static Node swap(Node head) {
		if (head == null || head.next == null)
			return head;
		Node sen = new Node(0, head);
		Node pre = sen;
		Node first = head, second = head.next;
		while (first != null && second != null) {
			first.next = second.next;
			second.next = first;
			pre.next = second;
			if (first.next == null)
				break;
			pre = first;
			first = first.next;
			second = first.next;
		}

		return sen.next;
	}

	public static void print(Node h) {
		while (h != null) {
			System.out.print(h.val + ",");
			h = h.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node h = new Node(1, new Node(2));
		print(h);
		print(swap(h));
	}

	// Laiq's submission
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode temp = head.next;
		head.next = temp.next;
		temp.next = head;
		head = temp;
		head.next.next = swapPairs(head.next.next); // dry run this to
													// understand 'next.next'
													// sequence
		return head;
	}
}
