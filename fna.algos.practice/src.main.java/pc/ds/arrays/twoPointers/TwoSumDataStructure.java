package pc.ds.arrays.twoPointers;

import java.util.HashMap;

public class TwoSumDataStructure {

	/**
	 * Design and implement a TwoSum class. It should support the following
	 * operations: add and find.
	 * 
	 * add - Add the number to an internal data structure. find - Find if there
	 * exists any pair of numbers which sum is equal to the value.
	 * 
	 * Example 1:
	 * 
	 * add(1); add(3); add(5); find(4) -> true find(7) -> false Example 2:
	 * 
	 * add(3); add(1); add(2); find(3) -> true find(6) -> false
	 **/
	private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

	// constant time
	public void add(int number) {
		if (elements.containsKey(number)) {
			elements.put(number, elements.get(number) + 1);
		} else {
			elements.put(number, 1);
		}
	}

	// O(n) time
	public boolean find(int value) {
		for (Integer i : elements.keySet()) {
			int target = value - i;
			if (elements.containsKey(target)) {
				if (i == target && elements.get(target) < 2) {
					continue;
				}
				return true;
			}
		}
		return false;
	}
}
