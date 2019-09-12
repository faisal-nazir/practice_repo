package com.epi.recursion;

import java.util.*;

public class TowerOfHanoi {

	private static final int NO_OF_PEGS = 3;
	
	public static void buildTowerofHanoi(int noOfRings) {
		List<Deque<Integer>> pegs = new ArrayList<>();
		
		for(int i = 0; i < NO_OF_PEGS; ++i) {
			pegs.add(new LinkedList<Integer>());
		}
		
		for(int i = noOfRings; i > 0; --i) {
			pegs.get(0).addFirst(i);
		}
		
		computeSteps(noOfRings, pegs, 0, 1, 2);
	}
	
	private static void computeSteps(int ringsToMove, List<Deque<Integer>> pegs, int src, int dest, int buffer) {
		if(ringsToMove > 0) {
			computeSteps(ringsToMove-1, pegs, src, buffer, dest);
			pegs.get(dest).addFirst(pegs.get(src).removeFirst());
			System.out.println("Moving ring # " + ringsToMove + " from peg # " + src + " to peg # " + dest);
			computeSteps(ringsToMove-1, pegs, buffer, dest, src);
		}
	}
	
	public static void main(String[] args) {
		buildTowerofHanoi(4);
	}
}
