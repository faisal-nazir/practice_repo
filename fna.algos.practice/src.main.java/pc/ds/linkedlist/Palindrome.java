package pc.ds.linkedlist;

import common.utils.Node;

public class Palindrome {

	public static boolean isPalindrome(Node head) {
		if(head == null) return false;
		Node reversed = reverseAndCopy(head);
		return isEqual(head, reversed);
	}
	
	private static Node reverseAndCopy(Node head) {
		Node itr = head;
		Node res = null;
		while(itr != null) {
			res = new Node(itr.val, res);
			itr = itr.next;
		}
		
		return res;
	}
	
	private static boolean isEqual(Node first, Node second) {
		if(first == null && second == null) return true;
		if(first == null || second == null) return false;
		return (first.val == second.val) && isEqual(first.next, second.next);
	}
	
	public static void main(String[] args) {
		Node n = new Node(3, new Node(2, new Node(1, new Node(2, new Node(3)))));
		System.out.print(isPalindromeRecur(n));
	}
	
	public static boolean isPalindromeRecur(Node head) {
		RNode result = helper(head, getLength(head));
		return result.flag;
	}
	
	public static RNode helper(Node head, int len) {
		if(head == null || len <= 0) // even number of nodes
			return new RNode(head, true);
		else if(len == 1) // odd number of nodes
			return new RNode(head.next, true);
		
		RNode n = helper(head.next, len - 2);
		
		if(n.flag == false || n.node == null) return n;
		
		n.flag = head.val == n.node.val;
		n.node = n.node.next;
		return n;
	}
	
	public static int getLength(Node n) {
		int len = 0;
		while(n != null) {
			++len;
			n = n.next;
		}
		return len;
	}
	
	private static class RNode {
		Node node;
		boolean flag;
		
		
		RNode(Node n, boolean f) {
			node = n;
			flag = f;
		}
	}
}
