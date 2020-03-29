package interview.pro.daily.problem;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

	public static int longest(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int max = 0;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		for(int i = 1; i < nums.length; ++i) {
			for(int j = i-1; j >= 0; j--) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] input = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		System.out.println(longest_seq(input));
	}
	
	public static int longest_seq(int[] nums) {
		int[] temp = new int[nums.length];
		int len = 0;
		for(int i = 0; i < nums.length; ++i) {
			int idx = Arrays.binarySearch(temp, 0, len, nums[i]);
			if(idx < 0)
				idx = -(idx+1);
			temp[idx] = nums[i];
			if(idx == len) 
				++len;
		}
		return len;
	}
}
