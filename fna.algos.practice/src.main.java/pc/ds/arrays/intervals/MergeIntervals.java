package pc.ds.arrays.intervals;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	/*
	 * https://leetcode.com/articles/merge-intervals/
	 * Problem:
	 * Given a collection of intervals, merge all overlapping intervals.
		For example,
		Given [1,3],[2,6],[8,10],[15,18],
		return [1,6],[8,10],[15,18].
	 */
	
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
        Collections.sort(intervals, new IntervalComparator());

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
    	List<Interval> intervals = new LinkedList<Interval>();
    	intervals.add(new Interval(1,9));
    	intervals.add(new Interval(2,5));
    	intervals.add(new Interval(19,20));
    	intervals.add(new Interval(10,11));
    	intervals.add(new Interval(12,20));
    	intervals.add(new Interval(0,3));
    	intervals.add(new Interval(0,1));
    	intervals.add(new Interval(0,2));
    	
    	List<Interval> result = merge(intervals);
    	print(result);

    }
    
    private static void print(List<Interval> list) {
    	for(Interval i : list) {
    		System.out.println("(" + i.start + " , " + i.end + ")");
    	}
    }
}
