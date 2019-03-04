package ctci.recursion.dp;

public class TripleStep {
	
	public static int countWays(int n) {
		if(n < 0) return 0;
		if(n == 0) return 1;
		return countWays(n-1) + countWays(n-2) + countWays(n-3);
	}
	
	public static int bottomUp(int n) {
		if(n < 0) return 0;
		int[] count = new int[n+1];
		count[0] = 1; count[1] = 1; count[2] = 2;
		for(int i = 3; i < n+1; ++i) {
			count[i] = count[i-1] + count[i-2] + count[i-3];
		}
		return count[n];
	}
	public static void main(String[] args) {
		System.out.println(countWays(5));
		System.out.println(bottomUp(5));
	}
}
