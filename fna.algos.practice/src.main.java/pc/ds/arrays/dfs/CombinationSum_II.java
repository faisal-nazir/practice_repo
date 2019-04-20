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
		int[] nums = {2,5,2,1,2};
		List<List<Integer>> subSets = combinationSum2(nums, 5);
		for(List<Integer> set : subSets) {
			System.out.print("{ ");
			for(int i : set) {
				System.out.print(i + ",");
			}
			System.out.print(" }");
			System.out.println();
		}
	}
}

