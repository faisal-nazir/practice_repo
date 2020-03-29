package pc.ds.arrays.binarySearch;

public class HIndex02 {

	// https://leetcode.com/problems/h-index-ii/solution/
	public static int search(int[] citations) {
		int s = 0;
		int e = citations.length-1;
		int n = citations.length;
		while(s <= e) {
			int mid = s + (e - s)/2;
			if(citations[mid] == n-mid) return n-mid;
			else if(citations[mid] < n-mid)
				s = mid+1;
			else 
				e = mid-1;
		}
		return n-s; // why n-s?
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {0,1,2,5,6};
		System.out.println(search(A));
	}
}
