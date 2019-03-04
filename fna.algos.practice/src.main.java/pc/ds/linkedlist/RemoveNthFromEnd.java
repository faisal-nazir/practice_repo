package pc.ds.linkedlist;

import common.utils.Node;

/**
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
 **/

public class RemoveNthFromEnd {

	public static Node removeNthFromEnd(Node head, int n) {
		if (n <= 0)
			return head;

		Node start = new Node(0);
		Node slow = start, fast = start;
		slow.next = head;

		// Move fast in front so that the gap between slow and fast becomes n
		for (int i = 0; i <= n; i++) {
			if (fast == null)
				return null; // out of bounds
			fast = fast.next;
		}
		// Move fast to the end, maintaining the gap
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		// Skip the desired node
		slow.next = slow.next.next;
		return start.next;
	}

	public static void main(String[] args) {
		Node list = new Node(1, new Node(2, new Node(3,
				new Node(4, new Node(5)))));
		print(list);
		Node result = removeNthFromEnd(list, 2);
		print(result);
	}

	public static void print(Node n) {
		while (n != null) {
			System.out.print(n.val + ",");
			n = n.next;
		}
		System.out.println();
	}

}
