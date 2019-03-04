package pc.ds.arrays.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	/**
	 * Given a sorted integer array without duplicates, return the summary of
	 * its ranges.
	 * 
	 * Example 1:
	 * 
	 * Input: [0,1,2,4,5,7] Output: ["0->2","4->5","7"] Explanation: 0,1,2 form
	 * a continuous range; 4,5 form a continuous range. Example 2:
	 * 
	 * Input: [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"] Explanation: 2,3,4
	 * form a continuous range; 8,9 form a continuous range.
	 **/
	
	// https://leetcode.com/problems/summary-ranges/discuss/63386/My-concise-Java-solution
	public List<String> summaryRanges(int[] nums) {
		int length = nums.length;
		List<String> result = new ArrayList<String>(length);
		for (int i = 0; i < length; i++) {
			int num = nums[i];
			while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
				i++;
			}
			if (num != nums[i]) {
				result.add(num + "->" + nums[i]);
			} else {
				result.add(num + "");
			}
		}
		return result;
	}
}
