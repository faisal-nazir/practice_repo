package interview.pro.daily.problem;

public class ProductOfArrayExceptSelf {

	// Time: O(n2) Space: O(1)
	public static int[] product_01(int[] nums) {
		if(nums == null || nums.length <= 1) return nums;
		int[] res = new int[nums.length]; 
		int p = 1;
		for(int i = 0; i < nums.length; ++i) {
			p = 1;
			for(int j = 0; j < nums.length; ++j) {
				if(i != j) {
					p *= nums[j];
				}
			}
			res[i] = p;
		}
		return res;
	}
	
	// Time: O(n) Space: O(n)
	public static int[] product_02(int[] nums) {
		if(nums == null || nums.length <= 1) return nums;
		int[] res = new int[nums.length]; 
		int[] F = new int[nums.length];
		int[] B = new int[nums.length];
		
		F[0] = 1;
		for(int i = 1; i < F.length; ++i) {
			F[i] = nums[i-1] * F[i-1];
		}
		
		B[B.length-1] = 1;
		for(int i = B.length-2; i >= 0; --i) {
			B[i] = nums[i+1] * B[i+1];
		}
		
		for(int i = 0; i < res.length; ++i) {
			res[i] = F[i] * B[i];
		}
		return res;
	}
	
	
	
	// Time: O(n) Space: O(1)
	public static int[] product_03(int[] nums) {
		if(nums == null || nums.length <= 1) return nums;
		int[] res = new int[nums.length]; 
		
		res[0] = 1;
		for(int i = 1; i < res.length; ++i) {
			res[i] = nums[i-1] * res[i-1];
		}
		
		int p = nums[nums.length-1];		
		for(int i = res.length-2; i >= 0; --i) {
			res[i] = res[i]*p;
			p *= nums[i];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5};
		int[] res = product_03(nums);
		print(res);
	}
	
	private static void print(int[] nums) {
		System.out.println();
		for(int num: nums) {
			System.out.print(num + " ");
		}
	}
}
