package pc.ds.arrays.binarySearch;

public class SearchInSortedRotatedArray_I {

	/**
	 * Suppose an array sorted in ascending order is rotated at some pivot
	 * unknown to you beforehand.
	 * 
	 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
	 * 
	 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
	 **/

	public static int search(int[] arr, int target) {
		int s = 0, e = arr.length - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] == target)
				return mid;

			if (arr[s] <= arr[mid]) {
				if (target >= arr[s] && target < arr[mid]) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			} else {
				if (target > arr[mid] && target <= arr[e]) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] input = { 6, 7, 8, 0, 1, 2, 3 };
		System.out.println(search(input, 7));
		System.out.println(search(input, 2));
		System.out.println(search(input, 4));
		System.out.println(search(input, 6));
		System.out.println(search(input, 3));
		System.out.println(search(input, -1));
	}
}
