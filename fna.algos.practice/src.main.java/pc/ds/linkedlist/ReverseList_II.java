package pc.ds.linkedlist;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4 Output: 1->4->3->2->5->NULL
 **/
public class ReverseList_II {

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return head;
		ListNode sen = new ListNode(0, head);
		ListNode pre = sen;
		for (int i = 0; i < m - 1; ++i)
			pre = pre.next;
		reverse(pre, n - m);
		return sen.next;
	}

	public static void reverse(ListNode start, int k) {
		// start is one before the node that needs to be reversed and
		// remains fixed through out, to point to the current element
		// that is being reversed.
		ListNode last = start.next;
		ListNode curr = last.next;

		for (int i = 0; i < k; ++i) {
			last.next = curr.next;
			curr.next = start.next;
			start.next = curr;
			curr = last.next;
		}
	}

	public static void main(String[] args) {
		ListNode h = new ListNode(1, new ListNode(2, new ListNode(3,
				new ListNode(4, new ListNode(5)))));
		print(h);
		ListNode r = reverseBetween(h, 2, 4);
		print(r);
		printInReverse(r);
	}

	public static void print(ListNode h) {
		while (h != null) {
			System.out.print(h.val + ",");
			h = h.next;
		}
		System.out.println();
	}

	public static void printInReverse(ListNode h) {
		if (h == null)
			return;
		printInReverse(h.next);
		System.out.print(h.val + ", ");
	}
}
