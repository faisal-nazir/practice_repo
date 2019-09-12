package com.epi.primitiveTypes;

public class ClosestIntegerWithSameWeight {

	// EPI-5.4: Find a closest Integer with same weight
	
	private static final short NUM_BITS = 63;
	
	public static long compute(long x) {
		for(int i = 0; i < NUM_BITS -1; ++i) {
			if(((x >>> i) & 1) != ((x >>> i+1) & 1)) {
				x ^= (1L << i) | (1L << (i+1));
				return x;
			}
		}
		
		throw new IllegalArgumentException("All bits are 0s or 1s");
	}
}
