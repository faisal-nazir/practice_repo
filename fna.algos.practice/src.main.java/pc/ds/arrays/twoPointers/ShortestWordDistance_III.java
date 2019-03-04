package pc.ds.arrays.twoPointers;

public class ShortestWordDistance_III {
	/**
	 * 	This is a follow-up problem of Shortest Word Distance.
	 *  The only difference is now word1 could be the same as word2.

		Given a list of words and two words word1 and word2, 
		return the shortest distance between these two words in the list.
		word1 and word2 may be the same and they represent two individual words in the list.
		
		For example,
		Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
		Given word1 = “makes”, word2 = “coding”, return 1.
		Given word1 = "makes", word2 = "makes", return 3.
	 */
	
	int shortestWordDistance_01(String[] words, String word1, String word2) {
        int n = words.length;
        boolean wordsAreEqual = word1.equals(word2);
        int p1 = -1, p2 = -1, dist = Integer.MAX_VALUE;
        for(int i=0; i<n; ++i){
            if(wordsAreEqual){
                if(word1.equals(words[i])){
                    if(p1>p2) p2 = i;
                    else p1 = i;
                }
            }else{
                if(word1.equals(words[i])) p1 = i;
                if(word2.equals(words[i])) p2 = i;
            }
            if(p1>=0 && p2>=0)
                dist = Math.min(dist, Math.abs(p1-p2));
        }
        return dist;
    }
	
	// https://leetcode.com/problems/shortest-word-distance-iii/discuss/67097/12-16-lines-Java-C%2B%2B
	public int shortestWordDistance_02(String[] words, String word1, String word2) {
	    long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
	    boolean same = word1.equals(word2);
	    for (int i=0; i<words.length; i++) {
	        if (words[i].equals(word1)) {
	            if (same) {
	                i1 = i2;
	                i2 = i;
	            } else {
	                i1 = i;
	            }
	        } else if (words[i].equals(word2)) {
	            i2 = i;
	        }
	        dist = Math.min(dist, Math.abs(i1 - i2));
	    }
	    return (int) dist;
	}
}
