package pc.ds.arrays.twoPointers;

import java.util.HashMap;
import common.utils.Pair;

public class TwoSum_I {

	/**
	 * Given an array of integers, return indices of the two numbers such that
	 * they add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution, and you
	 * may not use the same element twice.
	 * 
	 * Example:
	 * 
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 **/
	public static Pair twoSum(int[] input, int sum) {
		if (input == null)
			return null;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length; ++i) {
			int target = sum - input[i];
			if (map.containsKey(target))
				return new Pair(map.get(target), i);
			else
				map.put(input[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] input = { 2, 7, 3, 5 };
		Pair result = twoSum(input, 7);
		if (result != null) {
			System.out.print(result.x + "," + result.y);
		}

	}
}
