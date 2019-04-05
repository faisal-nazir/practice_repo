package pc.ds.graph.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 
	There are a total of n courses you have to take, labeled from 0 to n-1.
	
	Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
	
	Given the total number of courses and a list of prerequisite pairs, return the number of semester it would take to 
	
	complete all courses. (Asked by Amazon - Phone Interview)
	
	Example 1:
	
	Input: 2, [[1,0]] 
	Output: true
	Explanation: There are a total of 2 courses to take. 
	             To take course 1 you should have finished course 0. So it is possible.
	Example 2:
	
	Input: 2, [[1,0],[0,1]]
	Output: false
	Explanation: There are a total of 2 courses to take. 
	             To take course 1 you should have finished course 0, and to take course 0 you should
	             also have finished course 1. So it is impossible.
	Note:
	
	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
	You may assume that there are no duplicate edges in the input prerequisites.
**/

public class CourseSchedule_III {
	// bfs version of the solution
	// https://leetcode.com/problems/course-schedule/discuss/58516/Easy-BFS-Topological-sort-Java
	// comment from Huayra007
	// Modified for this problem to output number of semesters.
	public static int canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new LinkedList[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		int[] indegree = new int[numCourses];
		int count = 0, semesterCount = 0;
		for (int i = 0; i < numCourses; i++)
			graph[i] = new LinkedList<Integer>();
		for (int[] pair : prerequisites) {
			graph[pair[1]].add(pair[0]);
			indegree[pair[0]]++;
		}
		for (int i = 0; i < indegree.length; i++)
			if (indegree[i] == 0)
				queue.offer(i);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; ++i) {
				int course = queue.poll();
				count++;
				for (int adj : graph[course])
					if (--indegree[adj] == 0)
						queue.offer(adj);
			}
			++semesterCount;
		}
		return (count == numCourses) ? semesterCount : -1;
    }
	
	public static void main(String[] args) {
		int[][] arr = { 
				{5, 3}, 
				{4, 2}, 
				{4, 3},
				{3, 1},
				{2, 1}
		};
		System.out.println(canFinish(6, arr));
	}

}
