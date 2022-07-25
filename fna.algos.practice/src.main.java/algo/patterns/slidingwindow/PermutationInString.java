package algo.patterns.slidingwindow;

import java.util.*;

public class PermutationInString {
	
	public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() > s2.length()) return false;
        
        int[] map = new int[28];
        for(char c : s1.toCharArray()) {
            map[c - 'a']++;
        }
        
        int left = 0, right = 0, count = s1.length(); 
        int m = s1.length();
        int n = s2.length();
        int len = m;
        
        for(right = 0; right < n; ++right) {
            char ch = s2.charAt(right);
            map[ch - 'a']--;
            if(map[ch -'a'] >= 0) 
                count--;
            
            if(right-left+1 > len) {
                ch = s2.charAt(left);
                map[ch -'a']++;
                if(map[ch - 'a'] > 0)
                    count++;
                left++;
            }
            
            if(count == 0)
                return true;
        }
        
        return false;
    }
}