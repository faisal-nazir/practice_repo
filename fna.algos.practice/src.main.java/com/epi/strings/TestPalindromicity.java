package com.epi.strings;

public class TestPalindromicity {
	
	//EPI-7.5: Test palindromicity

	public static boolean isPalindrome(String str) {
		int s =  0, e = str.length()-1;
		while(s < e) {
			while(!Character.isLetterOrDigit(str.charAt(s)) && (s < e))
				++s;
			while(!Character.isLetterOrDigit(str.charAt(e)) && (s < e))
				--e;
			if(Character.toLowerCase(str.charAt(s)) != 
					Character.toLowerCase(str.charAt(e))) 
				return false;
		}
	
	return true;
	}
}
