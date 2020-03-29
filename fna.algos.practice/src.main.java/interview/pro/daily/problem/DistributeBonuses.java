package interview.pro.daily.problem;

import java.util.Arrays;

public class DistributeBonuses {

	// https://leetcode.com/problems/candy/
	// [Daily Problem] Distribute Bonuses
	
	public static int[] distribute(int[] ratings) {
		if(ratings == null || ratings.length == 0) return ratings;
		int[] bonuses = new int[ratings.length];
		Arrays.fill(bonuses, 1);
		
		for(int i = 1; i < ratings.length; ++i) {
			if(ratings[i] > ratings[i-1])
				bonuses[i] = bonuses[i-1]+1;
		}
		
		for(int j = ratings.length-1; j > 0; j--) {
			if(ratings[j-1] > ratings[j] )
				bonuses[j-1] = Math.max(bonuses[j-1], bonuses[j]+1);
		}
		
		return bonuses;
	}
	
	public static void main(String[] args) {
		int[] ratings = new int[] {1, 2, 3, 2, 3, 5, 1};
//		int[] ratings = new int[] {1,0,2};
		
		int[] bonuses = distribute(ratings);
		for(int bonus: bonuses) {
			System.out.print(bonus + " ");
		}
	}
}
