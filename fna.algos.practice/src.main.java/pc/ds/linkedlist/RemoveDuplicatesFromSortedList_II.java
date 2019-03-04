package pc.ds.linkedlist;

public class RemoveDuplicatesFromSortedList_II {
	/**
	 * Given a sorted linked list, delete all nodes that have duplicate numbers,
	 * leaving only distinct numbers from the original list.
	 * 
	 * Example 1:
	 * 
	 * Input: 1->2->3->3->4->4->5 Output: 1->2->5 Example 2:
	 * 
	 * Input: 1->1->1->2->3 Output: 2->3
	 **/
	
	public ListNode deleteDuplicates_01(ListNode head) {
		ListNode t = new ListNode(0);
		t.next = head;

		ListNode p = t;
		while (p.next != null && p.next.next != null) {
			if (p.next.val == p.next.next.val) {
				int dup = p.next.val;
				while (p.next != null && p.next.val == dup) {
					p.next = p.next.next;
				}
			} else {
				p = p.next;
			}

		}

		return t.next;
	}
	
	//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28335/My-accepted-Java-code
	public ListNode deleteDuplicates_02(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }
	
	// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28339/My-Recursive-Java-Solution
	public ListNode deleteDuplicates_03(ListNode head) {
	    if (head == null) return null;
	    
	    if (head.next != null && head.val == head.next.val) {
	        while (head.next != null && head.val == head.next.val) {
	            head = head.next;
	        }
	        return deleteDuplicates_03(head.next);
	    } else {
	        head.next = deleteDuplicates_03(head.next);
	    }
	    return head;
	}
}
