package interview.pro.daily.problem;

import java.util.*;

public class RoomScheduling {

	public static class Interval implements Comparable<Interval>{
		int start;
		int end;
		
		Interval(int s, int e) {
			start = s;
			end = e;
		}
		
		@Override
		public int compareTo(Interval other) {
			int comp = Integer.compare(start, other.start);
			if(comp == 0)
				return Integer.compare(end, other.end);
			return comp;
		}
	}
	
	public static int scheduleRooms(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0) return 0;
		
		Collections.sort(intervals);
		PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.size(), new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.end - b.end;
			}
		}); 
		
		heap.add(intervals.get(0));
		
		for(int i = 1; i < intervals.size(); ++i) {
			Interval interval = heap.poll();
			if(intervals.get(i).start >= interval.end) {
				// no need for new room
				// merge the interval
				interval.end = intervals.get(i).end;
			} else {
				// need a new room
				heap.add(intervals.get(i));
			}
			heap.add(interval);

		}
		return heap.size();
	}
	
	public static void main(String[] args) {
		List<Interval> input = new ArrayList<>();
		input.add(new Interval(30, 75));
		input.add(new Interval(0, 50));
		input.add(new Interval(60, 150));
		System.out.println(scheduleRooms(input));
	}
}
