package com.epi.greedy;

import java.util.*;

public class OptimumAssignmentsOfTasks {

	private static class PairedTasks {
		int first;
		int second;
		
		PairedTasks(int f, int s) {
			this.first = f;
			this.second = s;
		}
	}
	
	public static List<PairedTasks> getOptimumAssignment(List<Integer> taskDurations) {
		List<PairedTasks> optimumAssignment = new ArrayList<>();
		Collections.sort(taskDurations);
		for(int i = 0, j = taskDurations.size()-1; i < j; ++i, --j) {
			PairedTasks p = new PairedTasks(taskDurations.get(i), taskDurations.get(j));
			optimumAssignment.add(p);
		}
		
		return optimumAssignment;
	}
}
