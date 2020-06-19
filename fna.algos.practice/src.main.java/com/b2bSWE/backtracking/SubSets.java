package com.b2bSWE.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Given a set of distinct integers, nums, return all possible subsets (the power set).

	Note: The solution set must not contain duplicate subsets.
	
	Example:
	
	Input: nums = [1,2,3]
	Output:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
**/

public class SubSets {

	public static List<List<Integer>> getSubsets(int[] nums) {
		List<List<Integer>> subSets = new ArrayList<List<Integer>>();
		List<Integer> setSoFar = new ArrayList<Integer>();
		int idx = 0;
		helper(subSets, nums, setSoFar, idx);
		return subSets;
	}

	public static void helper(List<List<Integer>> subSets, int[] nums, List<Integer> currSet, int start) {
		if(start == nums.length) {
			subSets.add(new ArrayList<Integer>(currSet));
			return;
		}
		currSet.add(nums[start]); // make a choice
		helper(subSets, nums, currSet, start+1); // recurse on this choice
		currSet.remove(currSet.size()-1); // un-choose
		helper(subSets, nums, currSet, start+1); // recurse
	}
	
	public static  List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<Integer>(), nums, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> res , List<Integer> subSet, int [] nums, int idx){
	    res.add(new ArrayList<>(subSet));
	    for(int i = idx; i < nums.length; i++){
	        subSet.add(nums[i]);
	        System.out.println("idx = " + idx + " , " + "i = " + i + " subset = " + print(subSet));
	        backtrack(res, subSet, nums, idx+1);
	        subSet.remove(subSet.size() - 1);
	    }
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		subsets(nums);
	}
	
	private static String print(List<Integer> subSet) {
		StringBuilder res = new StringBuilder();
		res.append("{ ");
		for(int val : subSet) {
			res.append(val + " ");
		}
		res.append("}");
		return res.toString();
	}
}
