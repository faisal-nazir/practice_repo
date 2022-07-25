package algo.patterns.dfs;

import java.util.*;

public class GenerateParenthesis {

	// https://leetcode.com/problems/generate-parentheses/solution/
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if(n <= 0) return res;
		dfs(new StringBuilder(), 0, 0, n, res);
		return res;
	}

	public static void dfs(StringBuilder sb, int open, int close, int n, List<String> res) {
		if(sb.length() == n*2) {
			res.add(sb.toString());
			return;
		}

		if(open < n) {
			sb.append('(');
			dfs(sb, open+1, close, n, res);
			sb.deleteCharAt(sb.length()-1);
		}

		if(close < open) {
			sb.append(')');
			dfs(sb, open, close+1, n, res);
			sb.deleteCharAt(sb.length()-1);
		}
	}

	private static void helper(int n, int open, int close, String chosen, List<String> res) {
        if(open + close >= 2*n) {
            res.add(new String(chosen));
            return;
        }
        if(open < n)
            helper(n, open+1, close, chosen + "(", res);
        if(close < open) 
            helper(n, open, close+1, chosen + ")", res);
    }

    public static void main(String[] args) {
		List<String> res = generateParenthesis(2);
		for(String s : res) {
			System.out.print(s + " ");
		}
	}
}