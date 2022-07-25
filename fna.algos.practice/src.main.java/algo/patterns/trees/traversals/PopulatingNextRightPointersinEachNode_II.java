package algo.patterns.trees.traversals;

import java.util.*;

public class PopulatingNextRightPointersinEachNode_II {

    public TreeNode connect(TreeNode root) {
        
        TreeNode head = root;
        while(head != null) { // 'head' moves level by level
            
            TreeNode itr = head; // 'itr' - leading node for current level
            TreeNode anc = new TreeNode(0);
            TreeNode pre = anc; // 'pre' - leading node for next level
            
            while(itr != null) {
                
                if(itr.left != null) {
                    pre.next = itr.left;
                    pre = pre.next;
                }
                
                if(itr.right != null) {
                    pre.next = itr.right;      
                    pre = pre.next;
                }
                
                itr = itr.next;
            }
            
            head = anc.next; // move on to next level
        }
        
        return root;
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;

        public TreeNode() {}
        
        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
