package pc.ds.arrays.twoPointers;

import java.util.LinkedList;
import java.util.List;

public class BinaryWatch {

	// Product close to the description
	// https://www.thinkgeek.com/product/6a17/
	/***
	 * A binary watch has 4 LEDs on the top which represent the hours (0-11),
	 * and the 6 LEDs on the bottom represent the minutes (0-59). Each LED
	 * represents a zero or one, with the least significant bit on the right.
	 * 
	 * Given a non-negative integer n which represents the number of LEDs that
	 * are currently on, return all possible times the watch could represent.
	 * 
	 * Example:
	 * 
	 * Input: n = 1 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02",
	 * "0:04", "0:08", "0:16", "0:32"] Note: The order of output does not
	 * matter. The hour must not contain a leading zero, for example "01:00" is
	 * not valid, it should be "1:00". The minute must be consist of two digits
	 * and may contain a leading zero, for example "10:2" is not valid, it
	 * should be "10:02".
	 */

	// https://leetcode.com/problems/binary-watch/discuss/88465/Straight-forward-6-line-c%2B%2B-solution-no-need-to-explain
	// from 'zzhai' comments
	public List<String> readBinaryWatch(int num) {
		List<String> res = new LinkedList<>();
		for (int h = 0; h < 12; h++)
			for (int m = 0; m < 60; m++)
				// Returns the number of one-bits in the two's complement binary
				// representation of the specified int value.
				// This function is sometimes referred to as the population
				// count.
				if (Integer.bitCount(h) + Integer.bitCount(m) == num)
					res.add(h + (m < 10 ? ":0" : ":") + m);
		return res;
	}

	// https://stackoverflow.com/questions/12380478/bits-counting-algorithm-brian-kernighan-in-an-integer-time-complexity
	public static int count_set_bits(int n) {
		int count = 0; // count accumulates the total bits set
		while (n != 0) {
			n = n &(n - 1); // clear the least significant bit set
			count++;
		}
		return count;
	}
	
	public static int count_ON_bits(int n) {
		int count = 0; // count accumulates the total bits set
		while (n != 0) {
			count += n & 1;
			n = n >> 1;
		}
		return count;
	}
	
	// look at the other backtracking version of the solutions as well.
	// https://leetcode.com/problems/binary-watch/discuss/88456/3ms-Java-Solution-Using-Backtracking-and-Idea-of-%22Permutation-and-Combination%22
	public static void main(String[] args) {
//		for(int n = 1; n <= 4; ++n) {
//			System.out.print("There are " + count_set_bits(n) + " one bits in " + n + ".");
//			System.out.println();
//		}
		System.out.print(count_ON_bits(15));
	}
}
