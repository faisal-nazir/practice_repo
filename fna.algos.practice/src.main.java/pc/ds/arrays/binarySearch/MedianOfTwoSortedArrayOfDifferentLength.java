package pc.ds.arrays.binarySearch;

public class MedianOfTwoSortedArrayOfDifferentLength {

	/**
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

		Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
		
		You may assume nums1 and nums2 cannot be both empty.
		
		Example 1:
		
		nums1 = [1, 3]
		nums2 = [2]
		
		The median is 2.0
		Example 2:
		
		nums1 = [1, 2]
		nums2 = [3, 4]
		
		The median is (2 + 3)/2 = 2.5
	 **/
	
	//https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
	public double findMedianSortedArrays_01(int input1[], int input2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays_01(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

//    public static void main(String[] args) {
//        int[] x = {1, 3, 8, 9, 15};
//        int[] y = {7, 11, 19, 21, 18, 25};
//
//        MedianOfTwoSortedArrayOfDifferentLength mm = new MedianOfTwoSortedArrayOfDifferentLength();
//        mm.findMedianSortedArrays(x, y);
//    }
    
	
	// https://www.algorithmsandme.com/find-kth-smallest-element-in-two-sorted-arrays/
    public static double findKthSmallestElement(int[] A, int[] B, int k){
    	 
 
        int lenA = A.length;
        int lenB = B.length;
 
        if(lenA + lenB < k) return -1;
 
        int iMin = 0;
        int iMax = Integer.min(A.length, k-1);
 
        int i = 0;
        int j = 0;
 
        while (iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = k - 1 - i; // because of zero based index
            /*if (B[j - 1] > A[i])*/ if (i < lenA && B[j - 1] > A[i]) {
                // i is too small, must increase it
                iMin = i + 1;
            } else if (i > 0 && A[i - 1] > B[j]) {
                // i is too big, must decrease it
                iMax = i - 1;
            } else {
                // i is perfect
               return Integer.min(A[i], B[j]);
            }
        }
        return -1;
    }
 
    public static void main(String[] args){
//        int[] a = {1,3,5,6,7,8,9,11};
//        int[] b = {1,4,6,8,12,14,15,17};
        
        int[] a = {1,2,3,4,5}; // this case is not working
        int[] b = {6,7,8,9,10};
 
        double smallest = findKthSmallestElement(a,b, 6);
        System.out.println("Kth smallest element is : " + smallest);
    }
    
    //<01/29/2019>
    // https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn))-solution-with-explanation
    // Accepted submission on leetcode
    public double findMedianSortedArrays_02(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        if(m > n){
            return findMedianSortedArrays_02(B, A);
        }
        int minIndex = 0, maxIndex = m, halfLen = (m + n + 1) / 2;
        int maxLeft, minRight;
        while(minIndex <= maxIndex){
            int i = (minIndex + maxIndex) / 2;
            int j = halfLen - i;
            if(i < m && B[j - 1] > A[i]){
                minIndex = i + 1;
            } else if(i > 0 && A[i - 1] > B[j]){
                maxIndex = i - 1;
            } else{
                if(i == 0){
                    maxLeft = B[j - 1];
                } else if(j == 0){
                    maxLeft = A[i - 1];
                } else{
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if((m + n) % 2 == 1){
                    return maxLeft;
                }
                if(i == m){
                    minRight = B[j];
                } else if(j == n){
                    minRight = A[i];
                } else{
                    minRight = Math.min(A[i], B[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }
}
    

