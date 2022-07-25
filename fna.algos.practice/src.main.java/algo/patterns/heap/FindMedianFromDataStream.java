package algo.patterns.heap;

import java.util.*;

class FindMedianFromDataStream {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    
    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        
        if(maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.remove());
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (double) ((maxHeap.peek() + minHeap.peek()) / 2.0);
        }
        
        return maxHeap.peek();
    }
}