package pc.ds.arrays.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

	public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        
        print(pre);
        print(count);
        
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] A = { 2, 4, 7, 8, 9, 14, 16};
		List<Integer> res = largestDivisibleSubset(A);
		print(res);
	}
	
	private static void print(List<Integer> values) {
		for(int val : values) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
	
	private static void print(int[] values) {
		for(int val : values) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
