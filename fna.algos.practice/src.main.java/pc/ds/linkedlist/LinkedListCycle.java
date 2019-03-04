package pc.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

	/**
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 * To represent a cycle in the given linked list, we use an integer pos
	 * which represents the position (0-indexed) in the linked list where tail
	 * connects to. If pos is -1, then there is no cycle in the linked list.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: head = [3,2,0,-4], pos = 1 Output: true Explanation: There is a
	 * cycle in the linked list, where tail connects to the second node.
	 * 
	 * 
	 * Example 2:
	 * 
	 * Input: head = [1,2], pos = 0 Output: true Explanation: There is a cycle
	 * in the linked list, where tail connects to the first node.
	 * 
	 * 
	 * Example 3:
	 * 
	 * Input: head = [1], pos = -1 Output: false Explanation: There is no cycle
	 * in the linked list.
	 **/
	private static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		Set<ListNode> set = new HashSet<ListNode>();
		ListNode itr = head;
		while (itr != null) {
			if (set.contains(itr))
				return true;
			set.add(itr);
			itr = itr.next;
		}
		return false;
	}

	private static boolean hasCycle02(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;
		}
		return false;
	}
}
