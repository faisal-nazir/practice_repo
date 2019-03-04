package pc.ds.arrays.stack.nestedObjects;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum_II {

	/**
	 * Given a nested list of integers, return the sum of all integers in the
	 * list weighted by their depth.
	 * 
	 * Each element is either an integer, or a list -- whose elements may also
	 * be integers or other lists. Different from the previous question where
	 * weight is increasing from root to leaf, now the weight is defined from
	 * bottom up. i.e., the leaf level integers have weight 1, and the root
	 * level integers have the largest weight.
	 * 
	 * Example 1: Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth
	 * 1, one 2 at depth 2) Example 2: Given the list [1,[4,[6]]], return 17.
	 * (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 +
	 * 6*1 = 17)
	 **/

	// http://massivealgorithms.blogspot.com/2016/06/leetcode-364-nested-list-weight-sum-ii.html
	// Inspired by lzb700m's solution and one of mine.
	// Instead of multiplying by depth, add integers multiple times
	// (by going level by level and adding the unweighted sum to the weighted
	// sum after each level).
	// BFS Approach
	public int depthSumInverse_bfs(List<INestedInteger> nestedList) {
		int unweighted = 0, weighted = 0;
		while (!nestedList.isEmpty()) {
			List<INestedInteger> nextLevel = new ArrayList<>();
			for (INestedInteger ni : nestedList) {
				if (ni.isInteger())
					unweighted += ni.getInteger();
				else
					nextLevel.addAll(ni.getList());
			}
			weighted += unweighted;
			nestedList = nextLevel;
		}
		return weighted;
	}

	public int depthSumInverse_dfs(List<INestedInteger> nestedList) {
		return helper(nestedList, 0);
	}

	private int helper(List<INestedInteger> niList, int prev) {
		int intSum = prev;
		List<INestedInteger> levelBreak = new ArrayList<>();

		for (INestedInteger ni : niList) {
			if (ni.isInteger()) {
				intSum += ni.getInteger();
			} else {
				levelBreak.addAll(ni.getList());
			}
		}

		int listSum = levelBreak.isEmpty() ? 0 : helper(levelBreak, intSum);

		return listSum + intSum;
	}
}
