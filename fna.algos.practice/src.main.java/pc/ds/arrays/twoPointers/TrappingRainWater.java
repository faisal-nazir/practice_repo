package pc.ds.arrays.twoPointers;

import java.util.Stack;

public class TrappingRainWater {

	/***
	 * https://leetcode.com/problems/trapping-rain-water/description/ 
	 * Given 'n' non-negative integers representing an elevation map where the width of
	 * each bar is 1, compute how much water it is able to trap after raining.
	 * The above elevation map is represented by array
	 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
	 * section) are being trapped. Thanks Marcos for contributing this image!
	 * 
	 * Example: Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
	 */

	// https://leetcode.com/articles/trapping-rain-water/
	// O(n2) time, 0(1) space
	public static int trap(int[] height) {
		int ans = 0;
		int size = height.length;
		for (int i = 1; i < size - 1; i++) {
			int max_left = 0, max_right = 0;
			for (int j = i; j >= 0; j--) { // Search the left part for max bar
											// size
				max_left = Math.max(max_left, height[j]);
			}
			for (int j = i; j < size; j++) { // Search the right part for max
												// bar size
				max_right = Math.max(max_right, height[j]);
			}
			ans += Math.min(max_left, max_right) - height[i];
		}
		return ans;
	}

	// O(n) time, O(n) space
	public static int trap_02(int[] height) {
		if (height == null)
			return 0;
		int ans = 0;
		int size = height.length;
		int[] left_max = new int[size], right_max = new int[size];
		left_max[0] = height[0];
		for (int i = 1; i < size; i++) {
			left_max[i] = Math.max(height[i], left_max[i - 1]);
		}
		right_max[size - 1] = height[size - 1];
		for (int i = size - 2; i >= 0; i--) {
			right_max[i] = Math.max(height[i], right_max[i + 1]);
		}
		for (int i = 1; i < size - 1; i++) { // using the fact then first and
												// last bar can not trap any
												// water
			ans += Math.max(left_max[i], right_max[i]) - height[i];
		}
		return ans;
	}

	// 
	public static int trap_03(int[] height) {
		int ans = 0, current = 0;
		Stack<Integer> stack = new Stack<>();
		while (current < height.length) {
			while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
				int top = stack.peek();
				stack.pop();
				if (stack.isEmpty())
					break;
				int distance = current - stack.peek() - 1;
				int bounded_height = Math.min(height[current],
						height[stack.peek()])
						- height[top];
				ans += distance * bounded_height;
			}
			stack.push(current++);
		}
		return ans;
	}

	public static int trap_04(int[] height) {
		int left = 0, right = height.length - 1;
		int ans = 0;
		int left_max = 0, right_max = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= left_max)
					left_max = height[left];
				else
					ans += left_max - height[left];
				++left;
			} else {
				if (height[right] >= right_max)
					right_max = height[right];
				else
					ans += right_max - height[right];
				--right;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.print(trap_04(a));
	}
}
