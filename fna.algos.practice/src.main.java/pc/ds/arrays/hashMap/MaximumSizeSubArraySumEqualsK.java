package pc.ds.arrays.hashMap;

import java.util.HashMap;

public class MaximumSizeSubArraySumEqualsK {

	/**
	 * Given an array nums and a target value k, find the maximum length of a
	 * subarray that sums to k. If there isn't one, return 0 instead.
	 * 
	 * Note: The sum of the entire nums array is guaranteed to fit within the
	 * 32-bit signed integer range.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1, -1, 5, -2, 3], k = 3 Output: 4 Explanation: The
	 * subarray [1, -1, 5, -2] sums to 3 and is the longest. Example 2:
	 * 
	 * Input: nums = [-2, -1, 2, 1], k = 1 Output: 2 Explanation: The subarray
	 * [-1, 2] sums to 1 and is the longest. Follow Up: Can you do it in O(n)
	 * time?
	 **/

	// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77784/O(n)-super-clean-9-line-Java-solution-with-HashMap
	// comments from: glang
	// It took me more than an hour to understand how this solution worked.
	// In particular, I was confused about what the map.containsKey(sum - k) was
	// getting,
	// so for those who are also confused, here's an explanation:
	//
	// Let's say you've iterated to index 5 (randomly chosen) and your sum from
	// index 0 to 5 so far is 7, and k is 3.
	// sum - k in this case is 4.
	//
	// What map.containsKey(sum - k) returns is the index where the sum of every
	// element up to that index from index 0 is sum - k, or (7 - 3) == 4,
	// in our example. Let's say that that index returned by map.containsKey(sum
	// - k) is 2 (randomly chose one that is before index 5).
	// So knowing that at index 2 the total sum is 4, and at index 5, the total
	// sum is 7,
	// that means the elements between index 2 and index 5 incremented the total
	// sum by 3, or k!

	public static int maxSubArrayLen(int[] nums, int k) {
		int sum = 0, max = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (sum == k)
				max = i + 1;
			else if (map.containsKey(sum - k))
				max = Math.max(max, i - map.get(sum - k));
			if (!map.containsKey(sum))
				map.put(sum, i);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -1, 5, -2, 3 };
		int k = 3;
		System.out.println(maxSubArrayLen(nums, k));
	}

}
