package algo.patterns.trees;

import java.util.*;

public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        findPaths(root, new ArrayList<Integer>(), targetSum, res);
        return res;
    }
    
    public void findPaths(TreeNode root, List<Integer> list, int target, List<List<Integer>> res) {
        if(root == null) return;
        
        list.add(root.val);
        
        if(root.left == null && root.right == null && root.val == target) {    
            res.add(new ArrayList<Integer>(list));
        }
        
        findPaths(root.left, list, target - root.val, res);
        findPaths(root.right, list, target - root.val, res);
        
        list.remove(list.size()-1);
    }
}