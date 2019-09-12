package com.epi.recursion;

import java.util.*;

public class NQueens {

	// EPI-16.2: GENERATE ALL NONATTACKING PLACEMENTS OF n-Queens
	
	public static List<List<Integer>> placeQueens(int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> colPlacements = new ArrayList<>();
		helper(n, 0, colPlacements, res);
		return res;
	}
	
	public static void helper(int n, int row, List<Integer> colPlacements, List<List<Integer>> res) {
		if(row == n) {
			res.add(new ArrayList<>(colPlacements));
		} else {
			for(int i = 0; i < colPlacements.size(); ++i) {
					colPlacements.add(i);
					if(isValidPlacement(colPlacements)) {
						helper(n, row+1, colPlacements, res);
					}
					colPlacements.remove(colPlacements.size()-1);
			}
		}
	}
	
	public static boolean isValidPlacement(List<Integer> colPlacements) {
		int rowID = colPlacements.size()-1;
		for(int i = 0; i < rowID; ++i) {
			int absColDiff = Math.abs(colPlacements.get(i) - colPlacements.get(rowID));
			
			if(absColDiff == 0 || absColDiff == rowID - i)
				return false;
		}
		return true;
		
	}
}
