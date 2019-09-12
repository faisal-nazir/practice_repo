package com.epi.recursion;

import java.util.*;

public class GeneratePemutations {

	public static List<String> permutations(String input) {
		List<String> perms = new ArrayList<>();
		getPerms(input.toCharArray(), 0, perms);
		return perms;
	}
	
	private static void getPerms(char[] input, int idx, List<String> perms) {
		if(idx == input.length) {
			perms.add(getString(input));
		}
		for(int i = idx; i < input.length; ++i) {
			swap(input, idx, i);
			getPerms(input, idx+1, perms);
			swap(input, i, idx);
		}
	}
	
	private static void swap(char[] arr, int i, int j) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}
		
	private static String getString(char[] arr) {
		StringBuilder sb = new StringBuilder();
		for(char c : arr) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String input = "abc";
		List<String> permutations = permutations(input);
		for(String s : permutations) {
			System.out.println(s);
		}
	}
}
