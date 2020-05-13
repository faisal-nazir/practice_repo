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
	
	// https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/744/
	public int countPrimes(int n) {
        if(n <= 1) return 0;
        int count = 0;
        
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);
        
        arr[0] = false;
        
        for(int i = 2; i < n; i++) {
            if(arr[i]) {
                ++count;
                for(int j = i; j < n; j+=i)
                    arr[j] = false;
            }
        }
        
        return count;
    }
}
