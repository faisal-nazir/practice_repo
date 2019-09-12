package com.epi.arrays;

import java.util.*;

public class EnumerateAllPrimes {

	//EPI-6.8 : ENUMERATE ALL PRIMES TO n
	
	// time complexity : n log log n
	public static List<Integer> enumerate(int n) {
		List<Integer> primes = new ArrayList<>();
		List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n+1, true));
		for(int i = 2; i <= n; ++i) {
			if(isPrime.get(i)) {
				primes.add(i);
				
				for(int j = i; j <= n; j+=i) {
					isPrime.set(j, false);
				}
			}
		}
		return primes;
	}
}
