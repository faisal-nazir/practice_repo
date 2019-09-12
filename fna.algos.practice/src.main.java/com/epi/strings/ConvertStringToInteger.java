package com.epi.strings;

public class ConvertStringToInteger {
	
	//EPI-6.1
	
	public static int convertToInt(String num) {
		int res = 0;
		char[] nums = num.toCharArray();
		for(int i = 0; i < nums.length; ++i) {
			int digit = nums[i] - '0';
			res *= 10;
			res += digit;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int n = 123;
		System.out.print(convertToString(n));
				
	}
	
	public static String convertToString(int num) {
		boolean negative = false;
		if(num < 0) 
			negative = true;
		
		StringBuilder sb = new StringBuilder();
		while(num != 0) {
//			sb.append((char)( '0' + Math.abs(num%10)));
			sb.append(Math.abs(num%10));
			num /= 10;
		}
		if(negative)
			sb.append('-');
		sb.reverse();
		return sb.toString();
	}

}
