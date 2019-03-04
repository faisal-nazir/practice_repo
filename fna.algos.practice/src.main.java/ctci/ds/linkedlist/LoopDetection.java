package ctci.ds.linkedlist;

import common.utils.Node;

public class LoopDetection {
	public static Node getStartofLoop(Node head) {
		Node fast = head, slow = head;
		boolean isCyclic = false;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				isCyclic = true;
				break;
			}
		}
		
		if(!isCyclic) return null;
		
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		Node startOfCycle = new Node(4);
		Node head = new Node(2, startOfCycle);
		startOfCycle.next = new Node(6, new Node(8, new Node(10, startOfCycle)));
		
		Node result = getStartofLoop(head);
		if(result != null) {
			System.out.print(result.val);
		} else {
			System.out.println("No Cycle Found");
		}
		
	}
}
