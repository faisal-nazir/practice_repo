package interview.pro.daily.problem;

public class FindMinMax {
	
	// https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
	// [Daily Problem] Max and Min with Limited Comparisons

	private static class Pair {
		int min;
		int max;
		
		Pair(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}
	
	public static Pair findMinMax(int[] values) {
		return helper(values, 0, values.length-1);
	}
	
	private static Pair helper(int[] values, int left, int right) {
//		if(left > right) return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
		if(left == right) return new Pair(values[left], values[left]);
		int mid = (left + right) >>> 1;
		Pair left_pair = helper(values, 0, mid);
		Pair right_pair = helper(values, mid+1, right);
		
		int local_min = (left_pair.min < right_pair.min)? left_pair.min : right_pair.min;
		int local_max = (left_pair.max < right_pair.max)? right_pair.max : left_pair.max;
		
		return new Pair(local_min, local_max);
//		return new Pair(Math.min(left_pair.min, right_pair.min), Math.max(left_pair.max, right_pair.max));
	}

	public static void main(String[] args) {
		int[] nums = new int[] {5, 6, 3, 9, 2, 1, 7, 4, 1, 8, 13};
		Pair res = findMinMax(nums);
		System.out.print(res.min + " , " + res.max);
	}
}
