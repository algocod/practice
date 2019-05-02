package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.DelayQueue;

public class MaxInArray {

	//work out the max k elements in an array of n elements.
	// This is the lengthy way of computing. The optimized way is to create an array of length k and iterated through the main array to populate it.
	// Once the k array is full, then on the next element, find the min element from the k array and replace it ONLY if its less than the next element from parent array
	// Create a min heap and keep removing the head upon every next element that is smaller than the head.
	public static void main(String[] args) {

		int arI[] = {21,186,5,11,4,98};
		int mxI[] = new int[3];
		int max = 0;
		int premax=Integer.MAX_VALUE;
		
		for (int i=0;i<mxI.length;i++)
		{
			max=Integer.MIN_VALUE;
			for (int j:arI)
			{
				if (j>max && j<premax)
					max= j;
			}
			mxI[i]=max;
			premax=max;
		}
		System.out.println(Arrays.toString(mxI));
		usePriorityQ(arI,3);
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b<a?1:-1);// Default PQ is a min PQ
		for(Integer i : arI)
			pq.add(i);
		System.out.println("testing PQ"+pq.toString());
		System.out.println("testing PQ----"+pq.poll());
		PriorityQueue<Integer> pqmax = new PriorityQueue<>((a,b)->a<b?1:-1);
		//PriorityQueue<Map.Entry<Integer, Double>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
		Double d = 9.0;
		int ip = (int)Math.round(9.0) +1 ;
		if(d<ip)
		{
			
		}

		for(Integer i : arI)
			pqmax.add(i);
		System.out.println(pqmax.toString());
		System.out.println(pqmax.poll());
	}
	
	// Get the max k elements 
	public static void usePriorityQ(int[] arr,int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a>=b?1:-1);
		
		for(Integer a : arr)
		{
			pq.offer(a);
			if(pq.size()>k)
				pq.poll();
		}
		
		/*
		for(int i =0;i<arr.length;i++)
		{
			if(i<k)
			{
				pq.add(arr[i]);
			}
			else
			{
				int currentHead = pq.peek();
				if(currentHead<arr[i]) // for K small elements, this direction here has to change
				{
					pq.poll();
					pq.offer(arr[i]);
				}	
			}
			
		}
		*/
		System.out.println("Queue after addition "+pq.toString());
		
	}
	
	

}
