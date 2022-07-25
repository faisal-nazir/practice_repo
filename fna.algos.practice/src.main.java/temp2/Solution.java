package temp2;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) {
		Integer[] arr = { 1, 4, 5, 6, 7, 3, 2 };
		Arrays.sort(arr, (a, b) -> b-a);
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}	
}
