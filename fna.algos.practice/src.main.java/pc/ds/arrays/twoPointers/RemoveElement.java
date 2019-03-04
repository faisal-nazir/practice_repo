package pc.ds.arrays.twoPointers;

public class RemoveElement {

	/**
	 * Given an array and a value, remove all instances of that value in place
	 * and return the new length. (Note: The order of elements can be changed.
	 * It doesn't matter what you leave beyond the new length.)
	 */

	public static int remove(int[] arr, int val) {
		if (arr == null || arr.length == 0)
			return -1;
		int si = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] != val)
				arr[si++] = arr[i];
		}
		return si;
	}
}
