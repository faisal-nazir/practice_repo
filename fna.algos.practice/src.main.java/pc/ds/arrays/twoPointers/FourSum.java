package pc.ds.arrays.twoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {

	/**
	 * Given an array nums of n integers and an integer target, are there
	 * elements a, b, c, and d in nums such that a + b + c + d = target? Find
	 * all unique quadruplets in the array which gives the sum of target.
	 * 
	 * Note:
	 * 
	 * The solution set must not contain duplicate quadruplets.
	 * 
	 * Example:
	 * 
	 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
	 * 
	 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
	 **/

	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 3; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				for (int j = i + 1; j < num.length - 2; j++) {
					if (j == i + 1 || (j > i + 1 && num[j] != num[j - 1])) {
						int lo = j + 1, hi = num.length - 1;
						while (lo < hi) {
							if (num[i] + num[j] + num[lo] + num[hi] == target) {
								res.add(Arrays.asList(num[i], num[j], num[lo],
										num[hi]));
								while (lo < hi && num[lo] == num[lo + 1])
									lo++;
								while (lo < hi && num[hi] == num[hi - 1])
									hi--;
								lo++;
								hi--;
							} else if (num[i] + num[j] + num[lo] + num[hi] < target)
								lo++;
							else
								hi--;
						}
					}
				}
			}

		}

		return res;
	}

	public static void main(String[] args) {
		FourSum s = new FourSum();
		int[] input = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> res = s.fourSum(input, 0);

		for (List<Integer> list : res) {
			System.out.print("{ ");
			for (int i : list) {
				System.out.print(i + ",");
			}
			System.out.print(" }");
			System.out.println();
		}

	}
}
