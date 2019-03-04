package pc.ds.linkedlist;

public class RemoveDuplicatesFromSortedList_I {

	/**
	 * Given a sorted linked list, delete all duplicates such that each element
	 * appear only once.
	 * 
	 * Example 1:
	 * 
	 * Input: 1->1->2 Output: 1->2 Example 2:
	 * 
	 * Input: 1->1->2->3->3 Output: 1->2->3
	 **/
	
	public ListNode deleteDuplicates_01(ListNode head) {
		ListNode list = head;

		while (list != null) {
			if (list.next == null) {
				break;
			}
			if (list.val == list.next.val) {
				list.next = list.next.next;
			} else {
				list = list.next;
			}
		}

		return head;
	}

	public ListNode deleteDuplicates_02(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicates_02(head.next);
		return head.val == head.next.val ? head.next : head;
	}
}
