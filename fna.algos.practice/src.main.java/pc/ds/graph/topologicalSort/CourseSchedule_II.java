package pc.ds.graph.topologicalSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * Example 1:
 * 
 * Input: 2, [[1,0]] Output: [0,1] Explanation: There are a total of 2 courses
 * to take. To take course 1 you should have finished course 0. So the correct
 * course order is [0,1] . Example 2:
 * 
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]] Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you
 * should have finished both courses 1 and 2. Both courses 1 and 2 should be
 * taken after you finished course 0. So one correct course order is [0,1,2,3].
 * Another correct ordering is [0,2,1,3] . Note:
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented. You may
 * assume that there are no duplicate edges in the input prerequisites.
 **/
public class CourseSchedule_II {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] incLinkCounts = new int[numCourses];
		List<List<Integer>> adjs = new ArrayList<>(numCourses);
		initialiseGraph(incLinkCounts, adjs, prerequisites);
		 return solveByBFS(incLinkCounts, adjs);
		//return solveByDFS(adjs);
	}

	private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites){
	    int n = incLinkCounts.length;
	    while (n-- > 0) adjs.add(new ArrayList<Integer>());
	    for (int[] edge : prerequisites) {
	        incLinkCounts[edge[0]]++;
	        adjs.get(edge[1]).add(edge[0]);
	    }
	}

	private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs) {
		int[] order = new int[incLinkCounts.length];
		Queue<Integer> toVisit = new ArrayDeque<>();
		for (int i = 0; i < incLinkCounts.length; i++) {
			if (incLinkCounts[i] == 0)
				toVisit.offer(i);
		}
		int visited = 0;
		while (!toVisit.isEmpty()) {
			int from = toVisit.poll();
			order[visited++] = from;
			for (int to : adjs.get(from)) {
				incLinkCounts[to]--;
				if (incLinkCounts[to] == 0)
					toVisit.offer(to);
			}
		}
		return visited == incLinkCounts.length ? order : new int[0];
	}
	
	private int[] solveByDFS(List<List<Integer>> adjs) {
	    BitSet hasCycle = new BitSet(1);
	    BitSet visited = new BitSet(adjs.size());
	    BitSet onStack = new BitSet(adjs.size());
	    Deque<Integer> order = new ArrayDeque<>();
	    for (int i = adjs.size() - 1; i >= 0; i--) {
	        if (visited.get(i) == false && hasOrder(i, adjs, visited, onStack, order) == false) return new int[0];
	    }
	    int[] orderArray = new int[adjs.size()];
	    for (int i = 0; !order.isEmpty(); i++) orderArray[i] = order.pop();
	    return orderArray;
	}

	private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
	    visited.set(from);
	    onStack.set(from);
	    for (int to : adjs.get(from)) {
	        if (visited.get(to) == false) {
	            if (hasOrder(to, adjs, visited, onStack, order) == false) return false;
	        } else if (onStack.get(to) == true) {
	            return false;
	        }
	    }
	    onStack.clear(from);
	    order.push(from);
	    return true;
	}
	
	// my submission on leetcode
	public static int[] findOrder_02(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return new int[0];
        
        int[] indegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge : prerequisites) {
            int course = edge[0];
            int preReq = edge[1];

            indegree[course]++;
            graph[preReq].add(course);
        }
        
        Queue<Integer> q = new LinkedList<>();        
        for(int i = 0; i < indegree.length; ++i) {
            if(indegree[i] == 0) 
                q.offer(i);
        }
        
        if(q.isEmpty()) return new int[0];
        
        int count = 0;
        while(!q.isEmpty()) {
            int courseTaken = q.poll();
            res.add(courseTaken);
            ++count;
            for(int dependentCourse : graph[courseTaken]) {
                indegree[dependentCourse]--;
                if(indegree[dependentCourse] == 0) {
                    q.offer(dependentCourse);
                }
            }
        }
        
        int[] output = new int[res.size()];
        for(int i = 0; i < res.size(); ++i) {
            output[i] = res.get(i);
        }
        
        return count == numCourses ? output : new int[0];
        
    }
	
	public static void main(String[] args) {
		int[] res = findOrder_02(1, new int[0][0]);
		
	}
	
}
