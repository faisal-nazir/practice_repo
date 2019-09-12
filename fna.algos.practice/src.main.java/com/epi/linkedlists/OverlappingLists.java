package com.epi.linkedlists;

public class OverlappingLists {
	
	//EPI-8.4: Test for overlapping lists - lists are cycle free

	private static class Node {
		int value;
		Node next;
		
		Node(int val, Node n) {
			this.value = val;
			this.next = n;
		}
	}
	
	public static Node test(Node list1, Node list2) {
		int len1 = getLength(list1);
		int len2 = getLength(list2);
		
		if(len1 > len2) {
			list1 = advanceList(list1, len1-len2);
		} else {
			list2 = advanceList(list2, len2-len1);
		}
		
		while(list1 != null && list2 != null && list1 != list2) {
			list1 = list1.next;
			list2 = list2.next;
		}
		
		return list1; 
	}
	
	private static int getLength(Node n) {
		int len=0;
		while(n != null) {
			n = n.next;
		}
		return len;
	}
	
	private static Node advanceList(Node list, int k) {
		Node p = list;
		while(k-- > 0 && p != null) 
			p = p.next;
		return p;
	}
	
}
