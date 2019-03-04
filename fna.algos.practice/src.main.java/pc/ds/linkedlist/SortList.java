package pc.ds.linkedlist;

import common.utils.Node;

public class SortList {

	public static Node sort(Node head) {
		if(head == null || head.next == null) return head;
		Node slow = head, fast = head, prev = slow;
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = null;
		
		Node first = sort(head);
		Node second = sort(slow);
		
		return merge(first, second);
	}
	
	public static Node merge(Node first, Node second) {
		Node d = new Node(0),  p = d;
		while(first != null && second != null) {
			if(first.val < second.val) {
				p.next = first;
				first = first.next;
			} else {
				p.next = second;
				second = second.next;
			}
			p = p.next;
		}
		if(first != null) p.next = first;
		if(second != null) p.next = second;
		return d.next;
	}
	
	public static void main(String[] args) {
		Node list = new Node(4, new Node(3, new Node(7, new Node(5, new Node(2, new Node(1))))));
		print(list);
		list = sort(list);
		print(list);
	}
	
	public static void print(Node n) {
		while(n != null) {
			System.out.print(n.val + ",");
			n = n.next;
		}
		System.out.println();	
	}
}
