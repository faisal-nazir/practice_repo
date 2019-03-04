package com.amazon.online;

import java.util.Arrays;
import java.util.TreeMap;

public class PrimeSum {

    TreeMap<Integer, Integer> sums;

    public int primeSum(int n) { //input the upper limit for all Ns
        sums = new TreeMap<Integer, Integer>();
        // init an array to track prime numbers
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i + i; j < n; j += i)
                    primes[j] = false;
            }
        }
        // insert sums into cache
        int sum = 0;
        for(int i = 2; i <= n; i++) {
            if(primes[i]) {
                sums.put(i - 1, sum);
                sum += i;
            }
        }
        if(primes[n]) {
            sums.put(n, sum);
        }
        return sum;
    }

    public int _primeSum(int N) {
        Integer ceiling = sums.ceilingKey(N);
        //if(ceiling == null) {
            //Exception("input value overflows");
        //}
        return sums.get(ceiling);
    }
    
    public static void main(String[] args) {
    	PrimeSum s = new PrimeSum();
    	System.out.println(s.primeSum(9));
    }
}
