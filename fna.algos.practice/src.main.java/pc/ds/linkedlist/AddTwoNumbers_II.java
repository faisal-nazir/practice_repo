package pc.ds.linkedlist;

import java.util.Stack;

public class AddTwoNumbers_II {

	/**
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The most significant digit comes first and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked
	 * list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except
	 * the number 0 itself.
	 * 
	 * Follow up: What if you cannot modify the input lists? In other words,
	 * reversing the lists is not allowed.
	 * 
	 * Example:
	 * 
	 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
	 **/
	// My own version of the solution
	private ListNode addNumbers(ListNode n1, ListNode n2) {
		int len_1 = length(n1);
		int len_2 = length(n2);

		if (len_1 < len_2) {
			n1 = padList(n1, len_2 - len_1);
		} else {
			n2 = padList(n2, len_1 - len_2);
		}

		SumNode res = helper(n1, n2);
		if (res.carry != 0) {
			ListNode head = new ListNode(res.carry, res.valueNode);
			return head;
		}
		return res.valueNode;
	}

	private SumNode helper(ListNode n1, ListNode n2) {
		if (n1 == null && n2 == null)
			return new SumNode();

		ListNode next_1 = (n1 != null) ? n1.next : null;
		ListNode next_2 = (n2 != null) ? n2.next : null;

		SumNode prev = helper(next_1, next_2);

		int v1 = (n1 != null) ? n1.val : 0;
		int v2 = (n2 != null) ? n2.val : 0;
		int sum = v1 + v2 + prev.carry;

		ListNode valueNode = new ListNode(sum % 10, prev.valueNode);
		SumNode current = new SumNode();
		current.valueNode = valueNode;
		current.carry = sum / 10;

		return current;
	}

	private int length(ListNode head) {
		int len = 0;
		while (head != null) {
			++len;
			head = head.next;
		}
		return len;
	}

	private ListNode padList(ListNode list, int count) {
		ListNode head = list;
		for (int i = 0; i < count; ++i) {
			head = new ListNode(0, head);
		}
		return head;
	}

	private static class SumNode {
		ListNode valueNode;
		int carry;
	}
	
	// https://leetcode.com/problems/add-two-numbers-ii/discuss/92623/Easy-O(n)-Java-Solution-using-Stack
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }
}
