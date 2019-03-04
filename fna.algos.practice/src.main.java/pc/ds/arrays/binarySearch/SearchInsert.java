package pc.ds.arrays.binarySearch;

public class SearchInsert {
	/**
	 * Given a sorted array and a target value, return the index if the target
	 * is found. If not, return the index where it would be if it were inserted
	 * in order.
	 * 
	 * You may assume no duplicates in the array.
	 * 
	 * Example 1:
	 * 
	 * Input: [1,3,5,6], 5 Output: 2 Example 2:
	 * 
	 * Input: [1,3,5,6], 2 Output: 1 Example 3:
	 * 
	 * Input: [1,3,5,6], 7 Output: 4 Example 4:
	 * 
	 * Input: [1,3,5,6], 0 Output: 0
	 **/
	public static int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length <= 0)
			return -1;
		if (nums[nums.length - 1] < target)
			return nums.length;
		return searchInsert(nums, 0, nums.length - 1, target);
	}

	public static int searchInsert(int[] nums, int start, int end, int target) {
		while (start <= end) {
			int mid = (start + end) >>> 1;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return start;
	}

	public static int searchIndexPosition(int[] arr, int target) {
		if (arr == null)
			return -1;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] >= target)
				return i;
		}
		return arr.length;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 6 };
		System.out.println(searchInsert(a, 5));
		System.out.println(searchInsert(a, 2));
		System.out.println(searchInsert(a, 7));
		System.out.println(searchInsert(a, 0));
	}
}
