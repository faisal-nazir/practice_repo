package pc.ds.arrays.caching;

public class MajorityElement_I {

	/**
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than n/2 times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 * 
	 * Example 1:
	 * 
	 * Input: [3,2,3] Output: 3 Example 2:
	 * 
	 * Input: [2,2,1,1,1,2,2] Output: 2
	 **/

	// Java Solution 3 - Linear Time Majority Vote Algorithm
	// based on Boyer-Moore Majority Vote algorithm
	// https://www.programcreek.com/2014/02/leetcode-majority-element-java/
	public int majorityElement(int[] nums) {
		int result = 0, count = 0;
		// this method is based on the fact that
		// if majority element exists, then its count should be greater than
		// rest of elements
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				result = nums[i];
				count = 1;
			} else if (result == nums[i]) {
				count++;
			} else {
				count--;
			}
		}

		return result;
	}

	// same as above
	public int majorityElement_02(int[] num) {

		int major = num[0], count = 1;
		for (int i = 1; i < num.length; i++) {
			if (count == 0) {
				count++;
				major = num[i];
			} else if (major == num[i]) {
				count++;
			} else
				count--;

		}
		return major;
	}
}
