package pc.ds.arrays.others;

public class ShortestDistancetoaCharacter {

	// https://leetcode.com/problems/shortest-distance-to-a-character/
	/** Given a string S and a character C, return an array of integers 
	 *  representing the shortest distance from the character C in the string.

		Example 1:
		
		Input: S = "loveleetcode", C = 'e'
		Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
		 
		
		Note:
		
		S string length is in [1, 10000].
		C is a single character, and guaranteed to be in string S.
		All letters in S and C are lowercase.
	 **/
	
	public static int[] compute(String s, char c) {
		char[] a = s.toCharArray();
		int n = a.length;
		int[] res = new int[n];
		int p = -n;
		for(int i = 0; i < n; ++i) {
			if(a[i] == c)
				p = i;
			res[i] = i - p;
		}
		
		for(int i = n-1; i >= 0; --i) {
			if(a[i] == c)
				p = i;
			res[i] = Math.min(res[i], Math.abs(i-p));
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		String s = "loveleetcode";
		print(compute(s, 'e'));
		
	}
	
	private static void print(int[] A) {
		for(int val : A) {
			System.out.print(val + " ");
		}
	}
}
