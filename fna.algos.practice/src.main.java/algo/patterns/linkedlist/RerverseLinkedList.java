package algo.patterns.linkedlist;

public class RerverseLinkedList {

	public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        
        ListNode pre = null;
        ListNode next = null;
        
        ListNode itr = head;
        while(itr != null) {
            next = itr.next;
            itr.next = pre;
            
            pre = itr;
            itr = next;
        }
        
        return pre;
    }
}