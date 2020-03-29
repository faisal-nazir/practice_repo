package pc.ds.arrays.twoPointers;

import java.util.*;


public class ThreeSum {
	/**
	 * Given an array nums of n integers, are there elements a, b, c in nums
	 * such that a + b + c = 0? Find all unique triplets in the array which
	 * gives the sum of zero.
	 * 
	 * Note:
	 * 
	 * The solution set must not contain duplicate triplets.
	 * 
	 * Example:
	 * 
	 * Given array nums = [-1, 0, 1, 2, -1, -4],
	 * 
	 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
	 **/

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i + 2 < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
				continue;
			}
			int j = i + 1, k = nums.length - 1;
			int target = -nums[i];
			while (j < k) {
				if (nums[j] + nums[k] == target) {
					res.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1])
						j++; // skip same result
					while (j < k && nums[k] == nums[k + 1])
						k--; // skip same result
				} else if (nums[j] + nums[k] > target) {
					k--;
				} else {
					j++;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, -4, -4};
		List<List<Integer>> triplets = threeSum(nums);
		
		print(triplets);
	}
	
	private static void print(List<List<Integer>> triplets) {
		for(List<Integer> t : triplets) {
			Iterator<Integer> itr = t.iterator();
			while(itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println();
		}
	}

	// https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
	public List<List<Integer>> threeSumConcise(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;
	}
}
