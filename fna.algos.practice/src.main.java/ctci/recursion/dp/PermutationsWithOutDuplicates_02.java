package ctci.recursion.dp;

import java.util.ArrayList;

public class PermutationsWithOutDuplicates_02 {

	// Solution - 02: Building from permutations of all n-1 character substrings.
	// O(n2 * n!)
	
	public static void getPerms(String prefix, String remainder, ArrayList<String> result) {
		if (remainder.length() == 0) {
			result.add(prefix);
		}
		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);
			getPerms(prefix + c, before + after, result);
		}
	}
	
	public static ArrayList<String> getPerms(String str) {
		ArrayList<String> result = new ArrayList<String>();
		getPerms("", str, result);
		return result;
	}
	

	static void RecPermute(String soFar, String rest) {
		if(rest.isEmpty()) 
			System.out.println(soFar);
		else {
			for(int i = 0; i < rest.length(); ++i) {
				String rem = rest.substring(0, i) + rest.substring(i+1);
				RecPermute(soFar + rest.charAt(i), rem);
			}
			
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abc");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("Testing Another method");
		RecPermute("", "abc");
	}
}
