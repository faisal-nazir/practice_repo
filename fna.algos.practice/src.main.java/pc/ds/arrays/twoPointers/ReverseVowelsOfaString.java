package pc.ds.arrays.twoPointers;

public class ReverseVowelsOfaString {

	/**
	 * Write a function that takes a string as input and reverse only the vowels
	 * of a string.
	 * 
	 * Example 1:
	 * 
	 * Input: "hello" Output: "holle" Example 2:
	 * 
	 * Input: "leetcode" Output: "leotcede" Note: The vowels does not include
	 * the letter "y".
	 **/

	public String reverseVowels_01(String s) {
		if (s == null || s.length() == 0)
			return s;
		int i = 0, j = s.length() - 1;
		char[] str = s.toCharArray();
		while (i < j) {
			while (i < j && !isVowel(str[i]))
				i++;
			while (i < j && !isVowel(str[j]))
				j--;

			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;
			i++;
			j--;
		}
		return new String(str);
	}
	
	// can use a hash set here to check for vowels
	private boolean isVowel(char ch) {
		ch = Character.toLowerCase(ch);
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}

	public String reverseVowels_02(String s) {
		if (s == null || s.length() == 0)
			return s;
		int i = 0, j = s.length() - 1;
		char[] str = s.toCharArray();
		while (i < j) {
			if (isVowel(str[i]) && isVowel(str[j])) {
				char temp = str[i];
				str[i] = str[j];
				str[j] = temp;
				i++;
				j--;
			} else if (!isVowel(str[i])) {
				i++;
			} else {
				j--;
			}
		}
		return new String(str);
	}
}
