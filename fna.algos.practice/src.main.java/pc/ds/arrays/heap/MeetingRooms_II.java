package pc.ds.arrays.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/** Given an array of meeting time intervals consisting of start and end times
 *  [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
	
	Example 1:
	
	Input: [[0, 30],[5, 10],[15, 20]]
	Output: 2
	Example 2:
	
	Input: [[7,10],[2,4]]
	Output: 1
**/
public class MeetingRooms_II {
	//https://leetcode.com/problems/meeting-rooms-ii/discuss/67857/AC-Java-solution-using-min-heap
	public int minMeetingRooms(Interval[] intervals) {
	    if (intervals == null || intervals.length == 0)
	        return 0;
	        
	    // Sort the intervals by start time
	    Arrays.sort(intervals, new Comparator<Interval>() {
	        public int compare(Interval a, Interval b) { return a.start - b.start; }
	    });
	    
	    // Use a min heap to track the minimum end time of merged intervals
	    PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
	        public int compare(Interval a, Interval b) { return a.end - b.end; }
	    });
	    
	    // start with the first meeting, put it to a meeting room
	    heap.offer(intervals[0]);
	    
	    for (int i = 1; i < intervals.length; i++) {
	        // get the meeting room that finishes earliest
	        Interval interval = heap.poll();
	        
	        if (intervals[i].start >= interval.end) {
	            // if the current meeting starts right after 
	            // there's no need for a new room, merge the interval
	            interval.end = intervals[i].end;
	        } else {
	            // otherwise, this meeting needs a new room
	            heap.offer(intervals[i]);
	        }
	        
	        // don't forget to put the meeting room back
	        heap.offer(interval);
	    }
	    
	    return heap.size();
	}
	
	private static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	//https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-%40pinkfloyda
	
	public int minMeetingRooms_01(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
		
}

