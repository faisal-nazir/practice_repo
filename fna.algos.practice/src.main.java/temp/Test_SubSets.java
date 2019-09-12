package temp;

import java.util.List;
import java.util.ArrayList;

public class Test_SubSets {
	public static List<List<Integer>> getSubSets_01(int[] nums) {
		List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
		List<Integer> subSet = new ArrayList<Integer>();
		solve_01(nums, powerSet, subSet, 0);
		return powerSet;
	}

	private static void solve_01(int[] nums, List<List<Integer>> powerSet, List<Integer> subSet, int idx) {
		powerSet.add(new ArrayList<Integer>(subSet));
		for(int i = idx; i < nums.length; ++i) {
			System.out.println("Entering => s(idx = " + idx + " , " + "i = " + i + ")");
			subSet.add(nums[i]);
			solve_01(nums, powerSet, subSet, i+1);
			subSet.remove(subSet.size()-1);
			System.out.println("Exiting => s(idx = " + idx + " , " + "i = " + i + ")");
		}
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		print(getSubSets_01(arr));
	}

	public static void print(List<List<Integer>> lists) {
		for(List<Integer> list : lists) {
			for(Integer i : list) {
				System.out.print( i + " , ");
			}
			System.out.println();
		}
	}
	
	private static final double LOG_2 = Math.log(2);
	
	private static List<List<Integer>> getSubSets_02(int[] nums) {
		List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
		for(int i = 0; i < 1 << nums.length; ++i) {
			int bitArray = i;
			List<Integer> subSet = new ArrayList<Integer>();
			while(bitArray != 0) {
				int idx = (int)(Math.log(bitArray & ~(bitArray-1))/LOG_2);
				subSet.add(nums[idx]);
				bitArray &= bitArray-1;
			}
			powerSet.add(subSet);
		}
		return powerSet;
	}
	
	private static List<List<Integer>> getSubSets_03(int[] nums) {
		List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
		List<Integer> subSet = new ArrayList<Integer>();
		solve_03(nums, 0, subSet, powerSet);
		
		return powerSet;
	}
	
	private static void solve_03(int[] nums, int idx, List<Integer> subSet, List<List<Integer>> powerSet) {
		if(idx == nums.length) {
			powerSet.add(new ArrayList<Integer>(subSet));
			return;
		}
		subSet.add(nums[idx]);
		solve_03(nums, idx+1, subSet, powerSet);
		subSet.remove(subSet.size()-1);
		solve_03(nums, idx+1, subSet, powerSet);	
	}
}