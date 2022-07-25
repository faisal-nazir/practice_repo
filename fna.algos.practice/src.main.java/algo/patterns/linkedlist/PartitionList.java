package algo.patterns.linkedlist;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode lt = new ListNode(0);
        ListNode gt = new ListNode(0);
        
        /*lt.next = head;
        gt.next = head;*/
        
        ListNode l1 = lt;
        ListNode l2 = gt;
        
        ListNode itr = head;
        while(itr != null) {
            if(itr.val < x) {
                l1.next = itr;
                l1 = l1.next;
            } else {
                l2.next = itr;
                l2 = l2.next;
            }
            itr = itr.next;
        }
        
        l2.next = null;
        l1.next = gt.next;
        return lt.next;
    }
}