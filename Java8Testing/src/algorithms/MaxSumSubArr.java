package algorithms;

public class MaxSumSubArr 
{
	public static void main (String[] args)
	{
		//int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		int [] a = {34, -50, 42, 14, -5, 86}; 
		
		int max = a[0];
		int currMax = a[0];
		
		for(int i =1;i<a.length;i++)
		{
			
			if(a[i] < currMax+a[i])
				currMax = currMax +a[i];
			else
				currMax = a[i];
			if(currMax>max)
				max = currMax;
			
			/*
			currMax = Math.max(a[i], currMax+a[i]);
			max = Math.max(max, currMax);
			*/
		}
		System.out.println(max);
	}
	
}
