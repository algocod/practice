package algorithms.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.

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
 * @author hemant
 *
 */
public class CourseScheduleFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
	     
        HashMap<Integer,LinkedList<Integer>>  adjList = new HashMap<>();
        int[] inDegree = new int[numCourses]; // 0 to n-1 hence 
        
        for(int[] pre : prerequisites)
        {
            adjList.computeIfAbsent(pre[1], k -> new LinkedList<>()).add(pre[0]);
            inDegree[pre[0]]++;
        }
        Queue<Integer> qu = new ArrayDeque<>();
        for(int i =0; i<numCourses;i++)
        {
            if(inDegree[i]==0)
                qu.offer(i); 
        }
        
        if(qu.size()<1)
            return false;
        
        int visited = 0;
        
        while(!qu.isEmpty())
        {
            int i = qu.poll();
            visited++;
            List<Integer> adj = adjList.get(i);
            if(adj!=null)
            {
                for(int j : adj)
                {
                    inDegree[j]--;
                    if(inDegree[j]==0)
                        qu.offer(j);
                }
            }
        }
        
        return visited==numCourses?true:false;
    }
	  public boolean canFinish(int numCourses, int[][] prerequisites)
	    {
	        // first construct the graph as in what courses can you do once you complete a particular course
	        //[1,0] means after completing 0 one can do the course 1 so directed graph from 0-->1
	        List<List<Integer>> lst = new ArrayList<>();
	        for(int i=0;i<numCourses;i++)
	            lst.add(new LinkedList<Integer>());
	        for(int[] a : prerequisites)
	        {
	            lst.get(a[1]).add(a[0]);
	        }
	        
	        HashSet<Integer> visiting = new HashSet<>();
	        HashMap<Integer,Boolean> visited = new HashMap<>();
	        for(int i=0;i<numCourses;i++)
	            visited.put(i,false);
	        
	         for(int i=0;i<numCourses;i++)
	         {
	             if(dfs(i,lst,visiting,visited))
	                 return false;       
	        }
	        
	        return true;
	    }
	    
	    public boolean dfs(int node, List<List<Integer>> lst , HashSet<Integer> visiting, HashMap<Integer,Boolean> visited)
	    {
	        //System.out.println(node);
	        //System.out.println(visiting);
	       // System.out.println(visited);
	        
	        if(visiting.contains(node))
	            return true; // it has a cycle.
	        
	        if(visited.get(node))
	            return false;
	        
	        visiting.add(node);
	        List<Integer> ls = lst.get(node);
	        for (int j=0;j<ls.size();j++)
	        {
	            
	            int next = ls.get(j);
	            //System.out.println("Inside loop--"+next);
	            if(dfs(next,lst,visiting,visited))
	                return false;
	        }
	        visiting.remove(node);
	        visited.put(node,true);
	        return false;       
	    }
	
	
}
