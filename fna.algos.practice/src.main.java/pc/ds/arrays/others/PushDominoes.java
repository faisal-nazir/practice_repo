package pc.ds.arrays.others;

public class PushDominoes {

	
	// https://leetcode.com/problems/push-dominoes/discuss/132482/Java-one-pass-in-place-13ms
	public static String push(String s) {
		char[] a = s.toCharArray();
		int L = -1, R = -1; // record index for 'R' and 'L'
		for(int i = 0; i <= a.length; ++i) {
			if(i == a.length || a[i] == 'R') {
				if(L < R) { // R...R
					while(R < i)
						a[++R] = 'R';
				}
				R = i;
			} else if(a[i] == 'L') {
				if((L > R) || (L == -1 && R == -1)) { // L...L
					while(++L < i)
						a[L] = 'L';
				} else { // R...L
					L = i;
					
					int lo = R+1;
					int hi = L-1;
					while(lo < hi) {
						a[lo++] = 'R';
						a[hi--] = 'L';
					}
				}
			}
		}
		
		return new String(a);
	}
}
