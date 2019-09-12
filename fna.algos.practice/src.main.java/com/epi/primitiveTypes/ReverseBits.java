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
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
}
