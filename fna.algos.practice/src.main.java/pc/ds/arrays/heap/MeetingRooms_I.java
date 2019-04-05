package pc.ds.arrays.heap;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms_I{
	public boolean canAttendMeetings(Interval[] intervals) {
	  if (intervals == null)
	    return false;
	
	  // Sort the intervals by start time
	  Arrays.sort(intervals, new Comparator<Interval>() {
	    public int compare(Interval a, Interval b) { return a.start - b.start; }
	  });
	  
	  for (int i = 1; i < intervals.length; i++)
	    if (intervals[i].start < intervals[i - 1].end)
	      return false;
	  
	  return true;
	}
	
	// Definition for an interval.
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
}

