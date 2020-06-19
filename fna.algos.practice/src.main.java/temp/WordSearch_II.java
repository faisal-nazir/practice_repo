package temp;

import java.util.ArrayList;
import java.util.List;

public class WordSearch_II {

	public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList();
        if(board == null || board.length == 0 || words == null || words.length == 0) 
            return res;
        
        TrieNode root = buildTrie(words);
        
        int R = board.length;
        int C = board[0].length;
        
        
        for(int i = 0; i < R; ++i) {
            for(int j = 0; j < C; ++j) {
                search(i, j, root, words, board, res);
            }
        }
        
        return res;
    }
    
    private static void search(int i, int j, TrieNode root, String[] words, char[][] board, List<String> res) {
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        
        char t = board[i][j];
        
        if(t == '*') return;
        if(root == null || root.children[pos(t)] == null) return;
        
        TrieNode itr = root.children[pos(t)];
        if(itr.position != -1) { // found a word
            res.add(words[itr.position]);
            itr.position = -1; // de-duplicate result list by using one time trie
        } 
        
        board[i][j] = '*';

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        for(int k = 0; k < 4; ++k) {
            int ni = i + dy[k];
            int nj = j + dx[k];
            
            search(ni, nj, itr, words, board, res);
        }
        
        board[i][j] = t;    
    }
    
    private static TrieNode buildTrie(String[] words) {
        if(words == null) return null;
        
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; ++i) {
            
            TrieNode itr = root;
            for(char c : words[i].toCharArray()) {
                if(itr.children[pos(c)] == null) {
                    itr.children[pos(c)] = new TrieNode();
                }
                itr = itr.children[pos(c)];
            }
            itr.position = i;
        }
        return root;
    }
    
    private static int pos(char c) {
        return c - 'a';
    }
    
    static class TrieNode {
        int position;
        TrieNode[] children;
        
        TrieNode() {
            position = -1;
            children = new TrieNode[26];
        }
    }
    
    public static void main(String[] args) {
    	char[][] board = {{'o','a','a','n'},
    					{'e','t','a','e'},
    					{'i','h','k','r'},
    					{'i','f','l','v'}};
    	
    	String[] words = {"oath","pea","eat","rain"};
    	
    	List<String> res = findWords(board, words);
    	print(res);
    	
    }
    	
    public static void print(List<String> res) {
    	for(String val : res) {
    		System.out.println(val);
    	}
    }
    					
    					
}
    
    
    
    
    
    

