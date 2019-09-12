package com.epi.linkedlists;

public class Cyclicity {

	private static class Node {
		int val;
		Node next;
		
		Node(int v, Node n) {
			this.val = v;
			this.next = n;
		}
	}
	
	public boolean isCyclic(Node head) {
		if(head == null || head.next == null) return false;
		Node slow = head;
		Node fast = slow;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		
		return false;
	}
	
	public Node findStartoftheCycle(Node head) {
		Node slow = head, fast = head;
		boolean isCyclic = false;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				isCyclic = true;
				break;
			}
		}
		
		if(isCyclic) {
			int len_cycle = 0;
			do {
				fast = fast.next;
				++len_cycle;
			} while(slow != fast);
			
			Node adv = head;
			Node itr = head;
			while(len_cycle-- > 0) {
				adv = adv.next;
			}
			
			while(itr != adv) {
				itr = itr.next;
				adv = adv.next;
			}
			return itr;
		}
				
		return null;
	}
	
	public static Node findStart(Node head) {
		if(head == null || head.next == null) return null;
		Node slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				slow = head;
				while(slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				
				return slow;
			}
		}
		return null;
	}
}
