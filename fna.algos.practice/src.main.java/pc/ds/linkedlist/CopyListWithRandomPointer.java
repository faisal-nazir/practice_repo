package pc.ds.linkedlist;

import java.util.HashMap;

public class CopyListWithRandomPointer {

	/**
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null.
	 * 
	 * Return a deep copy of the list.
	 **/
	// O(n) space solution
	public RandomNode copy(RandomNode head) {
		HashMap<RandomNode, RandomNode> map = new HashMap<RandomNode, RandomNode>();
		RandomNode itr = head;
		while (null != itr) {
			map.put(itr, new RandomNode(itr.value));
			itr = itr.next;
		}
		itr = head;
		while (null != itr) {
			map.get(itr).next = map.get(itr.next);
			map.get(itr).random = map.get(itr.random);
			itr = itr.next;
		}
		return map.get(head);
	}

	// constant space solution.
	// https://www.programcreek.com/2012/12/leetcode-copy-list-with-random-pointer/
	public RandomNode copyRandomList(RandomNode head) {

		if (head == null)
			return null;

		RandomNode p = head;

		// copy every node and insert to list
		while (p != null) {
			RandomNode copy = new RandomNode(p.value);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}

		// copy random pointer for each new node
		p = head;
		while (p != null) {
			if (p.random != null)
				p.next.random = p.random.next;
			p = p.next.next;
		}

		// break list to two
		p = head;
		RandomNode newHead = head.next;
		while (p != null && p.next != null) {
			RandomNode temp = p.next;
			p.next = temp.next;
			p = temp;
		}

		return newHead;
	}
}
