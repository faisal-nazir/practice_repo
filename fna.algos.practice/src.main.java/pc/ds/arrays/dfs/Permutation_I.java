package pc.ds.arrays.dfs;

import java.util.ArrayList;
import java.util.List;

/** Given a collection of distinct integers, return all possible permutations.

	Example:
	
	Input: [1,2,3]
	Output:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
**/
public class Permutation_I {
	// https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> perm = new ArrayList<Integer>();
		helper(nums, perm, res);
		return res;
	}
	
	private static void helper(int[] nums, List<Integer> perm, List<List<Integer>> res) {
		if(perm.size() == nums.length) {
			res.add(new ArrayList<Integer>(perm));
		} else {
			for(int i = 0; i < nums.length; ++i) {
				if(perm.contains(nums[i])) continue; // skip already picked elements
				perm.add(nums[i]);
				helper(nums, perm, res);
				perm.remove(perm.size() - 1);
			}
		}
	}
	
//	public static void main(String[] args) {
//		int[] nums = {1, 2, 3};
//		List<List<Integer>> res = permute(nums);
//		print(res);
//	}
	
	private static void print(List<List<Integer>> lists) {
		for(List<Integer> list : lists) {
			for(Integer i : list) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	
	static class LaiqSubmission {
		// From Laiq's submission
		public static List<List<Integer>> permute(int[] num) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if(num.length == 0) return result;
	        
	        permute(num, 0, result);
	        
	        return result;
	        
	    }
	    
	    private static void swap(int[] num, int i, int j) {
	        int t = num[i];
	        num[i] = num[j];
	        num[j] = t;
	    }
	    
	    public static void permute(int[] num, int k, List<List<Integer>> perm) {
	        if(k == num.length) {
	            
	            ArrayList<Integer> p = new ArrayList<Integer>();
	            for(int i=0; i<num.length; ++i)
	                p.add(num[i]);
	            
	            perm.add(p);
	            
	            return;
	        }
	        
	        for(int i=k; i<num.length; ++i) {
	        	System.out.println("h(" + i + " , " + k + ")");
	            swap(num, i, k);        
	            permute(num, k + 1, perm);
	            swap(num, i, k);
	        }
	    }
	    
	    public static void main(String[] args) {
			int[] nums = {1, 2, 3};
			List<List<Integer>> res = permute(nums);
			//print(res);
		}
	}
	
}
