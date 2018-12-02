package interviewQs;

import java.awt.List;
import java.util.LinkedList;

/**
 * 5
21
35
24
36
30

223317
1132436852
1389537
2082876103
53798080

 * @author hemant
 * The last three methods are slow graduation of the simple methods as in recursive then memoize and then finally DP
 */
		
public class StepsProblem 
{
	
		public static void main(String[] args)
		{
			Integer[] mem = new Integer[30+1];
			mem[0]=1;
			mem[1] =1;
			System.out.println(countSteps(3));
			System.out.println(calcWays(4));
			System.out.println(calcWays(5));
			System.out.println(calcWays(10)==simpleCount(10));
			System.out.println(simpleCount(10)==memoizeCount(10, mem));
			System.out.println(memoizeCount(10, mem)==iterativeDP(10));
		
			
			System.out.println(calcWays(21));
			System.out.println(calcWays(35));
			System.out.println(calcWays(24));
			System.out.println(calcWays(36));
			System.out.println(calcWays(30)==simpleCount(30));
			System.out.println(simpleCount(30)==memoizeCount(30, mem));
			System.out.println(memoizeCount(30, mem)==iterativeDP(30));
		
		}
			
			
		public static int calcWays(int n) {
		    if (n < 1) return 0;
		    if (n == 1) return 1;
		    if (n == 2) return 2;
		    if (n == 3) return 4;
		    
		    int[] ways = new int[] {1,2,4};
		    
		    for (int i = 4; i < n; i++) {
		        int idx = (i - 1) % 3;
		        ways[idx] = ways[0] + ways[1] + ways[2];
		    }
		    return ways[0] + ways[1] + ways[2];
		}	
		
		public static int countSteps(int n)
		{
			if(n==0)
				return 1;
			if(n==1)
				return 1;
			if(n==2)
				return 2;
			
			
				return  countSteps(n-1) + countSteps(n-2) + countSteps(n-3);
		}
		
		public static int simpleCount(int n)
		{
			if(n==0 ||n==1)
				return 1;
			if(n<0)
				return 0;
			return simpleCount(n-1)+simpleCount(n-2)+simpleCount(n-3);
		}

		public static int memoizeCount(int n, Integer[] mem)
		{
			if(n>=0 && mem[n]!=null)
				return mem[n];
			if(n<0)
				return 0;
			int interim = memoizeCount(n-1,mem)+memoizeCount(n-2,mem)+memoizeCount(n-3,mem);
			mem[n] = interim;
			return mem[n];
		}
		
		public static int iterativeDP(int n)
		{
			Integer[] arr = new Integer[n+1];
			arr[0]=1;
			arr[1]=1;
			arr[2] =2;
			for(int i=3;i<arr.length;i++)
			{
				arr[i] = arr[i-3]+arr[i-2]+arr[i-1];
			}
			
			return arr[n];
		}
		
}