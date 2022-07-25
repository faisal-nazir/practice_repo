package algo.patterns.linkedlist;

public class LinkedListCycleII {

    // for a simple description of Floyed Cycle detection algorithm
    // see https://www.youtube.com/watch?v=OFr16YdsBEQ&list=PLujIAthk_iiO7r03Rl4pUnjFpdHjdjDwy&index=6&ab_channel=KennyTalksCode
    
	public ListNode detectCycle(ListNode head) {
        if(head ==  null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                isCycle = true;
                break;
            }       
        }
        
        if(!isCycle) return null;
        
        fast = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}