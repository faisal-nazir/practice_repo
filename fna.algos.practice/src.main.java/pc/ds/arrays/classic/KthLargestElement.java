package pc.ds.arrays.classic;

public class KthLargestElement {

	// https://leetcode.com/problems/kth-largest-element-in-an-array/solution/
	
	public static int getKthLargestNumber(int[] input, int k) {
		if(input == null || input.length < k) return -1;
		return getKthSmallestNumber(input, input.length - k + 1, 0, input.length -1);
	}
	
	private static int getKthSmallestNumber(int[] arr, int k, int start, int end) {
		int p = quickSelect(arr, start, end);
		if(p + 1 == k)
			return arr[p];
		else if(p + 1 < k)
			return getKthSmallestNumber(arr, k , p+1, end);
		else 
			return getKthSmallestNumber(arr, k, start, p-1);
	}
	
	private static int quickSelect(int[] arr, int start, int end) {
		int pVal = arr[end];
		int p = start;
		for(int idx = start; idx < end; ++idx) {
			if(arr[idx] <= pVal) {
				swap(arr, idx, p);
				++p;
			}
		}
		swap(arr, p, end);
		return p;
	}
	
	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	public static void main(String[] args) {
		int[] data = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		System.out.print(getKthLargestNumber(data, k));
	}
}
