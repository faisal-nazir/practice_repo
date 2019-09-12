package pc.ds.arrays.others;

public class NonDecreasingArray {

	
	// https://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC%2B%2B-Simple-greedy-like-solution-with-explanation
	public static boolean isNonDecresingWithSingleModification(int[] nums) {
		int count = 0;
		for(int i = 1; i < nums.length; ++i) {
			if(nums[i-1] > nums[i]) {
				++count;
				if(i-2 >= 0 && nums[i-2] > nums[i]) {
					nums[i] = nums[i-1];
				} else {
					nums[i-1] = nums[i];
				}
			}
			if(count > 1) return false;
		}
		return true;
	}
}
