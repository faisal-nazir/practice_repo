package com.epi.searching;

public class SearchInA2DSortedArray {

	
	// EPI-12.6: Search in a sorted 2D array
	
	// O(m+n) complexity where m = rows and n = columns
	// https://leetcode.com/problems/search-a-2d-matrix-ii/
	
	public static boolean searchMatrix(int[][] M, int target) {
		int r = 0, c = M[0].length-1; // starting from top-right corner
		while(r < M.length && c >= 0) {
			if(M[r][c] == target) {
				return true;
			} else if(M[r][c] > target) {
				--c;
			} else { 
				++r;
			}
		}
		return false;
	}
	
	// https://leetcode.com/problems/search-a-2d-matrix/
	// IDEA: https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
	public static boolean search(int[][] A, int target) {
		int r = A.length, c = A[0].length;
		int s = 0, e =  r*c-1;
		while(s <= e) {
			int mid = (s+e) >>> 1;
			if(A[mid/c][mid%c] == target) {
				return true;
			} else if(A[mid/c][mid%c] > target) {
				e = mid-1;
			} else {
				s = mid+1;
			}
		}
		return false;
	}
	
	// https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/806/
	public static boolean searchMatrix_02(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = (rows*cols)-1;
        
        while(start <= end) {
            int mid = (start+end) >>> 1;
            int midValue = matrix[mid/cols][mid%cols];
            System.out.println(midValue);
            if(target == midValue) {
                return true;
            } else if(target < midValue) {
                end = mid-1;
            } else {
                start= mid+1;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { {1,4},{2,5}};
		System.out.println(searchMatrix_02(matrix, 2)? "PRESENT" : "ABSENT");
	}
}
