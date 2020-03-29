package interview.pro.daily.problem;

public class FindSingleElementInArrayOfDuplicates {

	// [Daily Problem] Find the Single Element in an Array of Duplicates

	public static int searchUniqueElement(int[] values) {
		int res = 0;
		for(int val : values) {
			res ^= val;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] { 7, 3, 1, 5, 4, 3, 4, 8, 8 };
		System.out.println(searchUniqueElement(A));
	}
}
