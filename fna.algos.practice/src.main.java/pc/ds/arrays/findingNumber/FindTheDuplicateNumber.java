package pc.ds.arrays.findingNumber;

public class FindTheDuplicateNumber {

	/**
	 * Given an array nums containing n + 1 integers where each integer is
	 * between 1 and n (inclusive), prove that at least one duplicate number
	 * must exist. Assume that there is only one duplicate number, find the
	 * duplicate one.
	 * 
	 * Example 1:
	 * 
	 * Input: [1,3,4,2,2] Output: 2 Example 2:
	 * 
	 * Input: [3,1,3,4,2] Output: 3 Note:
	 * 
	 * You must not modify the array (assume the array is read only). You must
	 * use only constant, O(1) extra space. Your runtime complexity should be
	 * less than O(n2). There is only one duplicate number in the array, but it
	 * could be repeated more than once.
	 **/

	/**
	 * This method assumes the range of integers from 0 to n-1. modified the
	 * original array which is not allowed for this problem
	 */
	public static int findDuplicates_01(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			if (Math.abs(a[i]) < a.length) {
				if (a[Math.abs(a[i])] < 0) {
					return Math.abs(a[i]);
				} else
					a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			}
		}
		return Integer.MIN_VALUE;
	}

	/**
	 * This method assumes the range of integers from 0 to n-1. modifies the
	 * original array which is not allowed for this problem
	 */
	public static int findDuplicates_02(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			int index = a[i] % a.length;
			a[index] = a[index] + a.length;
		}
		for (int i = 0; i < a.length; ++i) {
			if (a[i] / a.length > 1) {
				return i;
			}
		}
		return Integer.MIN_VALUE;
	}

	// https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
	public static int findDuplicate_03(int[] nums) {
		if (nums.length > 1) {
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0;
			while (fast != slow) {
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
		}
		return -1;
	}

	// https://leetcode.com/problems/find-the-duplicate-number/discuss/72844/Two-Solutions-(with-explanation)%3A-O(nlog(n))-and-O(n)-time-O(1)-space-without-changing-the-input-array
	// https://en.wikipedia.org/wiki/Pigeonhole_principle) this principle helps
	// understand the solution
	// O(NlogN)
	public int findDuplicate(int[] nums) {
		int l = 1, r = nums.length - 1;
		while (l < r) {
			int m = (l + r) / 2;
			int c = 0;

			for (int i : nums) {
				if (i <= m) {
					c++;
				}
			}

			// if c < m,
			if (c > m) {
				r = m;
			} else {
				l = m + 1;
			}
		}

		return r;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 2, 2 };
		System.out.print(findDuplicates_02(arr));
	}

}
