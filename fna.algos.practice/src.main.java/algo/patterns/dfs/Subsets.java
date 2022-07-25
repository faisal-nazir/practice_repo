package algo.patterns.dfs;

import java.util.*;

public class Subsets {

	// Method 01: cascading
	public static List<List<Integer>> getSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<>());

		for(int num : nums) {
			List<List<Integer>> newSubsets = new ArrayList<>();

			for(List<Integer> set : subsets) {
				ArrayList<Integer> newSet = new ArrayList<>(set);
				newSet.add(num);
				newSubsets.add(newSet);
			}

			for(List<Integer> set : newSubsets) {
				subsets.add(set);
			}
		}

		return subsets;
	}

	// Method 02: Take it or Don't take it
	public static List<List<Integer>> getSubsets_02(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        solve(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }

	public static void solve(List<List<Integer>> res, int[] nums, List<Integer> soFar, int idx) {
        if(idx >= nums.length) {
            res.add(new ArrayList<>(soFar));
            return;
        }
        
        soFar.add(nums[idx]);
        solve(res, nums, soFar, idx+1);
        soFar.remove(soFar.size()-1);
        solve(res, nums, soFar, idx+1);
    }

    public static List<List<Integer>> getSubsets_03(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        solve2(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }
    
    public static void solve2(List<List<Integer>> res, int[] nums, List<Integer> soFar, int idx) {
        res.add(new ArrayList<>(soFar));
        
        enter(idx);
        for(int i = idx; i < nums.length; ++i) {
            soFar.add(nums[i]);
            solve2(res, nums, soFar, i+1);
            soFar.remove(soFar.size()-1);
        }
        leave(idx);
    }


	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> subsets = getSubsets_02(nums);

		for(List<Integer> list : subsets) {
			for(Integer num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	static String indent = "";

	public static void enter(int a) {
		System.out.println(indent + "Entering foo(" + a + ")");
		indent = indent + "|  ";
	}
	
	public static void leave(int a) {
		indent = indent.substring(3);
		System.out.println(indent + "Leaving foo(" + a + ")");
	}
}