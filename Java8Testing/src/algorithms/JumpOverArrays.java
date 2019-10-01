package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class JumpOverArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = {2,3,1,1,4};
		int[] arr = {1,2,1,1,1};
		//int result = new JumpOverArrays().jump(arr);
		//int result = new JumpOverArrays().jumpOpt(arr);
		int result = new JumpOverArrays().jumpBFS(arr);
		System.out.println(result);
	}
	/**
	 * Further optimized for BFS
	 * @param A
	 * @return
	 */
	
	public int jumpOpt(int[] A) {
	    int sc = 0;
	    int e = 0;
	    int max = 0;
	    for(int i=0; i<A.length-1; i++) {
	        max = Math.max(max, i+A[i]);
	        if( i == e ) {
	            sc++;
	            e = max;
	        } 
	    }
	    return sc;
	}
	
	/**
	 * This passes all test cases except the last one where it fails on Time Limit Exceeded.
	 * @param A
	 * @return
	 */
	public int jumpBFS(int[] A) {
		int jumps = 0;
		int max = A.length-1;
		int[] visited = new int[A.length];		
	    Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		while(!q.isEmpty())
		{
			Queue<Integer> tq = new LinkedList<>();
			while(!q.isEmpty())
			{
				int i = q.poll();
				if(i==A.length-1)
					return jumps;
				visited[i]=1;
				int tm = i+A[i];
				while(tm>i)
				{
					if(tm<A.length && visited[tm]!=1)
						tq.offer(tm);
					tm--;
				}
			}
			jumps++;
			q = tq;
			
		}
		
	    return jumps;
	}
	
	public int jump(int[] nums) {
	        
	        int count = 0;
	        count = helper(nums,0,count);
	        return count;
	    }
	    
	    public int helper(int[] nums, int index, int count)
	    {
	        if(index>=nums.length)
	            return Integer.MAX_VALUE;
	        if(index==nums.length-1)
	            return count;
	        
	        int jump = nums[index];
	        int tmpC = Integer.MAX_VALUE;
	        for(int i=1;i<=jump;i++)
	        {
	            tmpC =Math.min(helper(nums,index+i,count+1),tmpC);
	        }
	        
	        return tmpC;
	    }

	
	
	
/**
 * DP wont work as the path matters from where the index is being reached. 	
 * @param nums
 * @return
 */
public int jumpNope(int[] nums) {
        
        int count = 0;
        Integer[] dp = new Integer[nums.length];
        count = helper(nums,0,count,dp);
        return count;
    }
    
    public int helper(int[] nums, int index, int count, Integer[] dp)
    {
        if(index>=nums.length)
            return Integer.MAX_VALUE;
        if(index==nums.length-1)
        {
        	if(dp[index]!=null && dp[index]<count)
        		dp[index]=count;
        	return count;
        }
            
        if(dp[index]!=null)
            return dp[index];
        
        int jump = nums[index];
        int tmpC = Integer.MAX_VALUE;
        for(int i=1;i<=jump;i++)
        {
            tmpC =Math.min(helper(nums,index+i,count+1,dp),tmpC);
        }
        dp[index] = tmpC;
        
        return tmpC;
    }


}
