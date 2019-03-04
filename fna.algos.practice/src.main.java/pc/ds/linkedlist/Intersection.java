package pc.ds.linkedlist;

import common.utils.Node;

public class Intersection {
	
	public static Node findIntersectingNode(Node list1, Node list2) {
		LNode first = getLength(list1);
		LNode second = getLength(list2);
		
		if(first.lastNode != second.lastNode) return null;
		Node smaller = (first.length < second.length)? list1 : list2;
		Node bigger = (first.length < second.length)? list2 : list1; 
		
		int len_bigger = (first.length < second.length)? second.length : first.length;
		int len_smaller = (first.length < second.length)? first.length : second.length;
		
		for(int i = len_smaller; i < len_bigger; ++i) smaller = smaller.next;
		while(smaller != bigger) {
			smaller = smaller.next;
			bigger = bigger.next;
		}
		return smaller;
	}
	
	private static class LNode {
		Node lastNode;
		int length;
		
		LNode(Node n, int len) {
			lastNode = n;
			length = len;
		}
	}
	
	private static LNode getLength(Node h) {
		if(h == null) return new LNode(h, 0);
		int len = 1;
		while(h.next != null) {
			h = h.next;
			len++;
		}
		return new LNode(h, len);
	}
}
