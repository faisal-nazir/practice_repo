package algo.patterns.trees.traversals;

import java.util.*;
import algo.patterns.trees.TreeNode;

public class FindLargestValueInEachTreeRow {

	public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        largestValues(root, 0, res);
        return res;
    }
    
    private void largestValues(TreeNode root, int level, List<Integer> res) {
        if(root == null) return;
        
        if(res.size() == level)
            res.add(Integer.MIN_VALUE);
        
        res.set(level, Math.max(res.get(level), root.val));
        
        largestValues(root.left, level+1, res);
        largestValues(root.right, level+1, res);
    }
}
