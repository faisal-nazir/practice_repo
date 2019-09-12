package com.epi.primitiveTypes;

public class ParityOfaWord {

	
	// EPI- 5.1: Compute parity of a word
	private static short parity(long word) {
		short ans = 0;
		while(word != 0) {
			ans ^= (word & 1);
			word >>>= 1;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		long w = 5;
		System.out.print(compute_parity(w));
	}
	
	private static short compute_parity(long n) {
		short res = 0;
		while(n != 0) {
			res ^= 1;
			//n ^= n & ~(n-1); // Drops the lowest set bit of 'n'.
			n &= (n-1);
		}
		return res;
	}
	
	private static short compute_parity_efficient(long x) {
		x ^= x >>> 32;
		x ^= x >>> 16;
		x ^= x >>> 8;
		x ^= x >>> 4;
		x ^= x >>> 2;
		x ^= x >>> 1;
		
		return (short)(x & 0x1);
	}
}
