package algo.patterns.linkedlist;

public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode start = new ListNode(0);
        start.next = head;
        
        ListNode itr = start;
        
        while(itr.next != null && itr.next.next != null) {
            ListNode n1 = itr.next;
            ListNode n2 = n1.next;
            
            itr.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            
            itr = n1;
        }
        
        return start.next;
    }
}