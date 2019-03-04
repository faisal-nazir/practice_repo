package pc.ds.arrays.rotate;

import common.utils.ArrayUtil;

//https://leetcode.com/articles/rotate-array/
public class RotateArray {
	
	//	Approach #1 Brute Force
	//	Time complexity : O(n*k). All the numbers are shifted by one step(O(n)O(n)) k times(O(k)O(k)).
	//	Space complexity : O(1). No extra space is used.
	public static void rotate_01(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
	
	public static void rotate_02(int[] nums, int k) {
        int[] a = new int[nums.length];
        // re-arrange in auxiliary array.
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        // copy to the original array.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
	
	 public static void rotate_03(int[] nums, int k) {
	        k = k % nums.length;
	        int count = 0;
	        for (int start = 0; count < nums.length; start++) {
	            int current = start;
	            int prev = nums[start];
	            do {
	                int next = (current + k) % nums.length;
	                int temp = nums[next];
	                nums[next] = prev;
	                prev = temp;
	                current = next;
	                count++;
	            } while (start != current);
	        }
	    }
	
	 
	 // https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution
	 // time O(n) 
	 // space O(1)
	 public static void rotate(int[] nums, int k) {
		    k %= nums.length;
		    reverse(nums, 0, nums.length - 1);
		    reverse(nums, 0, k - 1);
		    reverse(nums, k, nums.length - 1);
		}

		public static void reverse(int[] nums, int start, int end) {
		    while (start < end) {
		        int temp = nums[start];
		        nums[start] = nums[end];
		        nums[end] = temp;
		        start++;
		        end--;
		    }
		}
	 
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		rotate(arr,3);
		ArrayUtil.print(arr);
	}
}
