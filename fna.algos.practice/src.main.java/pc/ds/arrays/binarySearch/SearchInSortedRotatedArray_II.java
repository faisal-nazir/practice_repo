package pc.ds.arrays.binarySearch;

public class SearchInSortedRotatedArray_II {

	/**
	 * Suppose an array sorted in ascending order is rotated at some pivot
	 * unknown to you beforehand.
	 * 
	 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
	 * 
	 * You are given a target value to search. If found in the array return
	 * true, otherwise return false.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [2,5,6,0,0,1,2], target = 0 Output: true Example 2:
	 * 
	 * Input: nums = [2,5,6,0,0,1,2], target = 3 Output: false Follow up:
	 * 
	 * This is a follow up problem to Search in Rotated Sorted Array, where nums
	 * may contain duplicates. Would this affect the run-time complexity? How
	 * and why?
	 **/

	// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28202/Neat-JAVA-solution-using-binary-search	
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length <= 0)
			return false;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) >>> 1;

			if (nums[mid] == target)
				return true;

			else if (nums[start] < nums[mid]) {
				if (target >= nums[start] && target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else if (nums[start] > nums[mid]) {
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			} else {
				start++;
			}
		}
		return false;
	}
}
