package pc.ds.arrays.twoPointers;

public class ProductOfArrayExceptSelf {
	/***
	 * Given an array nums of n integers where n > 1, return an array output
	 * such that output[i] is equal to the product of all the elements of nums
	 * except nums[i].
	 * 
	 * Example:
	 * 
	 * Input: [1,2,3,4] Output: [24,12,8,6] Note: Please solve it without
	 * division and in O(n).
	 * 
	 * Follow up: Could you solve it with constant space complexity? (The output
	 * array does not count as extra space for the purpose of space complexity
	 * analysis.)
	 */

	// O(n) space
	// https://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/
	public int[] productExceptSelf_01(int[] nums) {
		int[] result = new int[nums.length];

		int[] t1 = new int[nums.length];
		int[] t2 = new int[nums.length];

		t1[0] = 1;
		t2[nums.length - 1] = 1;

		// scan from left to right
		for (int i = 0; i < nums.length - 1; i++) {
			t1[i + 1] = nums[i] * t1[i];
		}

		// scan from right to left
		for (int i = nums.length - 1; i > 0; i--) {
			t2[i - 1] = t2[i] * nums[i];
		}

		// multiply
		for (int i = 0; i < nums.length; i++) {
			result[i] = t1[i] * t2[i];
		}

		return result;

	}

	// same idea as above but with O(1) space
	
	public int[] productExceptSelf_02(int[] nums) {
		int[] result = new int[nums.length];

		result[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			result[i] = result[i + 1] * nums[i + 1];
		}

		int left = 1;
		for (int i = 0; i < nums.length; i++) {
			result[i] = result[i] * left;
			left = left * nums[i];
		}

		return result;
	}

	// O(1) space
	// https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space
	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		int[] res = productExceptSelf(a);
		for(int i : res) {
			System.out.println(i);
		}
	}
}
