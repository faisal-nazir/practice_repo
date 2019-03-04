	package pc.ds.arrays.hashMap.tracking;

public class LongestSubstringWithAtMostKDistinctCharacters {

	/** Given a string, find the length of the longest substring T that contains at most k distinct characters.

		Example 1:
		
		Input: s = "eceba", k = 2
		Output: 3
		Explanation: T is "ece" which its length is 3.
		Example 2:
		
		Input: s = "aa", k = 1
		Output: 2
		Explanation: T is "aa" which its length is 2.
	**/
	
	// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/discuss/80047/15-lines-java-solution-using-slide-window
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int[] count = new int[256];
		int num = 0, i = 0, res = 0;
		for (int j = 0; j < s.length(); j++) {
			if (count[s.charAt(j)]++ == 0)
				num++;
			if (num > k) {
				while (--count[s.charAt(i++)] > 0)
					;
				num--;
			}
			res = Math.max(res, j - i + 1);
		}
		return res;
	}
	
	
	// same as above
	public int lengthOfLongestSubstringKDistinct_02(String s, int k) {
        // because With extended ASCII codes, there are total 256 characters
        int[] charCount = new int[256]; 
        int uniqueCharactersSoFar = 0, startIndex = 0, maxLength = 0;
        for (int currIndex = 0; currIndex < s.length() ; currIndex++) {
            if (charCount[s.charAt(currIndex)]++ == 0)
                uniqueCharactersSoFar++;
            if (uniqueCharactersSoFar > k) {
                if (--charCount[s.charAt(startIndex)] == 0) {
                    uniqueCharactersSoFar--;
                }
               startIndex++;
            }
            maxLength = Math.max(maxLength, currIndex - startIndex + 1);
        }
        return maxLength;
    }
	
	// https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
	public static int lengthOfLongestSubstringWithKDistinct(String s, int k) {
		int[] map = new int[128];
		int counter = 0, begin = 0, end = 0, d = 0;
		while (end < s.length()) {
			if (map[s.charAt(end++)]++ == 0)
				counter++;
			while (counter > k) {
				if (map[s.charAt(begin++)]-- == 1)
					counter--; // make it valid
			}
			d = Math.max(d, end - begin);
		}
		return d;
	}
	 	
}
