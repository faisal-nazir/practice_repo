package com.b2bSWE.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Given a collection of integers that might contain duplicates, nums, 
 * return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
**/

public class SubSets_II {

	public static List<List<Integer>> getSubsets(int[] nums) {
		List<List<Integer>> subSets = new ArrayList<List<Integer>>();
		List<Integer> setSoFar = new ArrayList<Integer>();
		int idx = 0;
		Arrays.sort(nums);
		Set<Integer> seen = new HashSet<Integer>();  
		helper(subSets, nums, setSoFar, idx);
		return subSets;
	}

	public static void helper(List<List<Integer>> subSets, int[] nums,
			List<Integer> currSet, int start) {
		if (start == nums.length) {
			subSets.add(new ArrayList<Integer>(currSet));
			return;
		}
		Set<Integer> seen = new HashSet<Integer>();
		for(int i = 0; i < nums.length; ++i) {
			if(!seen.contains(nums[start])) {
				seen.add(nums[start]);
				currSet.add(nums[start]); // make a choice
				helper(subSets, nums, currSet, start + 1); // recurse on this choice
				currSet.remove(currSet.size() - 1); // un-choose
				helper(subSets, nums, currSet, start + 1); // recurse
			}
		}
		
		
	}
	
	public static  List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<Integer>(), nums, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    Set<Integer> seen = new HashSet<Integer>();
	    
	    for(int i = start; i < nums.length; i++){
	    	if(!seen.contains(nums[i])) {
	    		seen.add(nums[i]);
		        tempList.add(nums[i]);
		        backtrack(list, tempList, nums, i + 1);
		        tempList.remove(tempList.size() - 1);
	    	}
	    }
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		List<List<Integer>> subSets = subsets(nums);
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
