package pc.ds.arrays.twoPointers;

public class MoveZeros {

	/**
	 * Given an array nums, write a function to move all 0's to the end of it
	 * while maintaining the relative order of the non-zero elements. For
	 * example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
	 * should be [1, 3, 12, 0, 0].
	 **/

	public static void rearrageNumbers(int[] arr) {
		if (arr == null || arr.length == 0)
			return;
		int si = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] != 0) {
				arr[si++] = arr[i];
			}
		}

		for (int i = si; i < arr.length; ++i) {
			arr[i] = 0;
		}
	}
}
