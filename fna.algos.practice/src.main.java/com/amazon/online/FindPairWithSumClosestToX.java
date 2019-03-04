package com.amazon.online;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// similar to following problem
//https://www.geeksforgeeks.org/given-sorted-array-number-x-find-pair-array-whose-sum-closest-x/
public class FindPairWithSumClosestToX {

	public static List<int[]> getOptimalRoutes(List<int[]> forwardRoutes, List<int[]> returnRoutes, int maxDistance) {
		List<int[]> optimalRoutes = new ArrayList<int[]>();
		int max = Integer.MIN_VALUE; int dist = 0;
		
//		Collections.sort(forwardRoutes, new DistanceComparator());
//		Collections.sort(returnRoutes, new DistanceComparator());
		
		int l = 0, r = returnRoutes.size()-1;
		while(l < forwardRoutes.size() && r >= 0) {
			int[] f = forwardRoutes.get(l);
			int[] b = returnRoutes.get(r);
			dist = f[1] + b[1];
			if(dist <= maxDistance) {
				l++;
				
				if(dist > max) {
					optimalRoutes.clear();
					optimalRoutes.add(new int[] { f[0], b[0] });
					max = dist;
				} 
				else if(dist == max) {
					optimalRoutes.add(new int[] { f[0], b[0] });
				}
				
			} else /*if(dist > maxDistance)*/ {
				r--;
			}
//			else {
//				optimalRoutes.add(new int[] { f[0], b[0] });
//				max = dist;
//				l++;
//				r--;
//			}
		}
		return optimalRoutes;
	}
	
	private static class DistanceComparator implements Comparator<int[]> {
		public int compare(int[] r1, int[] r2) {
			int dis1 = r1[1];
			int dis2 = r2[1];
			return (dis1 < dis2)? -1 : (dis1 == dis2)? 0 : 1;
		}
	}
	
	public static void main(String[] args) {
		List<int[]> forwardRoutes = new ArrayList<int[]>();
		forwardRoutes.add( new int[] { 1, 3000 });
		forwardRoutes.add( new int[] { 2, 5000 });
		forwardRoutes.add( new int[] { 3, 7000 });
		forwardRoutes.add( new int[] { 4, 10000 });
		
		List<int[]> returnRoutes = new ArrayList<int[]>();
		returnRoutes.add( new int[] { 1, 2000 });
		returnRoutes.add( new int[] { 2, 3000 });
		returnRoutes.add( new int[] { 3, 4000 });
		returnRoutes.add( new int[] { 4, 5000 });
		
		int maxTravelDist = 10000;
		
		List<int[]> optimalRoutes = getOptimalRoutes(forwardRoutes, returnRoutes, maxTravelDist);
		
		for(int[] optRoute : optimalRoutes) {
			System.out.println("[ " + optRoute[0] + "," + optRoute[1] + " ]");
		}
		
	}
}

/** Amazon Prime Air Shipping Routes
Amazon Prime Air is developing a system that divides shipping routes using flight optimization routing systems to a cluster of aircraft that can fulfill these routes. Each shipping route is identified by a unique integer identifier, requires a fixed non-zero amount of travel distance between airports, and is defined to be either a forward shipping route or a return shipping route. Identifiers are guaranteed to be unique within their own route type, but not across route types. from aonecode.com

Each aircraft should be assigned two shipping routes at once: one forward route and one return route. Due to the complex scheduling of flight plans, all aircraft have a fixed maximum operating travel distance, and cannot be scheduled to fly a shipping route that requires more travel distance than the prescribed maximum operating travel distance. The goal of the system is to optimize the total operating travel distance of a given aircraft. A forward/return shipping route pair is considered to be "optimal" if there does not exist another pair that has a higher operating travel distance than this pair, and also has a total less than or equal to the maximum operating travel distance of the aircraft. from aonecode.com

For example, if the aircraft has a maximum operating travel distance of 3000 miles, a forward/return shipping route pair using a total of 2900 miles would be optimal if there does not exist a pair that uses a total operating travel distance of 3000 miles, but would not be considered optimal if such a pair did exist. from aonecode.com

Your task is to write an algorithm to optimize the sets of forward/return shipping route pairs that allow the aircraft to be optimally utilized, given a list of forward shipping routes and a list of return shipping routes. from aonecode.com

Input
The input to the function/method consists of three arguments: from aonecode.com
maxTravelDist, an integer representing the maximum operating travel distance of the given aircraft;from aonecode.com
forwardRouteList, a list of pairs of integers where the first integer represents the unique identifier of a forward shipping route and the second integer represents the amount of travel distance required by this shipping route; 
retumRouteList, a list of pairs of integers where the first integer represents the unique identifier of a return shipping route and the second integer represents the amount of travel distance required by this shipping route. 

Output from aonecode.com
Return a list of pairs of integers representing the pads of IDs of forward and return shipping routes that optimally utilize the given aircraft. If no route is possible, return an empty list. from aonecode.com

Examples from aonecode.com
Example 1: Input: maxTravelDist= 7000 forwardRouteList = [[1,2000],[2,4000],[3,6000]] retumRouteList = [[1,2000]] 

Output: [[2,1]] from aonecode.com

Explanation: There are only three combinations, [1,1], [2,1], and [3,1], which have a total of 4000, 6000, and 8000 miles, respectively. Since 6000 is the largest use that does not exceed 7000, [2,1] is the only optimal pair.from aonecode.com 

Example 2: Input: maxTravelDist= 10000 forwardRouteList = [[1, 3000], [2, 5000], [3, 7000], [4, 10000]] retumRouteList= [[1, 2000], [2, 3000], [3, 4000], [4, 5000]] from aonecode.com

Output: [[2, 4], [3, 2]] 

Explanation: There are two pairs of forward and return shipping routes possible that optimally utilizes the given aircraft. Shipping Route ID#2 from the forwardShippingRouteList requires 5000 miles travelled, and Shipping Route ID84 from returnShippingRouteList also requires 5000 miles travelled. Combined, they add up to 10000 miles travelled. Similarly, Shipping Route ID#3 from forwardShippingRouteList requires 7000 miles travelled, and Shipping Route ID#2 from returnShippingRouteList requires 3000 miles travelled. These also add up to 10000 miles travelled. Therefore, the pairs of forward and return shipping routes that optimally utilize the aircraft are [2, 4] and [3, 2]. 
**/
