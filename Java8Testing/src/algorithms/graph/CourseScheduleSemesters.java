package algorithms.graph;
import java.util.*;

public class CourseScheduleSemesters {

	public static void main(String[] args) {
	 int n = 3;
	 int[][] relations = {

			 {1,3},{2,3}	 };

	 int sems = minimumSemesters(n, relations);
	}

	
	public static int minimumSemesters(int N, int[][] relations) 
    {
        
        HashMap<Integer,LinkedList<Integer>> adjList = new HashMap<>();
        int n = N;
        int[] inD = new int[n + 1];
        
        for(int[] pre : relations)
        {
            adjList.computeIfAbsent(pre[0], k -> new LinkedList<>()).add(pre[1]);
            inD[pre[1]]++;
        }
        
        Queue<Integer> ans = new ArrayDeque<>();
        int lmax = -1;
        for(int i=1;i<=n;i++)
        {
            if(inD[i]==0)
                ans.offer(i);
            
        }
        lmax = getMaxBreadth(ans, inD,adjList);
        
        return lmax;
    }
    
    public static int getMaxBreadth(Queue<Integer> qu, int[] inD, HashMap<Integer,LinkedList<Integer>> adjList )
    {
        int len = inD.length-1;
    	int levels = 0;
        int n = 0;
    	while(!qu.isEmpty())
    	{
    		int size = qu.size(); // this seems to have done the trick while iterating over queues but i doubt.
            for(int i=0;i<size;i++)
            {
                int next = qu.poll();    
                n++;
                if(!adjList.containsKey(next))
                    continue;
                for(Integer a : adjList.remove(next))
                {
                    inD[a]--;
                    if(inD[a]==0)
                        qu.offer(a);
                }
            }
            
            levels++;
    	}
    	
    	return len==n?levels:-1;
    }	
}
