package pc.ds.arrays.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum_II {
	public static List<List<Integer>> combinationSum2(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<Integer>(), nums, target, 0);
	    return list;
	    
	}
	
	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{
	    	Set<Integer> seen = new HashSet<Integer>();
	        for(int i = start; i < nums.length; i++){
//	            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	        	if(!seen.contains(nums[i])) {
	        		seen.add(nums[i]);
	        		tempList.add(nums[i]);
		            backtrack(list, tempList, nums, remain - nums[i], i + 1);
		            tempList.remove(tempList.size() - 1);
	        	}
	        }
	    }
	} 
	
	public static void main(String[] args) {
		int[] nums = {10,1,2,7,6,1,5};
		List<List<Integer>> subSets = combinationSum_II(nums, 8);
		for(List<Integer> set : subSets) {
			System.out.print("{ ");
			for(int i : set) {
				System.out.print(i + ",");
			}
			System.out.print(" }");
			System.out.println();
		}
	}
	
	
	// My leetcode submission
	public static List<List<Integer>> combinationSum_II(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        find(candidates, 0, new ArrayList<Integer>(), target, res);
        return res;
    }
    
    public static void find(int[] candidates, int idx, List<Integer> currentSum, int target, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(currentSum));
            return;
        }
        
        if(target < 0)
            return;
        
        for(int i = idx; i < candidates.length; ++i) {
            if(i == idx || candidates[i-1] != candidates[i]) {
                currentSum.add(candidates[i]);
                
                System.out.println("idx = " + idx + " , " + "i = " + i + " currentSum = " + print(currentSum));
                find(candidates, i+1, currentSum, target-candidates[i], res);
                currentSum.remove(currentSum.size()-1);    
            }
        }
    }
    
    private static String print(List<Integer> list) {
		StringBuilder res = new StringBuilder();
		res.append("{ ");
		for(int val : list) {
			res.append(val + " ");
		}
		res.append("}");
		return res.toString();
	}
    
}

