package algorithms.graph;

import java.util.*;
/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * 
 * @author hemant
 *
 */
public class CourseScheduleTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


    public int[] findOrder(int numCourses, int[][] prerequisites)
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
      int[] ans = new int[0];
      Stack<Integer> order = new Stack<>();
       for(int i=0;i<numCourses;i++)
       {
           if(!visited.get(i))
           {
              if(dfs(i,lst,visiting,visited,order))
                   return ans;           
          }
           
      }
      
      ans = new int[order.size()];
      int i =0;
      while(order.size()>0)
      {
          ans[i++] = order.pop();
      }
        
      return ans;
  }
  
  public boolean dfs(int node, List<List<Integer>> lst , HashSet<Integer> visiting, HashMap<Integer,Boolean> visited, Stack<Integer> order)
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
          if(dfs(next,lst,visiting,visited,order))
              return false;
      }
      visiting.remove(node);
      order.push(node); // Its a stack because the last course , upon whose completion nothing else can be done will be the last node in the dfs and hence
      					// should go to the bottom of the stack. while constructing the answer hence the stack is being popped to get the first course 
      					// which if completed will lead us to the chain of courses downstream. 
      visited.put(node,true);
      return false;       
  }
	
}
