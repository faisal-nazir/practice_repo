package com.epi.linkedlists;

public class ReverseASubList {

	private static class Node {
		int value;
		Node next;
		
		Node(int val, Node n) {
			this.value = val;
			this.next = n;
		}
	}
	
	public static Node reverse(Node head, int s, int e) {
		Node sen = new Node(0, head);
		Node pre = sen;
		for(int i = 0; i < s-1; ++i) {
			pre = pre.next;
		}
		helper(pre, e-s);
		return sen.next;
	}
	
	private static void helper(Node start, int k) {
		Node last = start.next;
		Node curr = last.next;
		
		for(int i = 0; i < k; ++i) {
			last.next = curr.next;
			curr.next = start.next;
			start.next = curr;
			curr = last.next;
		}
	}
	
	public static void main(String[] args) {
		Node list = getList();
		print(list);
		Node updated = reverse(list, 1, 4);
		print(updated);
	}
	
	private static Node getList() {
		Node h = new Node(11, new Node(3, new Node(5, new Node(7, new Node(2, null)))));
		return h;
	}
	
	private static void print(Node n) {
		System.out.println();
		while(n != null) {
			System.out.print(n.value + " ");
			n = n.next;
		}
	}
}
