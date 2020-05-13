package pc.ds.arrays.hashMap.tracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacter {

	/** Given a string, find the length of the longest substring without repeating characters.

		Example 1:
		
		Input: "abcabcbb"
		Output: 3 
		Explanation: The answer is "abc", with the length of 3. 
		Example 2:
		
		Input: "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
		Example 3:
		
		Input: "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3. 
        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     **/
	
	// https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation
	public static int lengthOfLongestSubstring_01(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
	
	// https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1812/Share-my-Java-solution-using-HashSet
	public static int lengthOfLongestSubstring_02(String s) {
	    int i = 0, j = 0, max = 0;
	    Set<Character> set = new HashSet<>();
	    
	    while (j < s.length()) {
	        if (!set.contains(s.charAt(j))) { 
	            set.add(s.charAt(j));
	            j++;
	            max = Math.max(max, set.size());
	        } else {
	            set.remove(s.charAt(i));
	            i++;
	        }
	    }
	    
	    return max;
	}
	
	//https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
	int lengthOfLongestSubstring(String s) {
		int[] map = new int[128];
		int counter = 0, begin = 0, end = 0, d = 0;
		while (end < s.length()) {
			if (map[s.charAt(end++)]++ > 0)
				counter++;
			while (counter > 0)
				if (map[s.charAt(begin++)]-- > 1)
					counter--;
			d = Math.max(d, end - begin); // while valid, update d
		}
		return d;
	}
	
	public static int length(String str) {
        if(str == null || str.length() == 0) return 0;
        int counter = 0, s = 0, e = 0, d = 0;
        int[] map = new int[128];
        while(e < str.length()) {
            if(++map[str.charAt(e++)] > 1) {
            	counter++;
            }
            while(counter > 0) {
            	if(--map[str.charAt(s++)] == 1)
                	counter--;
            }
            d = Math.max(d, e-s);
        }
        return d;
    }
	
	public static void main(String[] args) {
		String input =  "bacabcabcdaab";
		System.out.println(lengthOfLongestSubstring_01(input));
		System.out.println(length(input));
		input = "abcabcbb";
		System.out.println(lengthOfLongestSubstring_simple(input));
	}
	
	// https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/
	// my submission
	public static int lengthOfLongestSubstring_simple(String s) {
        int res = 0;
        if(s == null || s.length() == 0) return res;
        int[] map = new int[128];
        char[] A = s.toCharArray();
        
        int left = 0, right = 0, counter = 0;
        
        while(right < A.length) {
            char c = A[right];
            map[c]++;
            right++;
            if(map[c] > 1) {
                counter++;            
            } 
            
            while(counter > 0) {
                c = A[left];
                map[c]--;
                left++;
                if(map[c] == 1) {
                    counter--;
                }
            }
            res = Math.max(res, right-left);
        }
        return res;
    }
}
