package pc.ds.trees;

/** Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
**/
public class UniqueBSTs_I {

	// https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
	// [FNA]
	// picture the hierarchy in the expression it self
	// how G(n) and F(i,n) are related
	// then the code would be easier to understand.
	private static int numTrees(int n) {
		int[] G = new int[n + 1];
		G[0] = G[1] = 1;

		for (int i = 2; i <= n; ++i) {
			System.out.println("For G(" + i + ")");
			for (int j = 1; j <= i; ++j) {
				G[i] += G[j - 1] * G[i - j];
				System.out.println("F(" + j + ")" + " = " + G[j - 1] * G[i - j]);
			}
			System.out.println("For G(" + i + ")" + " = " + G[i]);
		}
		System.out.println("Result = " + G[n]);
		return G[n];
	}

	// recursive approach
	public int numTrees2(int n) {
		return trees(1, n);
	}

	int trees(int lo, int hi) {
		if (lo >= hi)
			return 1;
		int total = 0;
		for (int i = lo; i <= hi; i++)
			total += trees(lo, i - 1) * trees(i + 1, hi);
		return total;
	}

	public static void main(String[] args) {
		System.out.print(numTrees(3));
	}
}
