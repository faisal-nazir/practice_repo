package algo.patterns.slidingwindow;

import java.util.*;

public class LongestSubStringWithAtMostKDistinctCharacters {
	
	public static int lengthOfLongestSubstring(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        
        int right = 0, left = 0, max = 1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        
        for(right = 0; right < s.length(); ++right) {
            map.put(chs[right], map.getOrDefault(chs[right], 0) + 1);
            
            while(map.size() > k) {
                map.put(chs[left], map.get(chs[left]) - 1);
                if(map.get(chs[left]) == 0)
                       map.remove(chs[left]);
                ++left; 
            }
            max = Math.max(max, right + 1 -left);
        }
        return max;          
    }

    public static void main(String[] args) {
        String s = "aabbceeeefff";
        int k = 2;
        System.out.println(lengthOfLongestSubstring(s, k));
    }
}

