package pc.ds.arrays.twoPointers;

public class ShortestWordDistance_I {

	/**
	 * Given a list of words and two words word1 and word2, return the shortest
	 * distance between these two words in the list. For example, Assume that
	 * words = ["practice", "makes", "perfect", "coding", "makes"]. Given word1
	 * = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 =
	 * "coding", return 1.
	 */

	// https://leetcode.com/problems/shortest-word-distance/discuss/66931/AC-Java-clean-solution
	public int shortestDistance_01(String[] words, String word1, String word2) {
		int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				p1 = i;

			if (words[i].equals(word2))
				p2 = i;

			if (p1 != -1 && p2 != -1)
				min = Math.min(min, Math.abs(p1 - p2));
		}

		return min;
	}

	// https://leetcode.com/problems/shortest-word-distance/discuss/66973/Java-Solution-with-one-for-loop
	public int shortestDistance_02(String[] words, String word1, String word2) {
		int ret = Integer.MAX_VALUE, index1 = -1, index2 = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				index1 = i;
				if (index2 >= 0)
					ret = Math.min(ret, i - index2);
			} else if (words[i].equals(word2)) {
				index2 = i;
				if (index1 >= 0)
					ret = Math.min(ret, i - index1);
			}
		}
		return ret;
	}
}
