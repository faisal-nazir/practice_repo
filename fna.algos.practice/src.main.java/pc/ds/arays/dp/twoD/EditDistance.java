package pc.ds.arays.dp.twoD;

import java.util.Arrays;

public class EditDistance {
	/**
	 * Given two words word1 and word2, find the minimum number of operations
	 * required to convert word1 to word2.
	 * 
	 * You have the following 3 operations permitted on a word:
	 * 
	 * Insert a character Delete a character Replace a character Example 1:
	 * 
	 * Input: word1 = "horse", word2 = "ros" Output: 3 Explanation: horse ->
	 * rorse (replace 'h' with 'r') rorse -> rose (remove 'r') rose -> ros
	 * (remove 'e') Example 2:
	 * 
	 * Input: word1 = "intention", word2 = "execution" Output: 5 Explanation:
	 * intention -> inention (remove 't') inention -> enention (replace 'i' with
	 * 'e') enention -> exention (replace 'n' with 'x') exention -> exection
	 * (replace 'n' with 'c') exection -> execution (insert 'u')
	 **/
	/* FNA: This problem is also referred to as 'Levenshtein Distance'

	/*
	 * Authorship: ALL credit for the code in this file goes to the authors of
	 * the book "Elements of Programming Interviews" by Adnan Aziz, Amit
	 * Prakash, and Tsung-Hsien Lee.
	 * 
	 * I have just adapted the solution to pass on Leetcode, added explanatory
	 * comments, reformatted the code, & changed variable names for
	 * understanding.
	 * 
	 * Edit Distance - LeetCode: https://leetcode.com/problems/edit-distance
	 * 
	 * This code passes all Leetcode test cases as of Jan. 10 2019 Runtime: 8ms
	 * (graph distribution was unavaliable)
	 * 
	 * The video to explain this code is here:
	 * https://www.youtube.com/watch?v=MiqoA-yF-0M
	 */

	/*
	 * 1.) Create the dyamic programming table.
	 * 
	 * 2.) Initialize all entries in the table to -1
	 * 
	 * 3.) Begin the computations (going top down in recursion)
	 */
	public static int minDistance(String A, String B) {
		int[][] distanceBetweenPrefixes = new int[A.length()][B.length()];
		for (int[] row : distanceBetweenPrefixes) {
			Arrays.fill(row, -1);
		}
		return computeDistanceBetweenPrefixes(A, A.length() - 1, B,
				B.length() - 1, distanceBetweenPrefixes);
	}

	/*
	 * The dynamic programming table will hold the edit distance between
	 * prefixes of the strings.
	 * 
	 * For example:
	 * 
	 * A: "benyam" B: "ephrem"
	 * 
	 * Then (A_idx, B_idx) entry (3, 2) in the table compares the edit distance
	 * between strings "beny" (index 0 to 3) of A and "eph" (index 0 to 2) of
	 * string B.
	 * 
	 * This is my point, bounds are inclusive. Our goal is to solve the
	 * subproblem (A.length() - 1, B.length() - 1) which is the edit distance
	 * between both full strings
	 */
	private static int computeDistanceBetweenPrefixes(String A, int A_idx,
			String B, int B_idx, int[][] distanceBetweenPrefixes) {
		/*
		 * If the substring of A is from 0 to 0 we have the empty string ""
		 * versus whatever B is. Therefore the edit distance between the two
		 * will be the length of B which is B_indx + 1 since we index off of 0
		 * in programming.
		 * 
		 * The same case is true if the substring of B is from 0 to 0. We just
		 * return the length of the string.
		 */
		if (A_idx < 0) {
			return B_idx + 1;
		} else if (B_idx < 0) {
			return A_idx + 1;
		}

		/*
		 * If the edit distance has not been computed, compute it
		 */
		if (distanceBetweenPrefixes[A_idx][B_idx] == -1) {

			/*
			 * Are the characters equivalent? Then we don't need to perform any
			 * "fix-ups". Just process the edit distance for both strings
			 * without this character since (A_idx, B_idx) will == (A_idx - 1,
			 * B_index - 1).
			 * 
			 * Why? This character is the same between both strings. It will not
			 * do anything to increase the edit distance. So its subproblem
			 * answer is the same as that of both strings without the character:
			 * (A_idx - 1, B_index - 1)
			 */
			if (A.charAt(A_idx) == B.charAt(B_idx)) {
				distanceBetweenPrefixes[A_idx][B_idx] = computeDistanceBetweenPrefixes(
						A, A_idx - 1, B, B_idx - 1, distanceBetweenPrefixes);
			} else {
				/*
				 * Example: Subproblem -> (A_idx, B_idx) -> (3, 2) A: "benyam"
				 * ("beny") B: "ephrem" ("eph") Transform "beny" into "eph"
				 * 
				 * "y" in string A does not match "h" in string B
				 * 
				 * If the characters don't match we have 3 options to fix this
				 * problem:
				 * 
				 * substituteLast: (replace) Transform (A_idx, B_idx) "beny"
				 * into "eph" By transforming (A_idx - 1, B_idx - 1) "ben" into
				 * "ep" And then substituting A's last character ("y") with B's
				 * last character ("h") to make them the same string.
				 * 
				 * addLast: (insert) Transform (A_idx, B_idx) "beny" into "eph"
				 * By transforming (A_idx, B_idx - 1) "beny" into "ep" And then
				 * adding B's last character ("h") to the end of the transformed
				 * A (now "ep") to make them the same string.
				 * 
				 * deleteLast: (delete) Transform (A_idx, B_idx) "beny" into
				 * "eph" By transforming (A_idx - 1, B_idx) "ben" into "eph" And
				 * then we delete A's last character ("y") to make them the same
				 * string
				 * 
				 * Summary: All 3 of these are the ways that we can fix the
				 * character mismatch. We can have many mismatches throughout
				 * the recursion but this forms out "policy" for determining the
				 * answer to a subproblem
				 */
				int substituteLast = computeDistanceBetweenPrefixes(A,
						A_idx - 1, B, B_idx - 1, distanceBetweenPrefixes);
				int addLast = computeDistanceBetweenPrefixes(A, A_idx, B,
						B_idx - 1, distanceBetweenPrefixes);
				int deleteLast = computeDistanceBetweenPrefixes(A, A_idx - 1,
						B, B_idx, distanceBetweenPrefixes);

				/*
				 * We want to take the minimum of these 3 options to fix the
				 * problem (we add 1 to the smallest action because again we are
				 * indexed off 0)
				 */
				distanceBetweenPrefixes[A_idx][B_idx] = 1 + Math.min(
						substituteLast, Math.min(addLast, deleteLast));
			}
		}

		/*
		 * This is the answer to the subproblem we asked. At every level of the
		 * recursion this is the answer to a subproblem.
		 * 
		 * At the top level this is the answer to the original subproblem we
		 * wanted to solve, the answer to (A.length() - 1, B.length() - 1)
		 */
		return distanceBetweenPrefixes[A_idx][B_idx];
	}
	
	public int minDistance_bottomUp(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0)  return n;
        if(n == 0)  return m;
        
        int[][] table = new int[m+1][n+1];
        table[0][0] = 0;
        for(int i=1; i<=m; ++i)
            table[i][0] = i;
        
        for(int j=1; j<=n; ++j)
            table[0][j] = j;
        
        for(int i=1;i<=m; ++i)
            for(int j=1; j<=n; ++j) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.min(table[i - 1][j], Math.min(table[i][j - 1], table[i - 1][j - 1])) + 1;
                }
            }
            
        return table[m][n];
    }
}
