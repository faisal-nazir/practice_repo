package interview.pro.daily.problem;

import java.util.*;

public class WordOrdering {
	
	// Word Ordering in a Different Alphabetical Order
	// https://leetcode.com/problems/verifying-an-alien-dictionary/
	
	public static boolean verifyOrder(List<String> words, String order) {
		int[] map = new int[26];
		for(int i = 0; i < order.length(); ++i) { // construct mapping to the give order.
			char c = order.charAt(i);
			map[c - 'a'] = i;
		}
		for(int i = 1; i < words.size(); ++i) { // // Verify the adjacent words order. 
			if(compare(words.get(i-1), words.get(i), map) > 0)
				return false;
		}
		return true;
	}
	
	private static int compare(String s1, String s2, int[] map) { // compare the 2 words char by char.
		int s1_len = s1.length(), s2_len = s2.length(), comp = 0;
		for(int i = 0, j = 0; i < s1_len && j < s2_len && comp == 0; ++i, ++j) {
			comp = map[s1.charAt(i) - 'a'] - map[s2.charAt(j) - 'a']; // compare according to the given order
		}
		return comp == 0 ? s1_len - s2_len : comp; // when one word is the prefix of the other, compare their sizes.
	}
	
	public static void main(String[] args) {
		List<String> words = Arrays.asList("abcd", "efgh"); 
		String order = "zyxwvutsrqponmlkjihgfedcba";
		System.out.println(verifyOrder(words, order));
	}
}
