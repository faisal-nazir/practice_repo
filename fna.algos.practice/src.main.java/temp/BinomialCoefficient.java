package temp;

public class BinomialCoefficient {

	// EPI - 17.4
	
	public static int getBinomialCoefficient(int n, int k) {
		int[][] table = new int[n+1][k+1];
		return compute(n, k, table);
	}
	
	private static int compute(int n, int k, int[][] table) {
		if(k == 0 || n == k) return 1;
		if(table[n][k] == 0) {
			int withSelection = compute(n-1, k-1, table);
			int withOutSelection = compute(n-1, k, table);
			table[n][k] = withSelection + withOutSelection;
		}
		return table[n][k];
	}
	
	public static void main(String[] args) {
		int n = 5; int k = 2;
		System.out.print(getBinomialCoefficient(n,k));
	}
}
