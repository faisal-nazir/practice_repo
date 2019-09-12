package com.epi.greedy;

import java.util.*;

public class ScheduleToMinimizeWaitTime {

	// EPI-18.2: SCHEDULE TO MINIMIZE WAITING TIME
	
	public static int schedule(List<Integer> tasks) {
		Collections.sort(tasks);

		int totalWaitTime = 0;
		for(int i = 0; i < tasks.size(); ++i) {
			int noOfRemaingTasks = tasks.size()-(i+1);
			System.out.println("No of Remaingin tasks: " + noOfRemaingTasks);
			totalWaitTime += tasks.get(i) * noOfRemaingTasks;
			System.out.println(totalWaitTime);

		}
		return totalWaitTime;
	}
	
	public static void main(String[] args) {
		List<Integer> t = Arrays.asList(2, 5, 1, 3);
		System.out.println(schedule(t));
	}
}
