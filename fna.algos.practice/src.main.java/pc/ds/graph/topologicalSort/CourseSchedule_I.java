package pc.ds.graph.topologicalSort;

import java.util.ArrayList;
import java.util.Deque;
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
    
    
    // my submission
    // 
    // topological sort - using stack 
    // with out explicit graph it is slow coz it has to search for adjacets
    
    public boolean canFinish_01(int numCourses, int[][] prerequisites) {
    
        int[] indegree = new int[numCourses];
        
        for(int[] edge : prerequisites) {
            indegree[edge[0]]++;
        }
        
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < indegree.length; ++i) {
            if(indegree[i] == 0) 
                stack.push(i);
        }
        
        if(stack.isEmpty()) return false; // no starting node found
        
        int counter = 0;
        while(!stack.isEmpty()) {
            int courseTaken = stack.pop();
            ++counter;
            for(int[] edge : prerequisites) {
                if(edge[1] == courseTaken) {
                    indegree[edge[0]]--;
                    if(indegree[edge[0]] == 0)
                        stack.push(edge[0]);
                }
            }
        }
        
        return counter == numCourses;
    }
    
    
    // topological sort
    // same version as above but using queue instead of stack
    // for some reason, this was considered faster than the stack based solution by leetcode
    public boolean canFinish_02(int numCourses, int[][] prerequisites) {
    
        int[] indegree = new int[numCourses];
        
        for(int[] edge : prerequisites) {
            indegree[edge[0]]++;
        }
        
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; ++i) {
            if(indegree[i] == 0) 
                q.offer(i);
        }
        
        if(q.isEmpty()) return false; // no starting node found
        
        int counter = 0;
        while(!q.isEmpty()) {
            int courseTaken = q.poll();
            ++counter;
            for(int[] edge : prerequisites) {
                if(edge[1] == courseTaken) {
                    indegree[edge[0]]--;
                    if(indegree[edge[0]] == 0)
                        q.offer(edge[0]);
                }
            }
        }
        
        return counter == numCourses;
    }
    
    // topological sort - with graph
    // faster than the two solutions above
    public boolean canFinish_03(int numCourses, int[][] prerequisites) {
    
        int[] indegree = new int[numCourses];
        List<Integer>[] graph = new LinkedList[numCourses];
        
        for(int i = 0; i < numCourses; ++i) {
            graph[i] = new LinkedList<>();
        }
        
        for(int[] edge : prerequisites) {
            indegree[edge[0]]++;
            graph[edge[1]].add(edge[0]);
        }
        
        
        
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; ++i) {
            if(indegree[i] == 0) 
                q.offer(i);
        }
        
        if(q.isEmpty()) return false; // no starting node found
        
        int counter = 0;
        while(!q.isEmpty()) {
            int courseTaken = q.poll();
            ++counter;
            for(int dependentCourse : graph[courseTaken]) {
                indegree[dependentCourse]--;
                if(indegree[dependentCourse] == 0)
                    q.offer(dependentCourse);
                
            }
        }
        
        return counter == numCourses;
    }

}
