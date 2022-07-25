package algo.patterns.slidingwindow;

import java.util.*;

public class LongestSubStringWithoutRepeatingCharacter {
	
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int right = 0, left = 0, max = 1;
        Set<Character> set = new HashSet<>();
        
        for(right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            while(set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            max = Math.max(max, right + 1 - left);      
        }
        return max;          
    }
}

