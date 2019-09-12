package com.epi.greedy;

import java.util.*;

public class IntervalCoveringProblem {

	private static class Interval {
		int startTime;
		int endTime;
		
		Interval(int s, int e) {
			this.startTime = s;
			this.endTime = e;
		}
	}
	
	public List<Integer> findMinVists(List<Interval> tasks) {
		if(tasks.isEmpty()) return Collections.emptyList();
		List<Integer> visits = new ArrayList<>();
		Collections.sort(tasks, new Comparator<Interval>() {
			public int compare(Interval e1, Interval e2) {
				return Integer.compare(e1.endTime, e2.endTime);
			}
			
		});
		
		int visitTime = tasks.get(0).endTime; 
		visits.add(visitTime);
		for(int i = 1; i < tasks.size(); ++i) {
			if(visitTime < tasks.get(i).startTime) {
				visitTime = tasks.get(i).endTime;
				visits.add(visitTime);
			}
		}
		
		return visits;
	}
	
	public static void main(String[] args) {
		
	}
}
