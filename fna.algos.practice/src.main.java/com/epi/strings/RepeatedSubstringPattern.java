package com.epi.strings;

public class RepeatedSubstringPattern {

	// https://leetcode.com/problems/repeated-substring-pattern/
	
	public static boolean repeatedSubstringPattern(String s) {
        if(s == null || s.isEmpty()) return false;
        int n = s.length();
        int[] lps = getLPSTable(s);
        int len_lps = lps[lps.length-1];
        return (len_lps > 0) && (n % (n-len_lps) == 0);
    }
    
    public static int[] getLPSTable(String s) {
        int[] T = new int[s.length()+1];
        T[0] = -1;
        int j = -1;
        int i = 0;
        while(i < s.length()) {
            while(j >= 0 && s.charAt(i) != s.charAt(j)) j = T[j];
            ++i; ++j;
            T[i] = j;
        }
        return T;
    }
    
    public static void main(String[] args) {
    	String s = "aba";
    	System.out.println(repeatedSubstringPattern(s));
    }
}
