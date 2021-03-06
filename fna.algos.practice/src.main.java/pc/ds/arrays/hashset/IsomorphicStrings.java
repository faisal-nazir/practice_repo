package pc.ds.arrays.hashset;

public class IsomorphicStrings {

	/** 
		Given two strings s and t, determine if they are isomorphic.
		
		Two strings are isomorphic if the characters in s can be replaced to get t.
		
		All occurrences of a character must be replaced with another character while
		preserving the order of characters. 
		No two characters may map to the same character but a character may map to itself.
		
		Example 1:
		
		Input: s = "egg", t = "add"
		Output: true
		Example 2:
		
		Input: s = "foo", t = "bar"
		Output: false
		Example 3:
		
		Input: s = "paper", t = "title"
		Output: true
		Note:
		You may assume both s and t have the same length
		**/
	
	// https://leetcode.com/problems/isomorphic-strings/discuss/57796/My-6-lines-solution
	public static boolean isIsomorphic(String s, String t) {
		int[] m1 = new int[256], m2 = new int[256];
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			if (m1[s.charAt(i)] != m2[s.charAt(i)])
				return false;
			m1[i] = i + 1; // using (i+1) because 0 would be the default value,
							// idea is to use non-zero value to differentiate
			m2[i] = i + 1;
		}
		return true;
	}
}
