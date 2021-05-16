package com.b2bSWE.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

		Return all possible palindrome partitioning of s.
		
		Example:
		
		Input: "aab"
		Output:
		[
		  ["aa","b"],
		  ["a","a","b"]
		]
	 */
	
	 public List<List<String>> partition(String s) {
	        List<List<String>> res = new ArrayList<>();
	        if(s == null || s.length() == 0) return res;
	        helper(s, 0, new ArrayList<String>(), res);
	        return res;
	    }
	    
	 private void helper(String s, int start, List<String> current, List<List<String>> res) {
	        if(start >= s.length()) {
	            res.add(new ArrayList<>(current));
	            return;
	        }
	        
	        for(int end = start; end < s.length(); ++end) {
	            String subString = s.substring(start, end+1);
	            System.out.println(subString);
	            if(isPalindrome(subString)) {
	                current.add(subString);
	                helper(s, end+1, current, res);
	                current.remove(current.size()-1);
	            }
	        }
	    }
	    
	    private boolean isPalindrome(String s) {
	        int i = 0;
	        int j = s.length()-1;
	        while(i <=j) {
	            if(s.charAt(i) != s.charAt(j))
	                return false;
	            ++i; --j;
	                
	        }
	        return true;
	    }
	    
	    public static void main(String[] args) {
	    	String str = "aab";
	    	PalindromePartitioning p = new PalindromePartitioning();
	    	p.partition(str);
	    }
}
