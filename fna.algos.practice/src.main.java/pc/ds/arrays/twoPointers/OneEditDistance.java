package pc.ds.arrays.twoPointers;

public class OneEditDistance {

	/**
	 * Given two strings s and t, determine if they are both one edit distance
	 * apart.
	 * 
	 * Note:
	 * 
	 * There are 3 possiblities to satisify one edit distance apart:
	 * 
	 * Insert a character into s to get t Delete a character from s to get t
	 * Replace a character of s to get t Example 1:
	 * 
	 * Input: s = "ab", t = "acb" Output: true Explanation: We can insert 'c'
	 * into s to get t. Example 2:
	 * 
	 * Input: s = "cab", t = "ad" Output: false Explanation: We cannot get t
	 * from s by only one step. Example 3:
	 * 
	 * Input: s = "1203", t = "1213" Output: true Explanation: We can replace
	 * '0' with '1' to get t.
	 **/
	// ctci: 1.5
	public static boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference) {
					return false;
				}

				foundDifference = true;
			}
		}
		return true;
	}

	/* Check if you can insert a character into s1 to make s2. */
	public static boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	public static boolean oneEditAway(String first, String second) {
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if (first.length() - 1 == second.length()) {
			return oneEditInsert(second, first);
		}
		return false;
	}

	public static void main(String[] args) {
		String a = "pse";
		String b = "pale";
		boolean isOneEdit = oneEditAway(a, b);
		System.out.println(a + ", " + b + ": " + isOneEdit);
	}

	public static boolean oneEditAway_02(String first, String second) {
		/* Length checks. */
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}

		/* Get shorter and longer string. */
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;

		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				/* Ensure that this is the first difference found. */
				if (foundDifference)
					return false;
				foundDifference = true;
				if (s1.length() == s2.length()) { // On replace, move shorter
													// pointer
					index1++;
				}
			} else {
				index1++; // If matching, move shorter pointer
			}
			index2++; // Always move pointer for longer string
		}
		return true;
	}
}
