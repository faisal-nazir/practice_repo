package pc.ds.linkedlist;

import common.utils.Node;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * Input: head = 1->4->3->2->5->2, x = 3 Output: 1->2->2->4->3->5
 **/
public class PartitionList {

	public Node partitionList(Node head, int k) {
		if (head == null)
			return head;
		Node itr = head;
		Node lt_head = null, gt_head = null, lt_tail = null, gt_tail = null;
		while (itr != null) {
			Node next = itr.next;
			if (itr.val < k) {
				if (lt_head == null) {
					lt_head = lt_tail = itr;
				} else {
					lt_tail.next = itr;
					lt_tail = lt_tail.next;
				}
				lt_tail.next = null;
			} else {
				if (gt_head == null) {
					gt_head = gt_tail = itr;
				} else {
					gt_tail.next = itr;
					gt_tail = gt_tail.next;
				}
				gt_tail.next = null;
			}
			itr = next;
		}

		if (lt_head != null && gt_head != null) {
			lt_tail.next = gt_head;
			return lt_head;
		} else if (lt_head == null) {
			return gt_head;
		} else
			return lt_head;
	}
}
