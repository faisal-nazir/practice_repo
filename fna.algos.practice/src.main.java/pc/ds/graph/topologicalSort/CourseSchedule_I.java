package pc.ds.graph.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 
	There are a total of n courses you have to take, labeled from 0 to n-1.
	
	Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
	
	Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
	
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

public class CourseSchedule_I {
	// bfs version of the solution
	// https://leetcode.com/problems/course-schedule/discuss/58516/Easy-BFS-Topological-sort-Java
	// comment from Huayra007
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new LinkedList[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		int[] indegree = new int[numCourses];
		int count = 0;
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
			int course = queue.poll();
			count++;
			for (int adj : graph[course])
				if (--indegree[adj] == 0)
					queue.offer(adj);
		}
		return count == numCourses;
    }
	
	// https://leetcode.com/problems/course-schedule/discuss/58524/Java-DFS-and-BFS-solution
	public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
            
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }

}
