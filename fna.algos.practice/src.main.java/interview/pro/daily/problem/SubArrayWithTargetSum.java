package interview.pro.daily.problem;

import java.util.*;

public class SubArrayWithTargetSum {

	// [Daily Problem] Subarray With Target Sum
	private static class Pair {
		int i;
		int j;
		
		Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static Pair subArrayWithSum(int[] arr, int k) {
		if(arr == null || arr.length == 0) return new Pair(-1, -1);
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for(int i = 0; i < arr.length; ++i) {
			sum += arr[i];
			if(sum-k == 0) return new Pair(0, i);
			int key = sum-k;
			if(map.containsKey(key))
				return new Pair(map.get(key)+1, i);
			map.put(sum, i);
		}
		return new Pair(-1, -1);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 2, 5, 7, 2};
		int k = 1;
		Pair res = subArrayWithSum(arr, k);
		System.out.println(res.i + "," +res.j);
	}
	
	
}
