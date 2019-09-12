package temp;

import java.util.*;

public class GrayCode_01 {
	public static List<Integer> getGrayCode(int numOfBits) {
		List<Integer> res = new ArrayList<>(Arrays.asList(0));
		solve(numOfBits, new HashSet<Integer>(Arrays.asList(0)), res);
		return res;
	}
	
	private static boolean solve(int numOfBits, HashSet<Integer> set, List<Integer> res) {
		if( 1 << numOfBits == res.size()) {
			return differByOne(res.get(0), res.get(res.size()-1));
		}
		
		for(int i = 0; i < numOfBits; i ++) {
			int previousCode = res.get(res.size()-1);
			int nextCandidateCode = previousCode ^ (1 << i);
			System.out.println("Previous Code: " + previousCode + " and Next Candidate Code: " + nextCandidateCode);
			if(!set.contains(nextCandidateCode)) {
				set.add(nextCandidateCode);
				res.add(nextCandidateCode);
				System.out.println("Adding Previous Code: " + previousCode + " and Next Candidate Code: " + nextCandidateCode + " to the result set");
				if(solve(numOfBits, set, res)) {
					return true;
				}
				set.remove(nextCandidateCode);
				res.remove(res.size()-1);
				System.out.println("Removing Previous Code: " + previousCode + " and Next Candidate Code: " + nextCandidateCode + " from the result set");
			}
		}
		
		return false;
	}
	
	private static boolean differByOne(int x, int y) {
		int bitDiff = x ^ y;
		return bitDiff != 0 && (bitDiff & (bitDiff-1)) == 0; 
	}
	
	public static void main(String[] args) {
		int num = 3;
		List<Integer> res = getGrayCode(num);
		for(int i : res) {
			System.out.print(i + " ");
		}
	}
}
