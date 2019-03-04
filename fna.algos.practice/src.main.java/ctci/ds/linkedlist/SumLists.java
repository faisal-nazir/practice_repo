package ctci.ds.linkedlist;

import common.utils.Node;

public class SumLists {
	
	public static Node sum(Node first, Node second) {
		return sum(first, second, 0);
	}
	
	public static Node sum(Node first, Node second, int carry) {
		if(first == null && second == null && carry == 0) return null;
		
		int value = carry;
		
		value += (first != null)? first.val : 0;
		value += (second != null)? second.val : 0;
		
		carry = value/10;
		value = value%10;
		
		Node head = new Node(value);
		
		Node n1 = (first != null)? first.next : null;
		Node n2 = (second != null)? second.next : null;
		
		head.next = sum(n1, n2, carry);
		return head;
	}
	
	public static void main(String[] args) {
		Node first = new Node(7, new Node(1, new Node(6)));
		Node second = new Node(5, new Node(9, new Node(2)));
		
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
}
