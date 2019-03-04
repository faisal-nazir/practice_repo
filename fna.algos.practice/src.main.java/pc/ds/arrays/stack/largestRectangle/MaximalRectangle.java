package pc.ds.arrays.stack.largestRectangle;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

	/** Given a 2D binary matrix filled with 0's and 1's, 
	 * find the largest rectangle containing only 1's and return its area.

		Example:
		
		Input:
		[
		  ["1","0","1","0","0"],
		  ["1","0","1","1","1"],
		  ["1","1","1","1","1"],
		  ["1","0","0","1","0"]
		]
		Output: 6
	**/
	
	// https://leetcode.com/problems/maximal-rectangle/discuss/29055/My-java-solution-based-on-Maximum-Rectangle-in-Histogram-with-explanation
	public int maximalRectangle_01(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[] height = new int[matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == '1')
				height[i] = 1;
		}
		int result = largestInLine(height);
		for (int i = 1; i < matrix.length; i++) {
			resetHeight(matrix, height, i);
			result = Math.max(result, largestInLine(height));
		}

		return result;
	}

	private void resetHeight(char[][] matrix, int[] height, int idx) {
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[idx][i] == '1')
				height[i] += 1;
			else
				height[i] = 0;
		}
	}

	public int largestInLine(int[] height) {
		if (height == null || height.length == 0)
			return 0;
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

	// https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution
	// see comments by 'Self_Learner'
	public static int maximalRectangle_02(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null
				|| matrix[0].length == 0)
			return 0;
		int m = matrix.length, n = matrix[0].length, maxArea = 0;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] height = new int[n];
		Arrays.fill(right, n - 1);
		for (int i = 0; i < m; i++) {
			int rB = n - 1;
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(right[j], rB);
				} else {
					right[j] = n - 1;
					rB = j - 1;
				}
			}
			int lB = 0;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(left[j], lB);
					height[j]++;
					maxArea = Math.max(maxArea, height[j]
							* (right[j] - left[j] + 1));
				} else {
					height[j] = 0;
					left[j] = 0;
					lB = j + 1;
				}
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		char[][] input = {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
		};
		System.out.print(maximalRectangle_02(input));
	}
}
