package pc.ds.arrays.twoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	/** Given a collection of intervals, merge all overlapping intervals.

		Example 1:
		
		Input: [[1,3],[2,6],[8,10],[15,18]]
		Output: [[1,6],[8,10],[15,18]]
		Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
		Example 2:
		
		Input: [[1,4],[4,5]]
		Output: [[1,5]]
		Explanation: Intervals [1,4] and [4,5] are considered overlapping.
	**/
	
	private static class Interval {
		int start;
		int end;
		
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
    private static class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
//        Collections.sort(intervals, new IntervalComparator());
        
        Collections.sort(intervals, (a, b)-> a.start - b.start );

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }
    
    public static void main(String[] args) {
    	List<Interval> list = getIntervals(); 
    	List<Interval> res = merge(list);
    	print(res);
    }
    
    private static List<Interval> getIntervals() {
    	Interval a = new Interval(1, 3);
    	Interval b = new Interval(2, 6);
    	Interval c = new Interval(8, 10);
    	Interval d = new Interval(15, 18);
    	
    	List<Interval> list =  new ArrayList<>();
    	list.add(a);
    	list.add(b);
    	list.add(c);
    	list.add(d);
    	
    	return list;
    }
    
    private static void print(List<Interval> list) {
    	for(Interval i : list) {
    		System.out.println(i.start + ", " + i.end);
    	}
    }
}
