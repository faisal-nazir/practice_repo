package algo.patterns.trees.traversals;

import java.util.*;

public class PopulatingNextRightPointersinEachNode_I {

	public TreeNode connectBFS(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        TreeNode head = null;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; ++i) {
                TreeNode curr = q.poll();
                if(head == null) {
                    head = curr;
                } else {
                    head.next = curr;
                    head = head.next;
                }
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            head = null;
        }
        return root;
    }

    public TreeNode connect(TreeNode root) {
        if(root == null) return root;
        
        TreeNode head = root;
        while(head != null) {
            TreeNode itr = head;
            while(itr != null) {
                if(itr.left != null) {
                    itr.left.next = itr.right;
                }
                if(itr.next != null && itr.right != null) {
                    itr.right.next = itr.next.left;
                }
                itr = itr.next;
            }
            head = head.left;
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
