package temp;

public class KMP_Substring {

	public static int search(String s, String p) {
		int idx=-1;
		int[] A = new int[p.length()];
		// adsbcads
		
		int i = 0;
		int j = i+1;
		while (j < A.length) {
			if(p.charAt(i) == p.charAt(j)) {
				A[j] = i + 1;
				i++;
			} else {
				i = 0;
			}
			j++;
		}
		print(A);
		return -1;
	}
	
	private static void print(int[] A) {
		for(int i = 0; i < A.length; ++i) {
			System.out.print(A[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		search("abc", "dsgwadsgz");
	}
}
