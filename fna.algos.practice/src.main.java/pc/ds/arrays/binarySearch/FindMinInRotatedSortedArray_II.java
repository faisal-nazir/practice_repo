package pc.ds.arrays.binarySearch;

public class FindMinInRotatedSortedArray_II {

	/**
	 * Suppose an array sorted in ascending order is rotated at some pivot
	 * unknown to you beforehand.
	 * 
	 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	 * 
	 * Find the minimum element.
	 * 
	 * The array may contain duplicates.
	 * 
	 * Example 1:
	 * 
	 * Input: [1,3,5] Output: 1
	 * 
	 * Example 2:
	 * 
	 * Input: [2,2,2,0,1] Output: 0 Note:
	 * 
	 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
	 * Would allow duplicates affect the run-time complexity? How and why?
	 **/

	public static int findMin(int[] num) {
		int start = 0, end = num.length - 1;

		while (start < end) {
			if (num[start] < num[end])
				return num[start];

			int mid = (start + end) / 2;

			if (num[mid] > num[start]) {
				start = mid + 1;
			} else if (num[mid] < num[start]) {
				end = mid;
			} else {
				start++;
			}
		}

		return num[start];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5 };
		System.out.print(findMin(arr));
	}

}
