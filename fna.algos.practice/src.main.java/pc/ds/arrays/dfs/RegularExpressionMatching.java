package pc.ds.arrays.dfs;

public class RegularExpressionMatching {

	/**
	 * Given an input string (s) and a pattern (p), implement regular expression
	 * matching with support for '.' and '*'.
	 * 
	 * '.' Matches any single character. '*' Matches zero or more of the
	 * preceding element. The matching should cover the entire input string (not
	 * partial).
	 * 
	 * Note:
	 * 
	 * s could be empty and contains only lower case letters a-z. p could be
	 * empty and contains only lower case letters a-z, and characters like . or
	 * *.
	 **/

	// https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/RegexMatching.java
	/**
	 * Dynamic programming technique for regex matching.
	 */
	public boolean matchRegex(char[] text, char[] pattern) {
		boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

		T[0][0] = true;
		// Deals with patterns like a* or a*b* or a*b*c*
		for (int i = 1; i < T[0].length; i++) {
			if (pattern[i - 1] == '*') {
				T[0][i] = T[0][i - 2];
			}
		}

		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') { // see the youtube video description
					T[i][j] = T[i][j - 2]; // means 0 occurrence in string of preceding pattern character 
					if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) { // check if character before * in pattern is the current string character
						T[i][j] = T[i][j] | T[i - 1][j];
					}
				} else {
					T[i][j] = false;
				}
			}
		}
		return T[text.length][pattern.length];
	}
	
	
	// Laiq's leetcode submission
	Boolean isMatch(String s, String p) {
        return isMatch(s, p, s.length() - 1, p.length() - 1);
    }
    
    Boolean isMatch(String s, String p, int si, int pi) {
        if(si < -1) return false;
        if(si < 0 && pi < 0)	return true;
        if(pi < 0)  return false;
        
        if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') 
            return isMatch(s, p, si - 1, pi - 1);
        
        
        Boolean ret = false;
        if(p.charAt(pi) == '*')
        {
            ret = isMatch(s, p, si, pi - 2);
            if(p.charAt(pi-1) == '.' || p.charAt(pi-1) == s.charAt(si))
                ret = ret || isMatch(s, p, si - 1, pi);    
        }
        
        return ret;
        
    }
}
