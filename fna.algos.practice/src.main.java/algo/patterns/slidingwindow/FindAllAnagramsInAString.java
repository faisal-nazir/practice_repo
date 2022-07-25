package algo.patterns.slidingwindow;

import java.util.*;

public class FindAllAnagramsInAString {
	
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p == null || p.length() == 0) return res;
        
        int[] map = new int[26];
        for(char c : p.toCharArray()) {
            map[c-'a']++;
        }
        
        int len = p.length();
        int right = 0, left = 0, count = len;
        char c;
        
        for(right = 0; right < s.length(); ++right) {
            c = s.charAt(right);
            map[c - 'a']--;
            
            if(map[c - 'a'] >= 0)
                --count;
            
            if(right + 1 - left > len) {
                c = s.charAt(left++);
                map[c - 'a']++;
                
                if(map[c - 'a'] > 0)
                    ++count;
            }
            
            if(count == 0)
                res.add(left);
        }
        
        return res;
    }
}