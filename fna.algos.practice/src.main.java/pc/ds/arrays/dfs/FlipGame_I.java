package pc.ds.arrays.dfs;

import java.util.ArrayList;
import java.util.List;

public class FlipGame_I {

	/**
	 * You are playing the following Flip Game with your friend: Given a string
	 * that contains only these two characters: + and -, you and your friend
	 * take turns to flip two consecutive "++" into "--". The game ends when a
	 * person can no longer make a move and therefore the other person will be
	 * the winner.
	 * 
	 * Write a function to compute all possible states of the string after one
	 * valid move.
	 * 
	 * Example:
	 * 
	 * Input: s = "++++" Output: [ "--++", "+--+", "++--" ]
	 **/

	public List<String> generatePossibleNextMoves(String s) {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
				list.add(s.substring(0, i - 1) + "--"
						+ s.substring(i + 1, s.length()));
			}
		}
		return list;
	}
}
