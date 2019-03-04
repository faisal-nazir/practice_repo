package pc.ds.arrays.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

	/**
	 * You are given an integer array nums and you have to return a new counts
	 * array. The counts array has the property where counts[i] is the number of
	 * smaller elements to the right of nums[i].
	 * 
	 * Example:
	 * 
	 * Input: [5,2,6,1] Output: [2,1,1,0] Explanation: To the right of 5 there
	 * are 2 smaller elements (2 and 1). To the right of 2 there is only 1
	 * smaller element (1). To the right of 6 there is 1 smaller element (1). To
	 * the right of 1 there is 0 smaller element.
	 **/

	// same idea as Longest increasing sub-sequence
	// maintain sorted array to get how many numbers are smaller than the
	// current item
	// but it doesn't improve the time complexity when compared to O(n2)
	// solution.
	// https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76576/My-simple-AC-Java-Binary-Search-code
	public static int[] count(int[] nums) {
		int[] res = new int[nums.length];
		List<Integer> sorted = new ArrayList<>();

		for (int i = nums.length - 1; i >= 0; --i) {
			int j = Collections.binarySearch(sorted, nums[i]);
			if (j < 0)
				j = -(j + 1);
			sorted.add(j, nums[i]);
			res[i] = j;
		}
		return res;
	}
	// INCORRECT SOLUTION, COZ THIS WILL OVER WRITE 6 WITH 2 AND THE RESULT FOR '7' WOULD BE 1 INSTEAD OF 2.
	public static int[] count_02(int[] nums) {
		int[] res = new int[nums.length];
		int[] sorted = new int[nums.length];
		int len = 0;

		for (int i = nums.length - 1; i >= 0; --i) {
			int j = Arrays.binarySearch(sorted, 0, len, nums[i]);
			if (j < 0)
				j = -(j + 1);
			sorted[j] = nums[i];
			res[i] = j;
			if(j == len) len++;
		}
		return res;
	}

	// optimal solution would be to use balanced binary search tree (AVL, Red
	// Black) to keep track of how may elements are
	// on the left side (i.e. smaller) for the current node.

	public static void main(String[] args) {
		int[] arr = { 5, 7, 2, 6, 1 };
		int[] c = count_02(arr);
		for (int x : c) {
			System.out.print(x + ",");
		}
	}
}
