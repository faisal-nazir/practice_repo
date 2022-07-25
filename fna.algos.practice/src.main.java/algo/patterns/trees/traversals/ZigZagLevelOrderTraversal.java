package algo.patterns.trees.traversals;

import java.util.*;
import algo.patterns.trees.TreeNode;

public class ZigZagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        zigzagLevelOrder(root, 0, res);
        return res;
    }
    
    private void zigzagLevelOrder(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null) return;
        
        if(level == res.size())
            res.add(new LinkedList<>());
        
        if(level % 2 == 0) 
            res.get(level).add(root.val);
        else
            res.get(level).add(0, root.val);
        
        zigzagLevelOrder(root.left, level+1, res);
        zigzagLevelOrder(root.right, level+1, res);
    }


    public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean isOdd = false;
        while(!q.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = q.size();
            
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.remove();
                
                if(isOdd) {
                    level.add(0, n.val);
                } else {
                    level.add(n.val);
                }
                
                if(n.left != null) {
                    q.add(n.left);
                }
                
                if(n.right != null) {
                    q.add(n.right);
                }
            }
            isOdd = !isOdd;
            res.add(level);
        }
        
        return res;
    }
}
