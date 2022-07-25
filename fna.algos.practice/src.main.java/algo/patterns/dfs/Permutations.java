package algo.patterns.dfs;

import java.util.*;

public class Permutations {
	
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        helper(0, nums, res);
        return res;
    }
    
    private static void helper(int idx, int[] nums, List<List<Integer>> res) {
        if(idx >= nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        
        for(int i = idx; i < nums.length; ++i) {
            swap(nums, i, idx);
            helper(idx+1, nums, res);
            swap(nums, i, idx);
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
    	int[] A = {1, 2, 3};
		List<List<Integer>> res = permute(A);
		for(List<Integer> list : res) {
			for(int n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}