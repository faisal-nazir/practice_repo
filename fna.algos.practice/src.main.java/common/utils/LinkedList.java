package common.utils;

public class LinkedList {
	public Node head;
	
	public void add(int value) {
		if(head == null) {
			head = new Node(value);
		}
		else {
			Node n = new Node(value);
			n.next = head;
			head = n;
		}
	}
}
