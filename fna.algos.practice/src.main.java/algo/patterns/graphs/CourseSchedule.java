package algo.patterns.graphs;

import java.util.*;

public class CourseSchedule {

	// https://leetcode.com/problems/course-schedule/submissions/
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

		for(int i = 0; i < numCourses; ++i) {
			adj.put(i, new ArrayList<Integer>());
		}

		for(int i = 0; i < prerequisites.length; ++i) {
			adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}

		int[] visited = new int[numCourses];

		for(int i = 0; i < numCourses; ++i) {
			if(!dfs(adj, i, visited))
				return false;
		}

		return true;
	} 
    
    
    public static boolean dfs(Map<Integer, ArrayList<Integer>> adj, int idx, int[] visited) {
		if(visited[idx] == -1) return false;

		if(visited[idx] == 1) return true;

		visited[idx] = -1;

		for(int j : adj.get(idx)) {
			if(!dfs(adj, j, visited)) {
				return false;
			}
		}

		visited[idx] = 1;
		return true;
	}

	public static void main(String[] args) {
		int[][] edges = { {0, 1}, {1, 2,}, {3, 2}, {4, 3}, {2, 4}};
		int n = 5;
		System.out.print(canFinish(n, edges));
	}
}