package pc.ds.arrays.binarySearch;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

	/**
	 * Given an unsorted array of integers, find the length of longest
	 * increasing subsequence.
	 * 
	 * Example:
	 * 
	 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest
	 * increasing subsequence is [2,3,7,101], therefore the length is 4. Note:
	 * 
	 * There may be more than one LIS combination, it is only necessary for you
	 * to return the length. Your algorithm should run in O(n2) complexity.
	 * Follow up: Could you improve it to O(n log n) time complexity?
	 **/

	// Intuition behind this solution:
	// If the current element is greater than the previous element,
	// we can safely add 1 to the value of previous max sum.
	// Since the previous max sum was also calculated in a similar manner
	// (optimal substructure)
	// we can safely add 1 to previous max value to get the current value.

	// https://www.youtube.com/watch?v=fV-TF4OvZpk
	public static int lengthOfLIS_01(int[] nums) {
		// Base case
		if (nums.length <= 1)
			return nums.length;

		// This will be our array to track longest sequence length
		int T[] = new int[nums.length];

		int longest = 1;

		// Fill each position with value 1 in the array
		for (int i = 0; i < nums.length; i++)
			T[i] = 1;

		// Mark one pointer at i. For each i, start from j=0.
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				// It means next number contributes to increasing sequence.
				if (nums[j] < nums[i]) {
					// But increase the value only if it results in a larger
					// value of the sequence than T[i]
					// It is possible that T[i] already has larger value from
					// some previous j'th iteration
					if (T[j] + 1 > T[i]) {
						T[i] = T[j] + 1;
					}
				}
			}

			if (longest < T[i])
				longest = T[i];
		}

		// Find the maximum length from the array that we just generated
		// int longest = 0;
		// for(int i=0; i < T.length; i++)
		// longest = Math.max(longest, T[i]);

		return longest;
	}

	// https://leetcode.com/problems/longest-increasing-subsequence/discuss/74825/Short-Java-solution-using-DP-O(n-log-n)
	// https://www.youtube.com/watch?v=1RpMc3fv0y4 (Thumbs up video)
	public static int lengthOfLIS_02(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;

		for (int x : nums) {
			int i = Arrays.binarySearch(dp, 0, len, x);
			if (i < 0)
				i = -(i + 1);
			dp[i] = x;
			if (i == len)
				len++;
		}

		return len;
	}

	// same idea as the above one
	// self explanatory though ;)
	public static int findPositionToReplace(int[] a, int low, int high, int x) {
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (a[mid] == x)
				return mid;
			else if (a[mid] > x)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

	public static int lengthOfLIS_03(int[] nums) {
		if (nums == null | nums.length == 0)
			return 0;
		int n = nums.length, len = 0;
		int[] increasingSequence = new int[n];
		increasingSequence[len++] = nums[0];
		for (int i = 1; i < n; i++) {
			if (nums[i] > increasingSequence[len - 1])
				increasingSequence[len++] = nums[i];
			else {
				int position = findPositionToReplace(increasingSequence, 0,
						len - 1, nums[i]);
				increasingSequence[position] = nums[i];
			}
		}
		return len;
	}

	public static void main(String[] args) {
		// int[] arr = {3, 1, 5, 2, 6, 4, 9 };
		int[] arr = { 10, 9, 2, 5, 3, 7, 2, 101, 7, 18 };
		System.out.print(lengthOfLIS_01(arr));
	}
}
