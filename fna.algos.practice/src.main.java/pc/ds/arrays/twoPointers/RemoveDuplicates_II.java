package pc.ds.arrays.twoPointers;

public class RemoveDuplicates_II {

	int removeDuplicates(int A[], int n, int k) {

		if (n <= k)
			return n;

		int i = 1, j = 1;
		int count = 1;
		while (j < n) {
			if (A[j] != A[j - 1]) {
				count = 1;
				A[i++] = A[j];
			} else {
				if (count < k) {
					A[i++] = A[j];
					count++;
				}
			}
			++j;
		}
		return i;
	}

	/**
	 * Given a sorted array nums, remove the duplicates in-place such that
	 * duplicates appeared at most twice and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this by
	 * modifying the input array in-place with O(1) extra memory.
	 * 
	 * Example 1:
	 * 
	 * Given nums = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, with the first five elements of
	 * nums being 1, 1, 2, 2 and 3 respectively.
	 * 
	 * It doesn't matter what you leave beyond the returned length. Example 2:
	 * 
	 * Given nums = [0,0,1,1,1,1,2,3,3],
	 * 
	 * Your function should return length = 7, with the first seven elements of
	 * nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
	 * 
	 * It doesn't matter what values are set beyond the returned length.
	 **/

	public static int removeDuplicates_02(int[] nums, int k) {
		if (nums == null)
			return -1;
		if (nums.length < 2)
			return nums.length;
		int si = 1;
		int count = 1;
		for (int i = si; i < nums.length; ++i) {
			if (nums[i] != nums[i - 1]) {
				nums[si++] = nums[i];
				count = 1;
			} else if (count < k) {
				nums[si++] = nums[i];
				++count;
			}
		}
		return si;
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 2, 2, 3, 3, 4, 5 };
		System.out.println(removeDuplicates_02(a, 1));
		for (int i : a)
			System.out.print(i + ",");
	}
}
