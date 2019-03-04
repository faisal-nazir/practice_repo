package pc.ds.linkedlist;

import java.util.Stack;

public class ReorderList {

	/**
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
	 * L0→Ln→L1→Ln-1→L2→Ln-2→…
	 * 
	 * You may not modify the values in the list's nodes, only nodes itself may
	 * be changed.
	 * 
	 * Example 1:
	 * 
	 * Given 1->2->3->4, reorder it to 1->4->2->3. Example 2:
	 * 
	 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
	 **/
	// My own version of the solution
	private static ListNode reorderList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		Stack<ListNode> s = new Stack<ListNode>();
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// if(fast == null) { // case when list has odd number of nodes
		// slow = slow.next;
		// }

		ListNode tail = slow;
		slow = slow.next;
		while (slow != null) {
			s.push(slow);
			slow = slow.next;
		}
		tail.next = null;

		ListNode itr = head;
		while (!s.isEmpty()) {
			ListNode next = itr.next;
			ListNode elem = s.pop();
			itr.next = elem;
			elem.next = next;
			itr = next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode h = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		ListNode itr = h;
		while(itr != null) {
			System.out.print(itr.val + ", ");
			itr = itr.next;
		}
		System.out.println();
		
		ListNode n = reorderList(h);
		itr = n;
		while(itr != null) {
			System.out.print(itr.val + ", ");
			itr = itr.next;
		}
		System.out.println();
	}

}
