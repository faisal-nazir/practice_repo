package pc.ds.linkedlist;

import common.utils.Node;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 **/

public class RemoveLinkedListElements {

	public static Node remove(Node list, int value) {
		Node sen = new Node(0, list);
		Node pre = sen;
		Node itr = pre.next;
		while (itr != null) {
			if (itr.val == value)
				pre.next = itr.next;
			else {
				pre = itr;
			}
			itr = itr.next;
		}

		return sen.next;
	}

	public static void main(String[] args) {
		Node h = new Node(3, new Node(1, new Node(5, new Node(7, new Node(3)))));
		print(h);
		print(remove(h, 6));
	}

	public static void print(Node h) {
		while (h != null) {
			System.out.print(h.val + ",");
			h = h.next;
		}
		System.out.println();
	}
}
