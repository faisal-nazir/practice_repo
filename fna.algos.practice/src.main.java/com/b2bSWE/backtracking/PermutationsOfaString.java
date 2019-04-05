package com.b2bSWE.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfaString {

	public static List<String> permutations(String input) {
		List<String> permutations = new ArrayList<String>();
		helper(input, permutations, "", input.length());
		return permutations;
	}
	
	private static void helper(String s, List<String> permutations, String prefix, int n) {
		if(prefix.length() == n) {
			permutations.add(prefix);
			return;
		}
		for(int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			String rem = s.substring(0, i) + s.substring(i+1);
			helper(rem, permutations, prefix + c, n);
		}
	}
	
	public static void main(String[] args) {
		String s = "abc";
		List<String> res = permutations(s);
		for(String p : res) {
			System.out.println(p);
		}
	}
}
