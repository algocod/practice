package algorithms;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxNumInSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        int len = 0;
        int n = nums.length;
        if(n==0 || n==1)
            return nums;
        while(len<k)
        {
            clean(dq,nums,nums[len]);
            dq.offerFirst(len);
            len++;
        }
        
        ans[len-k]=nums[dq.peekLast()];
        for(int i =k;i<n;i++)
        {
            clean(dq,nums,nums[i]);
            dq.offerFirst(i);
            while(dq.size()>0 && i-dq.peekLast()>=k)
                dq.removeLast();
            
            ans[i-k+1] = nums[dq.peekLast()];
        }
        
        return ans;
    }
    
    public void clean(Deque<Integer> ddq, int[] nums, int addNum)
    {
        if(ddq==null || ddq.size()<1)
            return;
        while(ddq.size()>0 && addNum > nums[ddq.peekFirst()])
            ddq.removeFirst();
    }
    
    public int[] maxSlidingWindowOld(int[] nums, int k) 
    {
        PriorityQueue<Integer> pq  = new PriorityQueue<>((a,b) -> b-a>0?1:-1);
        int[] ans = new int[nums.length-k+1];
        int len = 0;
        int n = nums.length;
        if(n==0 || n==1)
            return nums;
        while(len<k)
        {
            pq.offer(nums[len]);
            len++;
        }
        
        ans[len-k]=pq.peek();
        for(int i =k;i<n;i++)
        {
            pq.remove(nums[i-k]);
            pq.offer(nums[i]);
            ans[i-k+1] = pq.peek();
        }
        
        return ans;
    }

	
	
}
