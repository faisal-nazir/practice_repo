package temp;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Permutation {
	public static List<List<Integer>> getPermutations(List<Integer> nums) {
		List<List<Integer>> res = new ArrayList<>();
		solve(nums, 0, res);
		return res;
	}

	private static void solve(List<Integer> nums, int start, List<List<Integer>> permutations) {
		if(start == nums.size()-1) {
			permutations.add(new ArrayList<Integer>(nums));
			return;
		}
		for(int i = start; i < nums.size(); ++i) {
			Collections.swap(nums, i, start);
			System.out.println("idx = " + start + " , " + "i = " + i + " permutation = " + getString(nums));
			solve(nums, start+1, permutations);
			Collections.swap(nums, i, start);
		}
	}

	public static void main(String[] args) {
		Integer[] nums = new Integer[] {7, 5, 3};
		getPermutations(Arrays.asList(nums));
		//print(permutations);
	}

	private static void print(List<List<Integer>> permutations) {
		for(List<Integer> P : permutations) {
			System.out.print("{ ");
			for(int i : P) {
				System.out.print(i + " , ");
			}
			System.out.print(" }");
			System.out.println();
		}
	}
	
	private static String getString(List<Integer> subSet) {
		StringBuilder res = new StringBuilder();
		res.append("{ ");
		for(int val : subSet) {
			res.append(val + " ");
		}
		res.append("}");
		return res.toString();
	}
		
}