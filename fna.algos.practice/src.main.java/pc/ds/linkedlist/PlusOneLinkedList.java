package pc.ds.linkedlist;

import common.utils.Node;

/**
 * Given a non-negative integer represented as non-empty a singly linked list of
 * digits, plus one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the number
 * 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * Example :
 * 
 * Input: [1,2,3] Output: [1,2,4]
 * Input: [9,9,9] Output: [1,0,0,0]
 **/
public class PlusOneLinkedList {

	public static Node addOne(Node head) {
		if (head == null)
			return null;
		int carry = helper(head);
		if (carry > 0) {
			head = new Node(1, head);
		}
		return head;
	}

	public static int helper(Node n) {
		if (n == null)
			return 1;
		int carry = helper(n.next);
		if (carry > 0) {
			int sum = n.val + carry;
			n.val = sum % 10;
			carry = sum / 10;
		}
		return carry;
	}

	public static void main(String[] args) {
		Node head = new Node(9);
		head.next = new Node(9);
		head.next.next = new Node(9);

		print(head);

		Node result = addOne(head);
		print(result);
	}

	private static void print(Node n) {
		while (n != null) {
			System.out.print(n.val + ",");
			n = n.next;
		}
		System.out.println();
	}
}
