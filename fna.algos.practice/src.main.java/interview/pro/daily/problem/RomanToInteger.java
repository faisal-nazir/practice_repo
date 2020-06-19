package interview.pro.daily.problem;

import java.util.*;

public class RomanToInteger {

	// https://leetcode.com/problems/roman-to-integer/
	// [Daily Problem] Convert Roman Numerals to Decimal
	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int res = 0;

		for(int i = 0; i < s.length(); ++i) {
			int value = map.get(s.charAt(i));
			if(i+1 < s.length()) {
				int next = map.get(s.charAt(i+1));
				if(next > value) {
					value = next - value;
					++i;
				}
			}
			res += value;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.print(romanToInt_02("IV"));
	}
	
	public static int romanToInt_02(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int res = 0;
        res += map.get(s.charAt(0));
        
        for(int i = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            
            if((c == 'V'  || c == 'X') && s.charAt(i-1) == 'I')
                res -= map.get('I');

            if((c == 'L'  || c == 'C') && s.charAt(i-1) == 'X')
                res -= map.get('X');

            if((c == 'D'  || c == 'M') && s.charAt(i-1) == 'C')
                    res -= map.get('C');
            
            res += map.get(c);
                
        }
        
        return res;
    }
}
