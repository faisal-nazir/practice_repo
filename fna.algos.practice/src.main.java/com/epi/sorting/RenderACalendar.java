package com.epi.sorting;

import java.util.*;

public class RenderACalendar {
	private static class Event {
		int startTime;
		int endTime;
		
		Event(int s, int e) {
			this.startTime = s;
			this.endTime = e;
		}
	}
	
	private static class EndPoint implements Comparable<EndPoint> {
		int time;
		boolean isStartTime;
		
		EndPoint(int t, boolean isStart) {
			this.time = t;
			this.isStartTime = isStart;
		}
		
		@Override
		public int compareTo(EndPoint o) {
			if(this.time == o.time) {
				return (this.isStartTime && !o.isStartTime)? -1 : (!this.isStartTime && o.isStartTime)? 1 : 0; 
			}
			return Integer.compare(this.time, o.time);
		}
	}
	
	public static int computeConcurrentEvents(List<Event> events) {
		List<EndPoint> endPoints = new ArrayList<>();
		
		for(Event e : events) {
			
			endPoints.add(new EndPoint(e.startTime, true));
			endPoints.add(new EndPoint(e.endTime, false));
		}
		
		Collections.sort(endPoints);
		int max = 0, count = 0;
		
		for(EndPoint p : endPoints) {
			if(p.isStartTime) {
				++count;
				max = Math.max(max, count);
			} else {
				--count;
			}
		}
		return max;
	}
}
