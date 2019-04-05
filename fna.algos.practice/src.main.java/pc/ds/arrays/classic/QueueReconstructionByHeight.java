package pc.ds.arrays.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {
	
	/** Suppose you have a random list of people standing in a queue. Each person is described 
	 * by a pair of integers (h, k), where h is the height of the person 
	 * and k is the number of people in front of this person who have a height greater than or equal to h. 
	 * Write an algorithm to reconstruct the queue.

		Note:
		The number of people is less than 1,100.
			
		Example
		
		Input:
		[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
		
		Output:
		[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	**/

	// https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC%2B%2BJava-Solution
	// https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89350/Java-solution-using-Arrays.sort()-and-%22insert-sorting%22-idea
	public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
            
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        
        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        
        return tmp.toArray(new int[people.length][2]);

//        int[][] res = new int[people.length][2];
//        int i = 0;
//        for (int[] k : tmp) {
//            res[i][0] = k[0];
//            res[i++][1] = k[1];
//        }
//        
//        return res;
    }
	
	static public void main(String[] args) {
		int[][] input  = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] result = reconstructQueue(input);
		System.out.print("Input : ");
		print(input);
		System.out.println("Result : ");
		print(result);
	}
	
	public static void print(int[][] arr) {
		System.out.print("{ ");
		for(int[] a : arr) {
			System.out.print("{" + a[0] + "," + a[1] + "}" + ",");
		}
		System.out.print(" }");
	}
}
