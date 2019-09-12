package com.epi.primitiveTypes;

public class SwapBits {
	
	//EPI-5.2: Swap bits

	public static long swapBits(long n, int i, int j) {
		if(((n >>> i) & 1) != ((n >>> j) & 1)) {
			long bitMask = (1L << i) | (1L << j);
			n ^= bitMask;
		}
		return n;
	}
}
