package com.epi.sorting;

import java.util.*;

public class MergeIntervals {

	// EPI- 14.5: Merge intervals
	
	// Check out on leetcode - Laiq's java submission - simpler than the one below
	private static class Interval {
		int start;
		int end;
		
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	public static List<Interval> merge(List<Interval> intervals, Interval newInterval) {
		if(intervals == null || intervals.size() == 0) return null;
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval e1, Interval e2) {
				return Integer.compare(e1.start, e2.start);
			}
		});
		List<Interval> res = new ArrayList<>();
		int i = 0;
		while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
			res.add(intervals.get(i++));
		}
		while(i < intervals.size() && newInterval.end >= intervals.get(i).start) {
			newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start) ,
										Math.max(intervals.get(i).end, newInterval.end));
			++i;
		}
		res.add(newInterval);
		res.addAll(intervals.subList(i, intervals.size()));
		return res;
	}
}
