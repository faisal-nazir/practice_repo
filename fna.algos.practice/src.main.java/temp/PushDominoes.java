package temp;

public class PushDominoes {

//	public static String push(String d) {
//		if(d == null || d.isEmpty()) return d;
//		
//		char[] arr = d.toCharArray();
//		int r = 0;
//		boolean checkLeft = false;
//		
//		while(r < arr.length) {
//			if(arr[r] == 'R') {
//				int curr = r+1;
//				if(curr == arr.length) break;
//				int next = curr+1;
//				while(next < d.length() && arr[next] != 'L') {
//					arr[curr] = 'R';
//					++next;
//					++curr;
//				}
//				r = next;
//			} else if(arr[r] == 'L') {
//			ß	checkLeft = true;
//			}
//			++r;
//		}
//	}
}
