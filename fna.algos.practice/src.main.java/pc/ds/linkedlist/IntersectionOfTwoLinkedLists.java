package pc.ds.linkedlist;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * 
 * begin to intersect at node c1.
 **/

public class IntersectionOfTwoLinkedLists {

	// https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49792/Concise-JAVA-solution-O(1)-memory-O(n)-time

	public ListNode getIntersectionNode_01(ListNode headA, ListNode headB) {
		int lenA = length(headA), lenB = length(headB);
		// move headA and headB to the same start point
		while (lenA > lenB) {
			headA = headA.next;
			lenA--;
		}
		while (lenA < lenB) {
			headB = headB.next;
			lenB--;
		}
		// find the intersection until end
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	private int length(ListNode node) {
		int length = 0;
		while (node != null) {
			node = node.next;
			length++;
		}
		return length;
	}

	// https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
	public ListNode getIntersectionNode_02(ListNode headA, ListNode headB) {
		// boundary check
		if (headA == null || headB == null)
			return null;

		ListNode a = headA;
		ListNode b = headB;

		// if a & b have different len, then we will stop the loop after second
		// iteration
		while (a != b) {
			// for the end of first iteration, we just reset the pointer to the
			// head of another linkedlist
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}

		return a;
	}
}
