package pc.ds.arrays.twoPointers;

import common.utils.Pair;

public class TwoSumSorted_II {

	/**
	 * Given an array of integers that is already sorted in ascending order,
	 * find two numbers such that they add up to a specific target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that
	 * they add up to the target, where index1 must be less than index2.
	 * 
	 * Note:
	 * 
	 * Your returned answers (both index1 and index2) are not zero-based. You
	 * may assume that each input would have exactly one solution and you may
	 * not use the same element twice. Example:
	 * 
	 * Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation: The
	 * sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
	 **/
	public static Pair getTwoSum(int[] arr, int sum) {
		if (arr == null || arr.length <= 0)
			return null;
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			if (arr[i] + arr[j] == sum)
				return new Pair(i, j);
			else if (arr[i] + arr[j] < sum)
				++i;
			else
				--j;
		}
		return null;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 5, 7, 8, 10 };
		int target = 15;
		Pair result = getTwoSum(arr, target);
		if (result != null)
			System.out.print(result.x + "," + result.y);
		else
			System.out.print("There is no pair whose sum matches: " + target);
	}
}
