package pc.ds.arrays.sorting;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class WiggleSort02 {

	public static void wiggleSort(int[] A) {
		Arrays.sort(A);
		int i = 0; 
		int j = A.length-1;
		int idx = 0;
		int[] res = new int[A.length];
		while(i < j) {
			res[idx++] = A[i++];
			res[idx++] = A[j--];
		}
		A = res;
		for(int val : res) {
			System.out.println(val + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		//wiggleSort(nums);
		
		Deque<Integer> q = new LinkedList<>();
		for(int n : nums) {
			q.push(n);
		}
		while(!q.isEmpty()) {
			System.out.println(q.pop() + " ");
		}
		
	}
}
