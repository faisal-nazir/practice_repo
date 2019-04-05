package pc.ds.arrays.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/** Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

	Only one letter can be changed at a time.
	Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
	Note:
	
	Return 0 if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.
	You may assume no duplicates in the word list.
	You may assume beginWord and endWord are non-empty and are not the same.
	Example 1:
	
	Input:
	beginWord = "hit",
	endWord = "cog",
	wordList = ["hot","dot","dog","lot","log","cog"]
	
	Output: 5
	
	Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
	Example 2:
	
	Input:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log"]
	
	Output: 0
	
	Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
**/

public class WordLadder_I {
	// https://leetcode.com/problems/word-ladder/discuss/40728/Simple-Java-BFS-solution-with-explanation
	// check the above link for commentary
	// [FNA]: Classic implementation of BFS, using size variable to keep track of the level
	// when time permits, explore other version of the solution with two-directional BFS
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	    wordList.add(endWord);
	    Queue<String> queue = new LinkedList<String>();
	    queue.add(beginWord);
	    int level = 0;
	    while(!queue.isEmpty()){
	        int size = queue.size();
	        for(int i = 0; i < size; i++){
	            String cur = queue.remove();
	            if(cur.equals(endWord)){ return level + 1;}
	            for(int j = 0; j < cur.length(); j++){
	                char[] word = cur.toCharArray();
	                for(char ch = 'a'; ch < 'z'; ch++){
	                    word[j] = ch;
	                    String check = new String(word);
	                    if(!check.equals(cur) && wordList.contains(check)){
	                        queue.add(check);
	                        wordList.remove(check);
	                    }
	                }
	            }
	        }
	        level++;
	    }
	    return 0;
	}
}

