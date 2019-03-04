package pc.ds.arrays.twoPointers;

public class ContainerWithMostWater {

	/***
	 * Given n non-negative integers a1, a2, ..., an, where each represents a
	 * point at coordinate (i, ai). n vertical lines are drawn such that the two
	 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
	 * together with x-axis forms a container, such that the container contains
	 * the most water.
	 */

	// https://leetcode.com/problems/container-with-most-water/discuss/6100/Simple-and-clear-proofexplanation
	// https://leetcode.com/problems/container-with-most-water/discuss/6099/Yet-another-way-to-see-what-happens-in-the-O(n)-algorithm
	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}

		int max = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			max = Math.max(max,
					(right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return max;
	}
}
