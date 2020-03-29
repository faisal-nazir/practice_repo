package temp;

public class Sorting {

	public static int[] bubbleSort(int[] nums) {
		if(nums == null || nums.length <= 1) return nums;
		for(int i = 0; i < nums.length-1; ++i) {
			for(int j = 1; j < nums.length-i; ++j) {
				if(nums[j-1] > nums[j])
					swap(nums, j, j-1);
			}
		}
		return nums;
	}
	
	public static int[] selectionSort(int[] nums) {
		if(nums == null || nums.length <= 1) return nums;
		for(int i = 0; i < nums.length-1; ++i) {
			for(int j = i; j < nums.length; ++j) {
				if(nums[j] < nums[i])
					swap(nums, i, j);
					
			}
		}
		return nums;
	}
	
	public static int[] insertionSort(int[] nums) {
		if(nums == null || nums.length <= 1) return nums;
		for(int i = 1; i < nums.length; ++i) {
			int key = nums[i];
			int j = i-1;
			while(j >=0 && key < nums[j]) {
				nums[j+1] = nums[j];
				--j;
			}
			nums[j+1] = key;
		}
		return nums;
	}
	
	public static void swap(int[] A, int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] { 4, 5, 7, 9, 3, 2, 6, 1, 8};
		print(bubbleSort(A));
		print(selectionSort(A));
		print(insertionSort(A));
	}
	
	private static void print(int[] A) {
		for(int val : A) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
