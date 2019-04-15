package com.amazon.online;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;

//https://aonecode.com/amazon-online-assessment-questions

/** We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
**/
// using the apporaches described here
// https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.
public class KClosestPointsToOrigin {

	// using TreeMap to have sorted keys
	public int[][] kClosest_01(int[][] points, int K) {
        int[][] closetPoints = new int[K][2];
        Map<Integer, int[]> map = new TreeMap<>();
        for(int[] point : points) {
            Integer key = getDistance(point);
            map.put(key, point);
        }
        Iterator<Map.Entry<Integer, int[]>> itr = map.entrySet().iterator();
        for(int i = 0; i < K; ++i) {
            if(itr.hasNext()) {
                closetPoints[i] = itr.next().getValue();
            }
        }
        return closetPoints;
    }
    
    public int getDistance(int[] point) {
        return (point[0] * point[0] + point[1] * point[1]);
    }
    
    // by sorting input array
    public int[][] kClosest_02(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>(){
        	public int compare(int[] p1, int[] p2) {
        		int dist1 = p1[0] * p1[0] + p1[1] * p1[1];
        		int dist2 = p2[0] * p2[0] + p2[1] * p2[1];
        		return dist1 - dist2;
        	}
        });
        return Arrays.copyOfRange(points, 0, K);
    }
    
    // using heap
    public int[][] kClosest_03(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(points.length, new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
        		int dist1 = p1[0] * p1[0] + p1[1] * p1[1];
        		int dist2 = p2[0] * p2[0] + p2[1] * p2[1];
        		return dist2 - dist1;
        	}
		});
		for(int[] point : points) {
			maxHeap.offer(point);
			if(maxHeap.size() > K) {
				maxHeap.poll();
			}
		}
		int[][] res = new int[K][2];
	    while (K > 0) {
	        res[--K] = maxHeap.poll();
	    }
	    return res;
    }
	
	
}

/** Amazon Fresh
Amazon Fresh is a grocery delivery service that offers consumers the option of purchasing their groceries online and schedule future deliveries of purchased groceries. Amazon's backend system dynamically tracks each Amazon Fresh delivery truck and automatically assigns the next deliveries in a truck's plan. To accomplish this, the system generates an optimized delivery plan with X destinations. The most optimized plan would deliver to the closest X destinations from the start among all of the possible destinations in the plan.

Given an array of N possible delivery destinations, implement an algorithm to create the delivery plan for the closest X destinations.

Input 
The input to the function/method consists of three arguments: 
numDestinations, an integer representing the total number of possible delivery destinations for the truck (N); 
allLocations, a list where each element consists of a pair of integers representing the x and y coordinates of the delivery locations; from aonecode.com
numDeliveries, an integer representing the number of deliveries that will be delivered in the plan (X). 
Output from aonecode.com
Return a list of elements where each element of the list represents the x and y integer coordinates of the delivery destinations.from aonecode.com 

Constraints 
numDeliveries <= numDestinations from aonecode.com

Note
The plan starts from the truck's location [0, 01. The distance of the truck from a delivery destination (x, y) is the square root of x^2 + y^2. If there are ties then return any of the locations as long as you satisfy returning X deliveries.from aonecode.com 

Example 
Input: 
numDestinations = 3 from aonecode.com
allocations = [[1, 2], [3, 4], [1, -1]] 
numDeliveries = 2 from aonecode.com

Output: 
[[1, -1], [1, 2]] from aonecode.com

Explanation: 
The distance of the truck from location [1, 2] is square root(5) = 2.236 from aonecode.com
The distance of the truck from location [3, 4] is square root(25) = 5 
The distance of the truck from location [1, -1] is square root(2) = 1.414 from aonecode.com
numDeliveries is 2, hence the output is [1, -1] and [1, 2]. 


TestCase 1 
Statue: Correctfrom aonecode.com 
Expected: 1 2 from aonecode.com
Returned: 1 2 

Testcane 2 
Status: Correct 
Expected: 2 4 3 6 5 3 from aonecode.com
Returned: 2 4 3 6 5 3 
**/
