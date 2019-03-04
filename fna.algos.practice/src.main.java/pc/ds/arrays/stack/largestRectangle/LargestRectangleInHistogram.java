package pc.ds.arrays.stack.largestRectangle;

import java.util.Stack;

public class LargestRectangleInHistogram {

	/**
	 * Given n non-negative integers representing the histogram's bar height
	 * where the width of each bar is 1, find the area of largest rectangle in
	 * the histogram.
	 * 
	 * 
	 * Above is a histogram where width of each bar is 1, given height =
	 * [2,1,5,6,2,3].
	 * 
	 * 
	 * The largest rectangle is shown in the shaded area, which has area = 10
	 * unit.
	 * 
	 * For example, Given heights = [2,1,5,6,2,3], return 10.
	 **/

	public static int largestRectangleArea_01(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();

		int max = 0;
		int i = 0;

		while (i < height.length) {
			// push index to stack when the current height is larger than the
			// previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				// calculate max value when the current height is less than the
				// previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}

		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 2,1,5,6,2,3 };
		System.out.println(largestRectangleArea_03(arr));
	}

	// same idea as above (compact implementation version)
	// https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/O(n)-stack-based-JAVA-solution
	public static int largestRectangleArea_02(int[] height) {
		int len = height.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : height[i]);
			if (s.isEmpty() || h >= height[s.peek()]) {
				s.push(i);
			} else {
				int tp = s.pop();
				maxArea = Math.max(maxArea, height[tp]
						* (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return maxArea;
	}
	
	// different idea
	// https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
	public static int largestRectangleArea_03(int[] height) {
	    if (height == null || height.length == 0) {
	        return 0;
	    }
	    int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
	    int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
	    lessFromRight[height.length - 1] = height.length;
	    lessFromLeft[0] = -1;

	    for (int i = 1; i < height.length; i++) {
	        int p = i - 1;

	        while (p >= 0 && height[p] >= height[i]) {
	            p = lessFromLeft[p];
	        }
	        lessFromLeft[i] = p;
	    }

	    for (int i = height.length - 2; i >= 0; i--) {
	        int p = i + 1;

	        while (p < height.length && height[p] >= height[i]) {
	            p = lessFromRight[p];
	        }
	        lessFromRight[i] = p;
	    }

	    int maxArea = 0;
	    for (int i = 0; i < height.length; i++) {
	        maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
	    }

	    return maxArea;
	}
	
}
