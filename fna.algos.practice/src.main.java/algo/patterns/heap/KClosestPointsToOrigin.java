package algo.patterns.heap;

import java.util.*;

public class KClosestPointsToOrigin {

	public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>
            ((a, b)-> (b[0] * b[0] + b[1] * b[1]) - ((a[0] * a[0] + a[1] * a[1])));
        
        for(int[] point : points) {
            q.add(point);
            if(q.size() > k) 
                q.remove();    
        }
             
        int[][] res = new int[k][2];
        for(int i = 0; i < k; ++i) {
            res[i] = q.remove();
        }
        return res;    
    }
}