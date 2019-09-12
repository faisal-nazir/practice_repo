package com.epi.strings;

import java.util.*;

public class ReplaceAndRemove {

	// with time complexity of n^2.
	public static List<Character> replaceAndRemove(List<Character> input) {
		for(int i = 0; i < input.size(); ++i) {
			if(input.get(i) == 'a') {
				input.add(i, new Character('a'));
				i+=2;
			}
			while(i < input.size() && input.get(i) == 'b') {
				input.remove(i);
			}
			
		}
		return input;
	}
	
	// with O(n) complexity
	
	public static int replace(int size, char[] s) {
		int write_idx = 0; int aCount = 0;
		for(int i = 0; i < size; ++i) {
			if(s[i] != 'b') {
				s[write_idx++] = s[i];
			}
			if(s[i] == 'a') {
				++aCount;
			}
		}
		int finalSize = write_idx + aCount;
		int curr_idx = write_idx-1;
		write_idx = finalSize-1;
		
		while(curr_idx >= 0) {
			if(s[curr_idx] == 'a') {
				s[write_idx--] = 'd';
				s[write_idx--] = 'd';
			} else {
				s[write_idx--] = s[curr_idx];
			}
			--curr_idx;
		}
		
		return finalSize;
	}
	
	
	public static void main(String[] args) {
		char[] s = new char[] { 'a', 'c', 'd', 'b', 'b', 'a' }; 
		replace(6, s);
		for(char c : s) {
			System.out.print(c + " ");
		}
	}
	
	private static void test1() {
		List<Character> l = new ArrayList<>(Arrays.asList('a', 'c', 'd', 'b', 'b', 'a'));
		print(l);
		System.out.println();
		print(replaceAndRemove(l));
	}
	private static void print(List<Character> list) {
		for(char c : list) {
			System.out.print(c + " ");
		}
	}
}
