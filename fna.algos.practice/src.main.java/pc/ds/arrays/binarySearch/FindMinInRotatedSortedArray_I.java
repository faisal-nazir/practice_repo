package pc.ds.arrays.binarySearch;

public class FindMinInRotatedSortedArray_I {

	/**
	 * Suppose an array sorted in ascending order is rotated at some pivot
	 * unknown to you beforehand.
	 * 
	 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	 * 
	 * Find the minimum element.
	 * 
	 * You may assume no duplicate exists in the array.
	 **/

	int findMin(int[] num) {
		int start = 0, end = num.length - 1;

		while (start < end) {
			if (num[start] < num[end])
				return num[start];

			int mid = (start + end) / 2;
			// In a sorted rotated array, there has to be one sorted half and another unsorted half
			// Idea is to look for the minimum element in unsorted half
			if (num[mid] >= num[start]) { // wondering why equals sign is here then go to part II of this problem.
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return num[start];
	}
}
