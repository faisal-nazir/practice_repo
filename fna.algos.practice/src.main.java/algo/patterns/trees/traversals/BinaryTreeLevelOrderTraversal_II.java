package algo.patterns.trees.traversals;

import java.util.*;
import algo.patterns.trees.TreeNode;

public class BinaryTreeLevelOrderTraversal_II {

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, 0, res);
        return res;
    }
    
    private void traverse(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null) return;
        
        if(level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        traverse(root.left, level+1, res);
        traverse(root.right, level+1, res);
    }
}
