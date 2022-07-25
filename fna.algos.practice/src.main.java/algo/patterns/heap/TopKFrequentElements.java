package algo.patterns.heap;

import java.util.*;

public class TopKFrequentElements {

	// this is (N log N) - where N is the number of unique elments in the array
	// slightly better version is N log K which is achieved by adding 'k' elements to the heap
    // O(n) version is using quick select algorithm
    // https://stackoverflow.com/questions/8783408/why-is-the-runtime-of-the-selection-algorithm-on

	public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)-> map.get(b) - map.get(a));
        
        for(int key : map.keySet()) {
            heap.add(key);
        }
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = heap.remove();
        }
        
        return res;
    }
}