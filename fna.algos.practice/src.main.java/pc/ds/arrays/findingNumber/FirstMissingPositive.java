package pc.ds.arrays.findingNumber;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i)
			while (a[i] > 0 && a[i] <= n && a[a[i] - 1] != a[i])
				swap(a, i, a[i] - 1);

		for (int i = 0; i < n; ++i)
			if (a[i] != i + 1)
				return i + 1;

		return n + 1;
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void main(String[] args) {
		int[] input = {1,3,0};
		System.out.println(firstMissingPositive(input));
		input = new int[]{ -1, -2, 3,1 };
		System.out.println(firstMissingPositive(input));
		input = new int[] { 7,9,10, 11 };
		System.out.println(firstMissingPositive(input));
		input = new int[] { 3,4,-1,1 };
		System.out.println(firstMissingPositive(input));
	}
}
