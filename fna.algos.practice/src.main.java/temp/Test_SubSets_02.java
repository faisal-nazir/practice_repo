package temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test_SubSets_02 {
	private static List<List<Integer>> getSubSets(int[] nums) {
		List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
		List<Integer> subSet = new ArrayList<Integer>();
		Arrays.sort(nums);
		solve(nums, 0, subSet, powerSet);
		return powerSet;
		
	}
	
	private static void solve(int[] nums, int idx, List<Integer> subSet, List<List<Integer>> powerSet) {
		powerSet.add(new ArrayList<Integer>(subSet));
		Set<Integer> set = new HashSet<Integer>();
		for(int i = idx; i < nums.length; ++i) {
			if(i == idx || nums[i-1] != nums[i]) {
			//if(!set.contains(nums[i])) {
				//set.add(nums[i]);
				subSet.add(nums[i]);
				solve(nums, i+1, subSet, powerSet);
				subSet.remove(subSet.size()-1);
			}
			//}	
		}
	}
	
	private static void solve_02(int[] nums, int idx, List<Integer> soFar, List<List<Integer>> powerSet) {
		System.out.println("( " + idx + " )");
		if(idx == nums.length) {
			powerSet.add(new ArrayList<>(soFar));
			return;
		}
		
		//if(idx > 0 && nums[idx-1] == nums[idx]) return;
		Set<Integer> seen = new HashSet<>();
		if(!seen.contains(nums[idx])) {
			seen.add(nums[idx]);
			soFar.add(nums[idx]);
			solve_02(nums, idx + 1, soFar, powerSet);
			soFar.remove(soFar.size()-1);
			solve_02(nums, idx + 1, soFar, powerSet);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 2};
		print(getSubSets(arr));
	}
	
	public static void print(List<List<Integer>> lists) {
		for(List<Integer> list : lists) {
			for(Integer i : list) {
				System.out.print( i + " , ");
			}
			System.out.println();
		}
	}
}
