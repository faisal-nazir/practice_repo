package fna.algos.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snippet {
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<Integer>(), nums, 0);
	    return list;
	}
	
	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<Integer>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		Snippet s = new Snippet();
		List<List<Integer>> subSets = s.getSubset(nums);
		for(List<Integer> set : subSets) {
			System.out.print("{ ");
			for(int i : set) {
				System.out.print(i + ",");
			}
			System.out.print(" }");
			System.out.println();
		}
	}
	
	public List<List<Integer>> getSubset(int[] nums) {
		List<List<Integer>> subSets = new ArrayList<List<Integer>>();
		List<Integer> setSoFar = new ArrayList<Integer>();
		int idx = 0;
		helper(subSets, nums, setSoFar, idx);
		return subSets;
	}

	public void helper(List<List<Integer>> subSets, int[] nums, List<Integer> currSet, int start) {
		if(start == nums.length) {
			subSets.add(new ArrayList<Integer>(currSet));
			return;
		}
		currSet.add(nums[start]); // make a choice
		helper(subSets, nums, currSet, start+1); // recurse on this choice
		currSet.remove(currSet.size()-1); // un-choose
		helper(subSets, nums, currSet, start+1); // recurse
	}
}

