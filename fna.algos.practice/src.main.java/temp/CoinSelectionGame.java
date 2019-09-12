package temp;

public class CoinSelectionGame {

	public static int getMaxScore(int[] coins) {
		return helper(coins, 0, coins.length-1);
	}
	
	private static int helper(int[] coins, int a , int b) {
		System.out.println("idx_a = " + a + " , " + "idx_b = " + b);
		if(a >= b) return 0;
		
		int A = coins[a] + getSum(coins, a+1,b) - helper(coins, a+1, b);
		int B = coins[b] + getSum(coins, a,b-1) - helper(coins, a, b-1);
		
		System.out.println("A = " + a + " , " + "B = " + B);
//		return Math.max(coins[a] + getSum(coins, a+1,b) - helper(coins, a+1, b),
//				coins[b] + getSum(coins, a,b-1) - helper(coins, a, b-1));
		return Math.max(A, B);
				
	}
	
	private static int getSum(int[] arr, int a, int b) {
		if(a < 0 || b < 0 || a > arr.length-1 || b > arr.length-1) return 0;
		int res= 0;
		for(int i = a; i <= b; ++i) {
			res += arr[i];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] coins = new int[]{ 5, 25, 10 , 1};
		System.out.println(getMaxScore(coins));
		
	}
}
