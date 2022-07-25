package algo.patterns.trees;

import java.util.*;

public class MostFrequentSubTreeSum {

	int max;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        fill(root, map);
        
        for(Integer key : map.keySet()) {
            if(map.get(key) == max)
                list.add(key);
        }
        
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    
    public int fill(TreeNode root, Map<Integer, Integer> map) {
        if(root == null) return 0;
        
        int left = fill(root.left, map);
        int right = fill(root.right, map);
        
        int sum = left + root.val + right;
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        
        return sum;
    }
}