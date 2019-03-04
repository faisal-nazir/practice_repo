package pc.ds.linkedlist;

public class MergeTwoSortedLists {

	/**
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 * 
	 * Example:
	 * 
	 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
	 **/

	// https://leetcode.com/problems/merge-two-sorted-lists/discuss/9713/A-recursive-solution
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode dummyHead = new ListNode(), ptr = dummyHead;

		while (l1 != null && l2 != null) {

			if (l1.val <= l2.val) {
				ptr.next = l1;
				l1 = l1.next;
			} else {
				ptr.next = l2;
				l2 = l2.next;
			}

			ptr = ptr.next;

		}

		ptr.next = l1 == null ? l2 : l1;

		return dummyHead.next;

	}

	public ListNode mergeLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.val <= l2.val) {
			l1.next = mergeLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeLists(l2.next, l1);
			return l2;
		}
	}
}
