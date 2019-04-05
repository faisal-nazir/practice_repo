package pc.ds.arrays.binarySearch;

public class GuessNumberHigherOrLower {

	/**
	 * We are playing the Guess Game. The game is as follows:
	 * 
	 * I pick a number from 1 to n. You have to guess which number I picked.
	 * 
	 * Every time you guess wrong, I'll tell you whether the number is higher or
	 * lower.
	 * 
	 * You call a pre-defined API guess(int num) which returns 3 possible
	 * results (-1, 1, or 0):
	 * 
	 * -1 : My number is lower 1 : My number is higher 0 : Congrats! You got it!
	 * Example :
	 * 
	 * Input: n = 10, pick = 6 Output: 6
	 **/

	// https://www.programcreek.com/2014/07/leetcode-guess-number-higher-or-lower-java/
	private static final int luckyNumber = 10;

	public static int guessNumber(int n) {
		int low = 1;
		int high = n;

		while (low <= high) {
			int mid = low + ((high - low) / 2);
			int result = guess(mid);
			if (result == 0) {
				return mid;
			} else if (result == 1) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static int guess(int x) {
		return (x == luckyNumber) ? 0 : (x < luckyNumber) ? -1 : 1;
		// return x - luckyNumber;
	}

	public static void main(String[] args) {
		System.out.print(guessNumber(10));
	}
}
