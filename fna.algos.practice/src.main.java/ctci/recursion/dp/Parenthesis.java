package ctci.recursion.dp;

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
	
}
