package pc.ds.arrays.caching;

public class IncreasingTripletSubsequence {

	/**
	 * Given an unsorted array return whether an increasing subsequence of
	 * length 3 exists or not in the array.
	 * 
	 * Formally the function should:
	 * 
	 * Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k]
	 * given 0 <= i < j < k <= n-1 else return false. Note: Your algorithm
	 * should run in O(n) time complexity and O(1) space complexity.
	 * 
	 * Example 1:
	 * 
	 * Input: [1,2,3,4,5] Output: true Example 2:
	 * 
	 * Input: [5,4,3,2,1] Output: false
	 **/

	public boolean increasingTriplet(int[] nums) {
		int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= min)
				min = num;
			else if (num < secondMin)
				secondMin = num;
			else if (num > secondMin)
				return true;
		}
		return false;
	}
	
	// https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/
	public boolean increasingTripletSubsequence(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        int k = Integer.MAX_VALUE;
        
        for(int itr = 0; itr < nums.length; ++itr) {
            int val = nums[itr];
            if(val <= i) {
                i = val;
            } else if( val <= j) {
                j = val;
            } else if(val <= k) {
                k = val;
            }
        }
        return i != Integer.MAX_VALUE && j != Integer.MAX_VALUE && k != Integer.MAX_VALUE;
    }
}
