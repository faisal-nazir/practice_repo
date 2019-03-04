package ctci.ds.linkedlist;

import common.utils.LinkedList;
import common.utils.Node;

import java.util.HashSet;

public class RemoveDuplicates {

	public static void deDuplicate(Node head) {
		if(head == null) return;
		
		Node itr = head;
		HashSet<Integer> set = new HashSet<Integer>();
		while(itr.next != null) {
			if(set.contains(itr.next.val))
				itr.next = itr.next.next;
			else {
				set.add(itr.next.val);
				itr = itr.next;
			}
			
		}
	}
	
	public static void deDuplicateWithoutSpace(Node head) {
		Node curr = head;
		while(curr != null) {
			Node next = curr.next;
			Node prev = curr;
			while(next != null) {
				if(next.val == curr.val)
					prev.next = next.next;
				else {
					prev = next;
				}
				next = next.next;
			}
			curr = curr.next;
		}
		
	}
	
	private static LinkedList getList() {
		LinkedList list = new LinkedList();
		list.add(2);
		list.add(5);
		list.add(2);
		list.add(1);
		
		return list;
	}
	
	public static void main(String[] args) {
		LinkedList list = getList();
		deDuplicateWithoutSpace(list.head);
		print(list.head);
	}
	
	public static void print(Node head) {
		while(head != null) {
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println();
	}
}
