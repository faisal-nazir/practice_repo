package algo.patterns.dfs;

import java.util.*;

public class LetterCombinationsOfaPhoneNumber {
	
	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if(digits == null || digits.length() == 0) return res;

		String[] mappings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		solve(0, digits, new StringBuilder(), mappings, res);

		return res;
	}

	public static void solve(int idx, String digits, StringBuilder soFar, String[] mappings, List<String> res) {
		if(idx == digits.length()) {
			res.add(soFar.toString());
			return;
		}

		String choices = mappings[digits.charAt(idx) - '0'];

		for(int i = 0; i < choices.length(); ++i) {
			soFar.append(choices.charAt(i));
			solve(idx+1, digits, soFar, mappings, res);
			soFar.deleteCharAt(soFar.length()-1);
		}

	}

	public static void main(String[] args) {
		List<String> res = letterCombinations("23");
		for(String s : res) {
			System.out.print(s + " ");
		}
	}
}