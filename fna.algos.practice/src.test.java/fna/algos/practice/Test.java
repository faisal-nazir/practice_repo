package fna.algos.practice;
import java.util.Arrays;

public class Test {
	
	// Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] ranks = new int[alice.length];
        Arrays.sort(scores);
        int si = 1;
        for(int i = 1; i < scores.length; ++i) {
        	if(scores[i-1] != scores[i])
        		scores[si++] = scores[i];
        }
        int n = si + 1;
        for(int i = 0; i < ranks.length; ++i) {
        	int key = alice[i];
        	int j = Arrays.binarySearch(scores, 0, si, key);
//            int j = Arrays.binarySearch(d_scores, si, key);
            if(j < 0) {
            	j = ((-j)-1);
            	ranks[i] = n - j;
            }
             
        }
        return ranks;
    }
    
    public static void main(String[] args) {
    	int[] scores = { 100,100, 50,40, 40, 20, 10 };
    	int[] alice = {5, 25, 50, 120};
//    	int[] res = climbingLeaderboard(scores, alice);
//    	for(int i : res) {
//    		System.out.print(i + ",");
//    	}
    	climbingLeaderboard_03(scores, alice);
    }
    
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard_02(int[] scores, int[] alice) {
        
        int[] ranks = new int[scores.length];
        int[] alice_rankings = new int[alice.length];

        int r = 1;
        ranks[0] = r;
        for(int i = 1; i < scores.length; ++i) {
            if(scores[i-1] != scores[i]) {
                r++;
            } 
            ranks[i] = r;
        }
        r = ranks[ranks.length-1] + 1;
        
        for(int i = 0; i < alice.length; ++i) {
        	int j = scores.length-i-1;	
            while(j > 0 && scores[j] < alice[i]) {
            	--j;
            }
//            if(alice[i] < scores[scores.length-1]) {
//            	alice_rankings[i] = r;
//            } else {
//            	alice_rankings[i] = ranks[j];
//            	continue;
//            }
            if(j == scores.length-1) {
            	alice_rankings[i] = r;
            } else {
            	alice_rankings[i] = ranks[j+1];
            	continue;
            }
            
        }
        return alice_rankings;
    }
    
    static void climbingLeaderboard_03(int[] scores, int[] alice) {
    	
    	//int[] result = new int[alice.length];
    	int n = scores.length;
    	int m = alice.length;
    	int maxRank = 1;
        for (int i = 1; i < n; i++) {
            if (scores[i] != scores[i - 1]) {
                maxRank++;
            }
        }
	    int rank = maxRank + 1;
	    int cursor = n - 1;
	    for (int a = 0; a < m; a++) {
	        while (cursor >= 0 && alice[a] >= scores[cursor]) {
	            boolean flag = false;
	            do {
	                cursor--;
	                if (!flag) {
	                    rank = Math.max(1, rank - 1);
	                    flag = true;
	                }
	            } while (cursor > 0 && scores[cursor + 1] == scores[cursor]);
	        }
	
	        System.out.println(rank);
	    }
    }
}
