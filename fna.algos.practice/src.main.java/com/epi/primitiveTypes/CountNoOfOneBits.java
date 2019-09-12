package com.epi.primitiveTypes;

public class CountNoOfOneBits {

	private static short count(int num) {
		short c = 0;
		while(num != 0) {
			c += num & 1;
			num >>>= 1;
		}
		return c;
	}
	
	public static void main(String[] args) {
		int n = 7;
		System.out.print(count(n));
	}
}
