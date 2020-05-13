package pc.ds.arrays.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	/** Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

	You may assume that the intervals were initially sorted according to their start times.
	
	Example 1:
	
	Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
	Output: [[1,5],[6,9]]
	Example 2:
	
	Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
	Output: [[1,2],[3,10],[12,16]]
	Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
	**/
	
	// Check out on leetcode - Laiq's java submission - simpler than the one below
	private static class Interval {
		int start;
		int end;
		
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	private static ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {

		ArrayList<Interval> result = new ArrayList<Interval>();

		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) { // we have not yet reached the insertion interval
				result.add(interval);
			} else if (interval.start > newInterval.end) { // moved past the insertion interval
				result.add(newInterval);
				newInterval = interval;
			} else if (interval.end >= newInterval.start
					|| interval.start <= newInterval.end) { // its an overlap either on start or end.
				newInterval = new Interval(Math.min(interval.start,
						newInterval.start), Math.max(newInterval.end,
						interval.end));
			}
		}

		result.add(newInterval);

		return result;
	}
	
	public static void main(String[] args) {
    	List<Interval> list = getIntervals(); 
    	List<Interval> res = insert(new ArrayList<Interval>(list), new Interval(4,8));
    	print(res);
    }
	
	 private static List<Interval> getIntervals() {
	    	Interval a = new Interval(1, 2);
	    	Interval b = new Interval(3, 5);
	    	Interval c = new Interval(6, 7);
	    	Interval d = new Interval(8, 10);
	    	Interval e = new Interval(12, 16);
	    	
	    	List<Interval> list =  new ArrayList<>();
	    	list.add(a);
	    	list.add(b);
	    	list.add(c);
	    	list.add(d);
	    	list.add(e);
	    	
	    	return list;
	    }
	    
	    private static void print(List<Interval> list) {
	    	for(Interval i : list) {
	    		System.out.println(i.start + ", " + i.end);
	    	}
	    }
	
}
