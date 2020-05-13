package pc.ds.arrays.twoPointers;

public class LongestPalindromeSubstring {

	/** Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

		Example 1:
		
		Input: "babad"
		Output: "bab"
		Note: "aba" is also a valid answer.
		Example 2:
		
		Input: "cbbd"
		Output: "bb"
	**/
	
	private int lo, maxLen;

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	
	// DP solution
	// https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using-dynamic-programming
	public static class Solution {
	    public static String longestPalindrome_02(String s) {
	        int n = s.length();
	        String res = null;
	        int palindromeStartsAt = 0, maxLen = 0;

	        boolean[][] dp = new boolean[n][n];
	        // dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome
	        
	        for(int i = n-1; i >= 0; i--) { // keep increasing the possible palindrome string
	            for(int j = i; j < n; j++) { // find the max palindrome within this window of (i,j)
	                
	                //check if substring between (i,j) is palindrome
	                dp[i][j] = (s.charAt(i) == s.charAt(j)) // chars at i and j should match
	                           && 
	                           ( j-i < 3  // if window is less than or equal to 3, just end chars should match
	                             || dp[i+1][j-1]  ); // if window is > 3, substring (i+1, j-1) should be palindrome too
	                
	                //update max palindrome string
	                if(dp[i][j] && (j-i+1 > maxLen)) {
	                    palindromeStartsAt = i;
	                    maxLen = j-i+1;
	                }
	            }
	        }
	        return s.substring(palindromeStartsAt, palindromeStartsAt+maxLen);
	    }
	}
	
	// from Nick White videos
	private class MySubmission {
	    public String longestPalindrome(String s) {
	        if(s == null || s.length() <=1) return s;
	        
	        int start = 0;
	        int end = 0;
	        int max_len = Integer.MIN_VALUE;
	        
	        for(int i = 0; i < s.length(); ++i) {
	            int len1 = expandPalindromicSubString(s, i, i);
	            int len2 = expandPalindromicSubString(s, i, i+1);
	            int len  = Math.max(len1, len2);
	            if(len > max_len) {
	                max_len = len;
	                start = i - ((len-1)/2);
	                end = i + (len/2);
	            }
	        }
	        
	        return s.substring(start, end+1);
	    }
	    
	    private int expandPalindromicSubString(String s, int left, int right) {
	        if(s == null || left > right) return 0;
	        
	        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
	            --left;
	            right++;
	        }
	        return right-left-1;
	    }
	    
	    // racecar
	}
}
