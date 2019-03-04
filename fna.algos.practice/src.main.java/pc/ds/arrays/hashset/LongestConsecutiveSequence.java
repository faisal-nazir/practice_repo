package pc.ds.arrays.hashset;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	/***
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence. For example, given [100, 4, 200, 1, 3, 2],
	 * the longest consecutive elements sequence should be [1, 2, 3, 4]. Its
	 * length is 4. Your algorithm should run in O(n) complexity.
	 */

	// https://leetcode.com/articles/longest-consecutive-sequence/
	public static int longestConsecutive(int[] nums) {
		Set<Integer> num_set = new HashSet<Integer>();
		for (int num : nums) {
			num_set.add(num);
		}

		int longestStreak = 0;

		for (int num : num_set) {
			if (!num_set.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;

				while (num_set.contains(currentNum + 1)) {
					currentNum += 1;
					currentStreak += 1;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}

		return longestStreak;
	}
}
