package pc.ds.linkedlist;

import common.utils.Node;

/**
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 **/
public class ReverseList_I {

	public static Node reverse(Node n) {
		Node prv = null;
		Node itr = n;
		while (itr != null) {
			Node next = itr.next;
			itr.next = prv;
			prv = itr;
			itr = next;
		}
		return prv;
	}

	public static Node reverseRec(Node n) {
		return helper(n, null);
	}

	public static Node helper(Node head, Node prv) {
		if (head == null)
			return prv;
		Node next = head.next;
		head.next = prv;
		return helper(next, head);
	}

	public static Node reverseRecursive(Node head) {
		if (head == null || head.next == null)
			return head;
		Node result = reverseRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return result;
	}

	public static void main(String[] args) {
		Node n = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
		print(n);
		print(reverseRecursive(n));
	}

	public static void print(Node n) {
		while (n != null) {
			System.out.print(n.val + ",");
			n = n.next;
		}
		System.out.println();
	}
}
