package temp;

import java.util.*;

public class WordSearch {

	// https://leetcode.com/problems/word-search/
	
	public static boolean search(String word, List<List<Character>> grid) {
		if(grid == null || grid.size() == 0) return false;
		if(word.length() == 0) return true;
		List<List<Boolean>> visited = new ArrayList<>();
		for(int i = 0; i < grid.size(); ++i) {
			List<Boolean> list = new ArrayList<Boolean>();
			for(int j = 0; j < grid.get(i).size(); ++j) {
				list.add(false);
			}
			visited.add(list);
		}
		for(int i = 0; i < grid.size(); ++i) {
			for(int j = 0; j < grid.get(i).size(); ++j) {
				if(word.charAt(0) == grid.get(i).get(j)) {
					if(exist(word, 0, i, j, grid, visited)) 
						return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean exist(String word, int idx, int row, int col, List<List<Character>> grid, List<List<Boolean>> visited) {
		if(idx == word.length()) {
			return true;
		}
		if(row < 0 || col < 0 || row >= grid.size() || col >= grid.get(row).size() || word.charAt(idx) != grid.get(row).get(col))
			return false;
		
		if(visited.get(row).get(col))
			return false;
		
		visited.get(row).set(col, true);
		System.out.println(row + " , " + col + " , " + idx + " , " + word.length());
		boolean result = exist(word, idx+1, row-1, col, grid, visited) ||
				exist(word, idx+1, row, col-1, grid, visited) ||
				exist(word, idx+1, row+1, col, grid, visited) ||
				exist(word, idx+1, row, col+1, grid, visited);
		visited.get(row).set(col, false);
		return result;
	}
	
	public static void main(String[] args) {
		String word = "ABCCED";
		String word2 = "ABCB";
		System.out.print(search(word2, getGrid()));
	}
	
	private static List<List<Character>> getGrid() {
		List<Character> first = Arrays.asList(new Character[] {'A','B','C','E'});
		List<Character> second = Arrays.asList(new Character[] {'S','F','C','S'});
		List<Character> third = Arrays.asList(new Character[] {'A','D','E','E'});
		
		List<List<Character>> grid = new ArrayList<>();
		grid.add(first);
		grid.add(second);
		grid.add(third);
		
		return grid;
		
		/** 
		 * This case is not working :(
		 * [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
			"ABCB"
		 **/
		 
	}
}
