package pc.ds.linkedlist;

import common.utils.Node;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * Only constant extra memory is allowed. You may not alter the values in the
 * list's nodes, only nodes itself may be changed.
 **/
public class ReverseNodesInKGroups {

	public static Node reverseInGroup(Node head, int k) {
		if (head == null || k <= 1)
			return head;
		int i = 0;
		Node fake = new Node(0, head);
		Node pre = fake;
		Node p = head;
		while (p != null) {
			++i;
			if (i % k == 0) {
				pre = reverse(pre, p.next);
				p = pre.next;
			} else {
				p = p.next;
			}
		}
		return fake.next;
	}

	/*
	 * 0->1->2->3->4->5->6 | | pre next
	 * 
	 * after calling pre = reverse(pre, next)
	 * 
	 * 0->3->2->1->4->5->6 | | pre next
	 */

	public static Node reverse(Node start, Node end) {
		Node last = start.next;
		Node curr = last.next;

		while (curr != null && curr != end) {
			last.next = curr.next;
			curr.next = start.next;
			start.next = curr;
			curr = last.next;
		}
		return last;
	}

	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5,
				new Node(6, new Node(7, new Node(8))))))));
		print(head);
		// Node result = reverseKNodes(head, 3);
		Node result = reverseInGroup(head, 3);
		print(result);
	}

	public static void print(Node n) {
		while (n != null) {
			System.out.print(n.val);
			n = n.next;
		}
		System.out.println();
	}

	private static Node reverseKNodes(Node head, int k) {
		Node itr = head;
		Node prv = null;
		int count = 0;
		while (count < k && itr != null) {
			Node next = itr.next;
			itr.next = prv;
			prv = itr;
			itr = next;
			++count;
		}

		if (itr != null)
			head.next = reverseKNodes(itr, k);

		return prv;
	}

	// https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11423/Short-but-recursive-Java-code-with-comments
	// picked up from comments
	public Node reverseKGroup(Node head, int k) {
		// 1. test weather we have more then k node left, if less then k node
		// left we just return head
		Node node = head;
		int count = 0;
		while (count < k) {
			if (node == null)
				return head;
			node = node.next;
			count++;
		}
		// 2.reverse k node at current level
		Node pre = reverseKGroup(node, k); // pre node point to the the answer
											// of sub-problem
		while (count > 0) {
			Node next = head.next;
			head.next = pre;
			pre = head;
			head = next;
			count--;
		}
		return pre;
	}

}
