package pc.ds.arrays.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Given a collection of numbers that might contain duplicates, return all possible unique permutations.

	Example:
	
	Input: [1,1,2]
	Output:
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]
**/
public class Permutation_II {
	// https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
	
	// From Laiq's Submission
	public static List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length == 0)
			return result;

		permute(num, 0, result);
		return result;
	}

	private static void swap(int[] num, int i, int j) {
		int t = num[i];
		num[i] = num[j];
		num[j] = t;
	}

	public static void permute(int[] num, int k, List<List<Integer>> perm) {
		if (k == num.length) {

			ArrayList<Integer> p = new ArrayList<Integer>();
			for (int i = 0; i < num.length; ++i)
				p.add(num[i]);

			perm.add(p);

			return;
		}

		//Set<Integer> set = new HashSet<Integer>();
		for (int i = k; i < num.length; ++i) {
			//if (!set.contains(num[i])) {
				//System.out.println("h(" + i + " , " + k + ")");
				//set.add(num[i]);
				if(i+1 < num.length && num[i] == num[i+1]) continue;
				swap(num, i, k);
				permute(num, k + 1, perm);
				swap(num, i, k);
			//}

		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		List<List<Integer>> res = permuteUnique(nums);
		print(res);
	}

	private static void print(List<List<Integer>> lists) {
		for (List<Integer> list : lists) {
			for (Integer i : list) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
