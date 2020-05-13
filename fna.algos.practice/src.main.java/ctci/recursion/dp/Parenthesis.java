package ctci.recursion.dp;

import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Parenthesis {

	public static class Question_A {
		public static String insertInside(String str, int leftIndex) {
			String left = str.substring(0, leftIndex + 1);
			String right = str.substring(leftIndex + 1, str.length());
			return left + "()" + right;
		}
		
		public static Set<String> generateParens(int remaining) {
			Set<String> set = new HashSet<String>();
			if (remaining == 0) {
				set.add("");
			} else {
				Set<String> prev = generateParens(remaining - 1); 
				for (String str : prev) {
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '(') {
							String s = insertInside(str, i);
							/* Add s to set if it is not already in there. Note: 	
							 * HashSet automatically checks for duplicates before
							 * adding, so an explicit check is not necessary. */
							set.add(s);			
						}
					}
					set.add("()" + str);
				}
			}
			return set;
		}
		
//		public static void main(String[] args) {
//			Set<String> list = generateParens(4);
//			for (String s : list) {
//				System.out.println(s);
//			}
//			System.out.println(list.size());
//		}
	}
	
	public static class QuestionB {
		
		public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
			if (leftRem < 0 || rightRem < leftRem) return; // invalid state
			
			if (leftRem == 0 && rightRem == 0) { /* all out of left and right parentheses */
				list.add(String.copyValueOf(str));
			} else {
				str[index] = '('; // Add left and recurse
				addParen(list, leftRem - 1, rightRem, str, index + 1);
				
				str[index] = ')'; // Add right and recurse
				addParen(list, leftRem, rightRem - 1, str, index + 1);
			}
		}
		
		public static ArrayList<String> generateParens(int count) {
			char[] str = new char[count*2];
			ArrayList<String> list = new ArrayList<String>();
			addParen(list, count, count, str, 0);
			return list;
		}
		
		public static void main(String[] args) {
			ArrayList<String> list = generateParens(3);
			for (String s : list) {
				System.out.println(s);
			}
			System.out.println(list.size());		
		}

	}
	
	
	// https://leetcode.com/problems/generate-parentheses/solution/
	public static class Solution {
	    public List<String> generateParenthesis(int n) {
	        List<String> ans = new ArrayList<>();
	        backtrack(ans, "", 0, 0, n);
	        return ans;
	    }

	    public void backtrack(List<String> ans, String cur, int open, int close, int max){
	        if (cur.length() == max * 2) {
	            ans.add(cur);
	            return;
	        }

	        if (open < max)
	            backtrack(ans, cur+"(", open+1, close, max);
	        if (close < open)
	            backtrack(ans, cur+")", open, close+1, max);
	    }
	}
	
	
	// https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/794/
	// My submission
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0) return res;
        helper(n, "", 0, 0, res);
        return res;
    }
    
    private void helper(int n, String soFar, int open, int closed, List<String> res) {
        if(open >= n && closed >= n) {
            res.add(soFar);
            return;
        }
        if(open < n) 
            helper(n, soFar+'(', open+1, closed, res);
        if(closed < open)
            helper(n, soFar+')', open, closed+1, res);
        
    }
	
}
