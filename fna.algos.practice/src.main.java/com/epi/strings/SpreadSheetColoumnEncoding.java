package com.epi.strings;

public class SpreadSheetColoumnEncoding {

	
	public static int decode(String id) {
		int res = 0;
		for(char c : id.toCharArray()) {
			res = res * 26 + c - 'A' + 1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] arr = {"A", "B", "Y" , "Z", "AA", "AB", "ZZ" };
		for(String s : arr) {
			System.out.println(decode(s));
		}
	}
}
