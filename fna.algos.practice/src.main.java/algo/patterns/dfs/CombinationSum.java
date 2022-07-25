package algo.patterns.dfs;

import java.util.*;

public class CombinationSum {

	static String indent = "";

	public static List<List<Integer>> getCombinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(candidates == null || candidates.length == 0) return res;
		Arrays.sort(candidates);
		//solve(candidates, 0, 0, new ArrayList<Integer>(), res, target);
		solve2(candidates, 0, target, new LinkedList<Integer>(), res);
		return res;
	}

	public static void solve(int[] candidates, int idx, int sum, List<Integer> list, List<List<Integer>> res,
	 int target) {
		if(sum > target) return;

		if(sum == target) {
			res.add(new ArrayList<>(list));
			return;
		}

		enter(idx, sum);

		for(int i = idx; i < candidates.length; ++i) {
			int n = candidates[i];
			sum += n;
			list.add(n);
			solve(candidates, i, sum, list, res, target);
			sum -= n;
			list.remove(list.size()-1);
		}

		leave(idx, sum);
	}

	public static void solve2(int[] candidates, int idx, int remain, LinkedList<Integer> list, 
								List<List<Integer>> res) {
		
		if(remain == 0) {
			res.add(new ArrayList<>(list));
			return;
		}

		if(remain < 0) return;

		for(int i = idx; i < candidates.length; ++i) {
			list.add(candidates[i]);
			solve2(candidates, i, remain - candidates[i], list, res);
			list.removeLast();
		}
	}

	public static void main(String[] args) {
		int[] A = {2, 3, 5};
		int target = 8;
		List<List<Integer>> res = getCombinationSum(A, target);

		for(List<Integer> list : res) {
			for(int n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

	public static void enter(int idx, int sum) {
		System.out.println(indent + "Entering foo(" + idx + "," + sum + ")");
		indent = indent + "|  ";
	}
	
	public static void leave(int idx, int sum) {
		indent = indent.substring(3);
		System.out.println(indent + "Leaving foo(" + idx + "," + sum + ")");
	}
}