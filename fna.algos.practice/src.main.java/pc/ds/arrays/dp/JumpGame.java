package pc.ds.arrays.dp;

public class JumpGame {

	// https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/807/
	// my submission on leetcode
	public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        boolean[] A = new boolean[nums.length];
        A[0] = true;
        
        for(int i = 0; i < nums.length-1 && A[i] ; ++i) {
            int jump = nums[i];
            int j = i+1;
            while(jump > 0 && j < A.length) {
                A[j] = true;
                ++j;
                --jump;
                if(A[nums.length-1])
                    return true;
            }
        }
        return  A[nums.length-1];
    }
	
	// Nick White
	// Moving backwards
	public static boolean canJump_02(int A[]) {
	    int lastGoodIndex = A.length;
	    for(int i = A.length-1; i >=0; --i) {
	    	if(i + A[i] >= lastGoodIndex) {
	    		lastGoodIndex = i;
	    	}
	    }
	    return lastGoodIndex == 0;
	}
	
	// super simple
	public static boolean canJump_03(int A[]) {
		int reached = 0;
		for(int i = 0; i < A.length; ++i) {
			if(i < reached) return false;
				
			reached = Math.max(reached, i + A[i]);
		}
		
		return true;
	}
}
