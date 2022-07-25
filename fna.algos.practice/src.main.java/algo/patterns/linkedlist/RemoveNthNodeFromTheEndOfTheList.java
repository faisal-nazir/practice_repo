package algo.patterns.linkedlist;

public class RemoveNthNodeFromTheEndOfTheList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return head;
        
        ListNode start = new ListNode(0);
        start.next = head;
        
        ListNode slow = start;
        ListNode fast = start;
        
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return start.next;
    }
}