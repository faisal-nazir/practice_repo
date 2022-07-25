package algo.patterns.slidingwindow;

import java.util.*;

public class MaxConsecutiveOnes {
	
	public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0, right = 0, len = 0, max = Integer.MIN_VALUE;
        for(right = 0; right < nums.length; ++right) {
            if(nums[right] == 0) 
                left = right + 1;
            max = Math.max(max, right + 1 - left);
        }
        return max != Integer.MIN_VALUE ? max : 0;
    }
}