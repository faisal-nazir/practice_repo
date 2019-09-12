package com.epi.arrays;

public class AddBinaryNumbers {
	// EPI - variant of 6.2
	private static final char ONE = '1';
	private static final char ZERO = '0';

	public static String add(String s, String t) {
		String larger = (s.length() > t.length()) ? s : t;
		String smaller = (s.length() > t.length()) ? t : s;
		StringBuilder sb = new StringBuilder();
		char carry = ZERO;
		int idx_s = smaller.length()-1;
		int idx_l = larger.length()-1;
		while(idx_s >= 0 && idx_l >= 0) {
			char c1 = smaller.charAt(idx_s);
			char c2 = larger.charAt(idx_l);
			if(c1 == ONE && c2 == ONE) {
				if(carry == ONE) {
					sb.insert(0, ONE);
				} else {
					sb.insert(0, ZERO);
				}
				carry = ONE;
			} else if(c1 == ONE || c2 == ONE) {
				if(carry == ONE) {
					sb.insert(0, ZERO);
					carry = ONE;
				} else {
					sb.insert(0, ONE);
					carry = ZERO;
				}
			} else {
				if(carry == ONE) {
					sb.insert(0, ONE);
				} else {
					sb.insert(0, ZERO);
				}
				carry = ZERO;
			}
			--idx_s;--idx_l;
		}
		
		while(idx_l >= 0) {
			char c = larger.charAt(idx_l);
			if(carry == ONE) {
				if(c == ONE) {
					sb.insert(0, ZERO);
					carry = ONE;
				} else {
					sb.insert(0, ONE);
					carry = ZERO;
				}
				
			} else {
				sb.insert(0, larger.charAt(idx_l));
			}
			--idx_l;
		}
		
		if(carry == ONE)
			sb.insert(0, ONE);
		
		return sb.toString();		
	}
	
	
	// https://leetcode.com/problems/add-binary/
	public String addBinary(String a, String b) {
        
        int carry = 0;
        int m = a.length() - 1;
        int n = b.length() - 1;
        StringBuilder builder = new StringBuilder();
        while(m >= 0 || n >=0) { 
            int x = (m < 0) ? 0 : a.charAt(m--) - '0';
            int y = (n < 0) ? 0 : b.charAt(n--) - '0';
            
            int sum = x + y + carry;
            carry = sum / 2;
            builder.append(sum%2);
        }
        
        if(carry > 0)   builder.append(carry);
        
        return builder.reverse().toString();
    }
	
	public static void main(String[] args) {
		String s = "101";
		String t = "1001";
		System.out.print(add(s,t));
	}
}
