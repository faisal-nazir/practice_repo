package interview.pro.daily.problem;

public class ShiftedStrings {

	// https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/
	public static boolean inShifted(String A, String B) {
		if(A == null || B == null) return false;
		if(A.length() != B.length()) return false;
		
		String temp = A+A;
		return temp.indexOf(B) != -1;
	}
}
