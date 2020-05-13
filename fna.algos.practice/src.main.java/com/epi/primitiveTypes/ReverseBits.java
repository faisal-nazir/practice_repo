package com.epi.primitiveTypes;

import java.util.*;

public class ReverseBits {
	
	private static int[] precomputedReverse = new int[1<<16];

	public static long reverse(long n) {
		final int WORD_SIZE = 16;
		final int BIT_MASK = 0xFFFF;
		
		return precomputedReverse[(int)(n & BIT_MASK) ] << (3 * WORD_SIZE ) |
				precomputedReverse[(int)((n >>> WORD_SIZE) & BIT_MASK)] << (2 * WORD_SIZE) |
				precomputedReverse[(int)((n >>> (2 * WORD_SIZE) & BIT_MASK))] << WORD_SIZE |
				precomputedReverse[(int)(n >>> (3 * WORD_SIZE) & BIT_MASK)];
				
	}
	
	// EPI 5.3 - Reverse Bits
	// Brute force version
	public static int reverseBits(int x) {
		for(int i = 0; i < 16; ++i)  {
			if((x >>> (31-i) & 1) != ((x >>> i) & 1)){
				int bitMask = (1 << (31-i)) | (1 << i);
				x ^= bitMask;
			}
			
		}
		return x;
	}
	
	// simpler version of above idea
	public static int reverseBits_02(int x) {
		int l = 31;
		int r = 0;
		while(l > r) {
			if (((x >>> l) & 1) != ((x >>> r) & 1)) {
				int bitMask = (1 << l) | (1 << r);
				x ^= bitMask;
			}
			--l;
			++r;
		}
		return x;
	}
	
	
	// https://leetcode.com/problems/reverse-bits/discuss/54746/Java-Solution-and-Optimization
	// Simplest version
	public static int reverseBits_03(int x) {
		int res = 0;
		for(int i = 0; i < 32; ++i) {
			res += ((x >>> i) & 1);
			//x >>>= 1; // CATCH: must do unsigned shift
			if(i < 31) // CATCH: for last digit, don't shift!
				res <<= 1;	
		}
		return res;
	}
	
	
	public static void main(String[] args) {
//		System.out.println(reverseBits_03(43261596));
		System.out.println(reverseBits_03(47));
	}
}
