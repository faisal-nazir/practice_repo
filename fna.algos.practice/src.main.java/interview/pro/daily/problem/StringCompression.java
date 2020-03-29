package interview.pro.daily.problem;

import java.util.Arrays;

public class StringCompression {

	public static String compress(String s) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int count = 0;
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		
		while(i < chars.length) {
			char c = chars[i];
			count = 0;
			while(i < chars.length && c == chars[i]) {
				++i;
				++count;
			}
			sb.append(c);
			if(count > 1) {
				sb.append(count);
			}
		}
		
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		String s = "cccaabccc";
		System.out.print(compress(s));
	}
}
