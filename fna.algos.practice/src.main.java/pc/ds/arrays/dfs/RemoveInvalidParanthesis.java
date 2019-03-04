package pc.ds.arrays.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParanthesis {

	/** Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

		Note: The input string may contain letters other than the parentheses ( and ).
		
		Example 1:
		
		Input: "()())()"
		Output: ["()()()", "(())()"]
		Example 2:
		
		Input: "(a)())()"
		Output: ["(a)()()", "(a())()"]
		Example 3:
		
		Input: ")("
		Output: [""]
	**/
	
	// https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
	public List<String> removeInvalidParentheses_01(String s) {
	    List<String> ans = new ArrayList<>();
	    remove(s, ans, 0, 0, new char[]{'(', ')'});
	    return ans;
	}

	public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
	    for (int stack = 0, i = last_i; i < s.length(); ++i) {
	        if (s.charAt(i) == par[0]) stack++;
	        if (s.charAt(i) == par[1]) stack--;
	        if (stack >= 0) continue;
	        for (int j = last_j; j <= i; ++j)
	            if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
	                remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
	        return;
	    }
	    String reversed = new StringBuilder(s).reverse().toString();
	    if (par[0] == '(') // finished left to right
	        remove(reversed, ans, 0, 0, new char[]{')', '('});
	    else // finished right to left
	        ans.add(reversed);
	}
	
	//https://leetcode.com/problems/remove-invalid-parentheses/discuss/75034/Easiest-9ms-Java-Solution
	public List<String> removeInvalidParentheses_02(String s) {
	    int rmL = 0, rmR = 0;
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == '(') {
	            rmL++;
	        } else if (s.charAt(i) == ')') {
	            if (rmL != 0) {
	                rmL--;
	            } else {
	                rmR++;
	            }
	        }
	    }
	    Set<String> res = new HashSet<>();
	    dfs(s, 0, res, new StringBuilder(), rmL, rmR, 0);
	    return new ArrayList<String>(res);
	}

	public void dfs(String s, int i, Set<String> res, StringBuilder sb, int rmL, int rmR, int open) {
	    if (rmL < 0 || rmR < 0 || open < 0) {
	        return;
	    }
	    if (i == s.length()) {
	        if (rmL == 0 && rmR == 0 && open == 0) {
	            res.add(sb.toString());
	        }        
	        return;
	    }

	    char c = s.charAt(i); 
	    int len = sb.length();

	    if (c == '(') {
	        dfs(s, i + 1, res, sb, rmL - 1, rmR, open);		    // not use (
	    	dfs(s, i + 1, res, sb.append(c), rmL, rmR, open + 1);       // use (

	    } else if (c == ')') {
	        dfs(s, i + 1, res, sb, rmL, rmR - 1, open);	            // not use  )
	    	dfs(s, i + 1, res, sb.append(c), rmL, rmR, open - 1);  	    // use )

	    } else {
	        dfs(s, i + 1, res, sb.append(c), rmL, rmR, open);	
	    }

	    sb.setLength(len);        
	}
}
