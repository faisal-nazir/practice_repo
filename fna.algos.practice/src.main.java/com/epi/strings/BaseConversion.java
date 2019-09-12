package com.epi.strings;

public class BaseConversion {
	
	// EPI-7.2: Base Conversion 

	public static String convertBase(String numAsString, int b1, int b2) {
		boolean isNegative = numAsString.startsWith("-");
		int numAsInt = 0;
		for(int i = (isNegative)? 1 : 0; i < numAsString.length(); ++i) {
			numAsInt *= b1;
			numAsInt += (Character.isDigit(numAsString.charAt(i))? 
							numAsString.charAt(i) - '0' : numAsString.charAt(i) - 'A' + 10);
		}
		return isNegative? "-" : "" + constructFromBase(numAsInt, b2);
	}
	
	private static String constructFromBase(int num, int base) {
		if(num == 0) return "";
		return constructFromBase(num/base, base) + 
				(char)((num%base >= 10)? 'A' + num%base -10 : '0' + num%base);
	}
	
	public static void main(String[] args) {
		System.out.print(convertBase("615", 7, 13));
	}
}
