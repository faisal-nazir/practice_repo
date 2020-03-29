package interview.pro.daily.problem;

public class FibonacciNumber {

	// [Daily Problem] Nth Fibonacci Number
	
	public static int fib(int n) {
		if(n <= 0) return 0;
		int a = 0;
		int b = 1;
		for(int i = 2; i < n; ++i) {
			int c = a + b;
			a = b;
			b = c;
		}
		return a + b;
	}
	
	private static int helper(int n, int[] dp) {
		if(n <= 1) return n;
		if(dp[n] == 0)
			dp[n] = helper(n-1, dp) + helper(n-2, dp);
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.print(fib(7));
	}
}
