package pc.ds.arrays.hashMap;

import java.util.HashMap;
import java.util.HashSet;

public class LineReflection {

	/**
	 * Given n points on a 2D plane, find if there is such a line parallel to
	 * y-axis that reflects the given points.
	 * 
	 * Example 1: Given points = [[1,1],[-1,1]], return true. Example 2: Given
	 * points = [[1,1],[-1,-1]], return false.
	 * 
	 * Follow up: Could you do better than O(n2)?
	 **/

	// https://www.programcreek.com/2014/08/leetcode-line-reflection-java/
	public static boolean isReflected(int[][] points) {
		if (points == null || points.length < 2)
			return true;

		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int[] arr : points) {
			min = Math.min(min, arr[0]);
			max = Math.max(max, arr[0]);
			HashSet<Integer> set = map.get(arr[0]);
			if (set == null) {
				set = new HashSet<Integer>();
				map.put(arr[0], set);
			}

			set.add(arr[1]);

		}

		int y = min + max;

		for (int[] arr : points) {
			int left = arr[0];
			int right = y - left;
			if (map.get(right) == null || !map.get(right).contains(arr[1])) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// int[][] p = { {1,1}, {-1,1}};
		int[][] p = { { -4, 1 }, { -2, 6 }, { 4, 1 }, { 2, 6 } };
		System.out.print(isReflected(p));
	}

	// http://massivealgorithms.blogspot.com/2016/06/leetcode-line-reflection-grandyang.html
	public boolean isReflected_02(int[][] points) {
		int max, min, sum;
		HashSet<Point> set = new HashSet<>();
		if (points.length == 0)
			return true;
		max = points[0][0];
		min = max;
		for (int[] point : points) {
			int x = point[0];
			if (x > max)
				max = x;
			if (x < min)
				min = x;
			set.add(new Point(point[0], point[1]));
		}
		sum = (max + min);
		for (int[] point : points) {
			Point ref = new Point(sum - point[0], point[1]);
			if (set.contains(ref))
				set.remove(ref);
		}
		return set.isEmpty();

	}

	private class Point {
		int x;
		int y;

		Point(int xx, int yy) {
			x = xx;
			y = yy;
		}

		@Override
		public boolean equals(Object obj) {
			Point p = (Point) obj;
			return (this.x == p.x && this.y == p.y);
		}

		@Override
		public int hashCode() {
			return x * 31 + y * 17;
		}
	}
}
