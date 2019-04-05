package pc.ds.arrays.findingNumber;

/** Given an unsorted integer array, find the smallest missing positive integer.

	Example 1:
	
	Input: [1,2,0]
	Output: 3
	Example 2:
	
	Input: [3,4,-1,1]
	Output: 2
	Example 3:
	
	Input: [7,8,9,11,12]
	Output: 1
	Note:
	
	Your algorithm should run in O(n) time and uses constant extra space.
**/

public class FirstMissingPositive {

	// https://leetcode.com/problems/first-missing-positive/discuss/17071/My-short-c%2B%2B-solution-O(1)-space-and-O(n)-time
	public static int firstMissingPositive(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i)
			while (a[i] > 0 && a[i] <= n && a[a[i] - 1] != a[i])
				swap(a, i, a[i] - 1);

		for (int i = 0; i < n; ++i)
			if (a[i] != i + 1)
				return i + 1;

		return n + 1;
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void main(String[] args) {
		int[] input = {1,3,0};
		System.out.println(firstMissingPositive(input));
		input = new int[]{ -1, -2, 3,1 };
		System.out.println(firstMissingPositive(input));
		input = new int[] { 7,9,10, 11 };
		System.out.println(firstMissingPositive(input));
		input = new int[] { 3,4,-1,1 };
		System.out.println(firstMissingPositive(input));
	}
}
