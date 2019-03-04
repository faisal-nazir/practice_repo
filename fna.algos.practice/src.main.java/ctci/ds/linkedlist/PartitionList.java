package ctci.ds.linkedlist;

import common.utils.Node;

public class PartitionList {
	public static Node partitionList(Node head, int k) {
		if(head == null) return head;
		Node itr = head;
		Node lt_head = null, gt_head = null, lt_tail = null, gt_tail = null;
		while(itr != null) {
			Node next = itr.next;
			if(itr.val < k) {
				if(lt_head == null) {
					lt_head = lt_tail = itr;
				} else {
					lt_tail.next = itr;
					lt_tail = lt_tail.next;
				}
				lt_tail.next = null;
			} else {
				if(gt_head == null) {
					gt_head = gt_tail = itr;
				} else {
					gt_tail.next = itr;
					gt_tail = gt_tail.next;
				}
				gt_tail.next = null;
			}
			itr = next;
		}
		
		if(lt_head != null && gt_head != null) {
			lt_tail.next = gt_head;
			return lt_head;
		} else if (lt_head == null) {
			return gt_head;
		} else 
			return lt_head;
	}
	
	public static void main(String[] args) {
		Node orig = new Node(3, new Node(5, new Node(8, new Node(5, new Node(10, new Node(2, new Node(1)))))));
		print(orig);
		print(partitionList(orig, 5));
	}
	
	public static void print(Node n) {
		if(n == null) {
			System.out.println();
			return;
		}
		System.out.print(n.val + ",");
		print(n.next);
	}
}
