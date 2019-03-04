package ctci.ds.linkedlist;

import common.utils.Node;

import java.util.Stack;

public class Palindrome {
	public static boolean isPalindrome(Node head) {
		if(head == null) return false;
		Node slow = head, fast = head;
		Stack<Integer> stack = new Stack<Integer>();

		while(fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null) {
			slow = slow.next;
		}
		
		while(slow != null) {
			if(slow.val != stack.peek()) 
				return false;
			slow = slow.next;
			stack.pop();
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node list = new Node(3, new Node(2, new Node(1, new Node(2, new Node(3, new Node(4))))));
		System.out.print(isPalindrome(list));
	}
}
