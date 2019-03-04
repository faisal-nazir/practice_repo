package pc.ds.arrays.findingNumber;

import java.util.Arrays;

public class MissingNumber {
	/** Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
	 *  find the one that is missing from the array.

		Example 1:
		
		Input: [3,0,1]
		Output: 2
		Example 2:
		
		Input: [9,6,4,2,3,5,7,0,1]
		Output: 8
		Note:
		Your algorithm should run in linear runtime complexity. 
		Could you implement it using only constant extra space complexity?
	 **/

	public int missingNumber(int[] nums) {
		int n = nums.length;
        int expectedSum = n*(n+1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
	
	public int binarySerach(int[] nums) { //binary search
	    Arrays.sort(nums);
	    int left = 0, right = nums.length, mid= (left + right)/2;
	    while(left<right){
	        mid = (left + right)/2;
	        if(nums[mid]>mid) right = mid;
	        else left = mid+1;
	    }
	    return left;
	}
	
	// https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination
	// incase: no element is missing then this would return the length of the array
	static public int xor(int[] nums) {
		int missing = nums.length;
		for (int i = 0; i < nums.length; i++) {
			missing ^= i ^ nums[i];
		}
		return missing;
	}
	
//	For example, given an input int[] nums = [3, 0, 1] which has a length of 3. 
//	The value of an int[] with length should be : 0~2. However, because of the missing element 2, 
//	there is an extra element 3 which equals nums.length takes place 2's position.
//	Only when xor all element in nums and its index including nums.length, you can finally come up with the missing element:
//	3^0^1^0^1^2^3 = 2
	
	public static void main(String[] args) {
		int[] a = {9,6,4,2,3,5,7,0,1};
		System.out.print(xor(a));
	}
}
