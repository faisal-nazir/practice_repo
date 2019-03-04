package ctci.ds.linkedlist;

import common.utils.Node;

public class SumListsForward {
	
	public static Node sum(Node first, Node second) {
		int s1 = sizeOf(first);
		int s2 = sizeOf(second);
		if(s1 != s2) {
			if(s1 < s2) 
				first = padList(first, s2-s1);
			else
				second = padList(second, s1-s2);
		}
		RNode res = sum(first, second, 0);
		return res.node;
	}
	
	public static Node padList(Node head, int c) {
		if(head == null) return null;
		while(c > 0) {
			Node n = new Node(0);
			n.next = head;
			head = n;
			c--;
		}
		return head;
	}
	
	public static int sizeOf(Node n) {
		int size = 0;
		while(n != null) {
			++ size;
			n = n.next;
		}
		return size;
	}
	
	public static RNode sum(Node first, Node second, int carry) {
		if(first == null && second == null && carry == 0) {
			return new RNode(null, 0);
		}
		
		RNode n = sum(first.next, second.next, carry);
		
		int value = n.carry;
		value += first.val;
		value += second.val;
		
		carry = value/10;
		value = value%10;
		
		RNode head = new RNode(new Node(value), carry);
		head.node.next = n.node;
		
		return head;
	}
	
	public static void main(String[] args) {
		Node first = new Node(6, new Node(1, new Node(7)));
		Node second = new Node(9, new Node(5));
		print(first);
		print(second);
		
		Node result = sum(first, second);
		print(result);
	}
	
	public static void print(Node n) {
		if(n == null) {
			System.out.println();
			return;
		}
		System.out.print(n.val + ",");
		print(n.next);
	}
	
	private static class RNode {
		Node node;
		int carry;
		
		RNode(Node n, int c) {
			node = n;
			carry = c;
		}
	}
}
