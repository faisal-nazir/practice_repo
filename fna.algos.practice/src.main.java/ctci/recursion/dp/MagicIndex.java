package ctci.recursion.dp;

public class MagicIndex {

	/**
	 * 	Magic Index: A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[ i]
		i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
		array A.
		
		FOLLOW UP
		What if the values are not distinct?
	 */
	public static int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}
	
	public static int magicFast(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid){
			return magicFast(array, start, mid - 1);
		} else {
			return magicFast(array, mid + 1, end);
		}
	}
	
	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}
	
	// solution to the follow up part of the question.
	public static int magicFastWithDuplicates(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFast(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}
		
		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFast(array, rightIndex, end);
		
		return right;
	}
	
	public static int magicFastWithDuplicates(int[] array) {
		return magicFastWithDuplicates(array, 0, array.length - 1);
	}

	
}
