package pc.ds.arrays.twoPointers;

public class MinimumSizeSubarraySum {

	/**
	 * Given an array of n positive integers and a positive integer s, find the
	 * minimal length of a contiguous subarray of which the sum >= s. If there
	 * isn't one, return 0 instead.
	 * 
	 * Example:
	 * 
	 * Input: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the subarray
	 * [4,3] has the minimal length under the problem constraint. Follow up: If
	 * you have figured out the O(n) solution, try coding another solution of
	 * which the time complexity is O(n log n).
	 **/

	// https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59078/Accepted-clean-Java-O(n)-solution-(two-pointers)
	public int minSubArrayLen(int s, int[] a) {
		if (a == null || a.length == 0)
			return 0;

		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

		while (j < a.length) {
			sum += a[j++];

			while (sum >= s) {
				min = Math.min(min, j - i);
				sum -= a[i++];
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}

	// https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59103/Two-AC-solutions-in-Java-with-time-complexity-of-N-and-NLogN-with-explanation
	private int solveNLogN(int s, int[] nums) {
		int[] sums = new int[nums.length + 1];
		for (int i = 1; i < sums.length; i++)
			sums[i] = sums[i - 1] + nums[i - 1];
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < sums.length; i++) {
			int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
			if (end == sums.length)
				break;
			if (end - i < minLen)
				minLen = end - i;
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	private int binarySearch(int lo, int hi, int key, int[] sums) {
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (sums[mid] >= key) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

}
