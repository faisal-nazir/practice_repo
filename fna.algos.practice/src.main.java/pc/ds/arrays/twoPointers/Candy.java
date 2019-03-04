package pc.ds.arrays.twoPointers;

import java.util.Arrays;

public class Candy {

	/**
	 * There are N children standing in a line. Each child is assigned a rating
	 * value.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * Each child must have at least one candy. Children with a higher rating
	 * get more candies than their neighbors. What is the minimum candies you
	 * must give?
	 * 
	 * Example 1:
	 * 
	 * Input: [1,0,2] Output: 5 Explanation: You can allocate to the first,
	 * second and third child with 2, 1, 2 candies respectively. Example 2:
	 * 
	 * Input: [1,2,2] Output: 4 Explanation: You can allocate to the first,
	 * second and third child with 1, 2, 1 candies respectively. The third child
	 * gets 1 candy because it satisfies the above two conditions.
	 * 
	 */

	// https://leetcode.com/problems/candy/discuss/42769/A-simple-solution
	public static int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int[] candies = new int[ratings.length];
		Arrays.fill(candies, 1);

		// from let to right
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			}
		}

		// from right to left
		for (int i = ratings.length - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i]) {
				candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
			}
		}

		int result = 0;
		for (int c : candies)
			result += c;
		return result;
	}

	// https://leetcode.com/problems/candy/discuss/42770/One-pass-constant-space-Java-solution
	// A single pass solution
	public int candy_02(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		int total = 1, prev = 1, countDown = 0;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] >= ratings[i - 1]) {
				if (countDown > 0) {
					total += countDown * (countDown + 1) / 2; // arithmetic
																// progression
					if (countDown >= prev) // prev will refer to peak - if peak is less than or equal to last in decreasing arithmetic progression 
						total += countDown - prev + 1; //  // update peak
					countDown = 0;
					prev = 1;
				}
				prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
				total += prev;
			} else
				countDown++;
		}
		if (countDown > 0) { // if we were descending at the end
			total += countDown * (countDown + 1) / 2;
			if (countDown >= prev)
				total += countDown - prev + 1;
		}
		return total;
	}

}
