package pc.ds.arrays.rotate;

public class ReverseWordsInAString {

	/**
	 * Given an input string, reverse the string word by word.
	 * 
	 * Example:
	 * 
	 * Input: "the sky is blue", Output: "blue is sky the". Note:
	 * 
	 * A word is defined as a sequence of non-space characters. Input string may
	 * contain leading or trailing spaces. However, your reversed string should
	 * not contain leading or trailing spaces. You need to reduce multiple
	 * spaces between two words to a single space in the reversed string. Follow
	 * up: For C programmers, try to solve it in-place in O(1) space.
	 */

	// https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
	public void reverseWords(char[] s) {
		int i = 0;
		for (int j = 0; j < s.length; j++) {
			if (s[j] == ' ') {
				reverse(s, i, j - 1); // reverse each word of the string
				i = j + 1;
			}
		}
		reverse(s, i, s.length - 1); // reverse last word
		reverse(s, 0, s.length - 1); // reverse whole string again
	}

	public void reverse(char[] s, int i, int j) {
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}
}
