package ctci.ds.linkedlist;

import common.utils.Node;

public class Intersection {
	public static boolean intersect(Node first, Node second) {
		int len1 = lengthOf(first);
		int len2 = lengthOf(second);
		int diff = len1 - len2;

		while(diff < 0) {
			second = second.next;
			++diff;
		}
		
		while(diff > 0) {
			first = first.next;
			--diff;
		}
		
		while(first != null && second != null) {
			if(first == second) return true;
			first = first.next;
			second = second.next;
		}
		return false;
	}
	
	public static int lengthOf(Node head) {
		if(head == null) return 0;
		return lengthOf(head.next)+ 1; 
	}
	
	public static void main(String[] args) {
		Node common = new Node(5, new Node(7, new Node(9)));
		Node first = new Node(0, new Node(2, new Node(4, common)));
		Node second = null;
		
		System.out.println(intersect(first, second));
	}
}
