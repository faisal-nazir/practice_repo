package pc.ds.arrays.stack.nestedObjects;

import java.util.LinkedList;
import java.util.List;

public class NestedListWeightSum_I {

	/**
	 * Given a nested list of integers, return the sum of all integers in the
	 * list weighted by their depth.
	 * 
	 * Each element is either an integer, or a list -- whose elements may also
	 * be integers or other lists. Example 1: Given the list [[1,1],2,[1,1]],
	 * return 10. (four 1's at depth 2, one 2 at depth 1)
	 **/
	// https://www.programcreek.com/2014/05/leetcode-nested-list-weight-sum-java/
	// Recursive
	public int depthSum_recursive(List<INestedInteger> nestedList) {
		return helper(nestedList, 1);
	}

	public int helper(List<INestedInteger> nestedList, int depth) {
		if (nestedList == null || nestedList.size() == 0)
			return 0;

		int sum = 0;
		for (INestedInteger ni : nestedList) {
			if (ni.isInteger()) {
				sum += ni.getInteger() * depth;
			} else {
				sum += helper(ni.getList(), depth + 1);
			}
		}

		return sum;
	}

	// Iterative
	public int depthSum_iterative(List<INestedInteger> nestedList) {
		int sum = 0;

		LinkedList<INestedInteger> queue = new LinkedList<INestedInteger>();
		LinkedList<Integer> depth = new LinkedList<Integer>();

		for (INestedInteger ni : nestedList) {
			queue.offer(ni);
			depth.offer(1);
		}

		while (!queue.isEmpty()) {
			INestedInteger top = queue.poll();
			int dep = depth.poll();

			if (top.isInteger()) {
				sum += dep * top.getInteger();
			} else {
				for (INestedInteger ni : top.getList()) {
					queue.offer(ni);
					depth.offer(dep + 1);
				}
			}
		}

		return sum;
	}
}
