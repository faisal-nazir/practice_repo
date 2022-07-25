import java.util.*;

public class MinimumWindowSubString {
	
	public String minWindow(String s, String t) {
        if(t == null || s == null || t.length() > s.length()) return "";
        int[] map = new int[128];
        int left = 0, right = 0, min = Integer.MAX_VALUE, count = t.length();
        int st = 0, d = 0;
        char ch;
        
        for(char c : t.toCharArray()) {
            map[c]++;
        }
        for(right = 0; right < s.length(); ++right) {
            ch = s.charAt(right);
            map[ch]--;
            
            if(map[ch] >= 0) {
                count--;
            }
            
            while(count == 0) {
                
                if(min > right-left+1) {
                    st = left;
                    d = right-left+1;
                    min = d;
                }
                
                ch = s.charAt(left++);
                map[ch]++;
                
                
                if(map[ch] > 0)
                    count++;
            }
        }
        
        return (min == Integer.MAX_VALUE)? "" : s.substring(st, st+d);
    }
}