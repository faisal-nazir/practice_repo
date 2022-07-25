package algo.patterns.slidingwindow;

import java.util.*;

public class LongestRepeatingCharacterReplacement {
	
	// https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation
	public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int left = 0, right = 0, maxLen = 1;
        int[] count = new int[26];
        int maxCount = 0;
        char[] chs = s.toCharArray();
        
        for(right = 0; right < chs.length; ++right) {
            char cr = chs[right];
            maxCount = Math.max(maxCount, ++count[cr - 'A']);
            
            while(right - left + 1 - maxCount > k) {
                char cl = chs[left];
                count[cl - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}