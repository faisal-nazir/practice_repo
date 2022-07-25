package algo.patterns.heap;

import java.util.*;

public class MergeKSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> q = new PriorityQueue<>
            ((a,b)-> a.val - b.val);
        
        for(ListNode list : lists) {
            if(list != null)
                q.add(list);
        }
        
        ListNode anc = new ListNode(0);
        ListNode itr = anc;
        
        while(!q.isEmpty()) {
            itr.next = q.remove();
            itr = itr.next;
            if(itr.next != null) {
                q.add(itr.next);
            }
        }
        
        return anc.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 
}