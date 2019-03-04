package pc.ds.linkedlist;

public class AddTwoNumbers_I {

	/**
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The digits are stored in reverse order and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked
	 * list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except
	 * the number 0 itself.
	 * 
	 * Example:
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342
	 * + 465 = 807.
	 **/

	// My own version of the solution
	private ListNode add(ListNode head1, ListNode head2) {
		return add(head1, head2, 0);
	}

	private ListNode add(ListNode head1, ListNode head2, int carry) {
		if (head1 == null && head2 == null && carry == 0)
			return null;

		int first = (head1 == null) ? 0 : head1.val;
		int second = (head2 == null) ? 0 : head2.val;

		int sum = first + second + carry;
		ListNode res = new ListNode();
		res.val = sum % 10;
		carry = sum / 10;

		ListNode first_next = (head1 == null) ? null : head1.next;
		ListNode second_next = (head2 == null) ? null : head2.next;

		res.next = add(first_next, second_next, carry);

		return res;
	}

}
