package cracking;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class RunningMedianHeap {

	public static void main(String[] args) {

		Queue<Integer> q = new ArrayDeque<>();
		
		Scanner in = new Scanner(System.in);
        /*
		int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
        	arr[i] = in.nextInt();
        }
        */
		int n = 10;
		int[] arr = {2,5,1,3,7,6,9,10,3,2};
        int minHpCount = 0;
        int maxHpCount = 0;
        
        int[] maxHeap = new int[n];
        int[] minHeap = new int[n];
        
        if(arr[0] <=arr[1])
        {
        	minHeap[0] = arr[0];
        	maxHeap[0] = arr[1];
        }
        else
        {
        	minHeap[0] = arr[1];
        	maxHeap[0] = arr[0];
        }
        minHpCount++;
        maxHpCount++;
        
        System.out.println(arr[0]/1.0);
        System.out.println((arr[0]+arr[1])/2.0);
        
        
        for(int i=2;i<n;i++)
        {
        	if(minHpCount==maxHpCount)
        	{
        		if(arr[i]>minHeap[minHpCount-1])
        		{
        			//add to the max number heap where the min is stored on the top
        			maxHeap[maxHpCount] = arr[i];
        			maxHpCount++;
        			heapAndSort(maxHeap, maxHpCount);
        		}
        		else
        		{
        			minHeap[minHpCount] = arr[i];
        			minHpCount++;
        			heapAndSort(minHeap, minHpCount);
        			
        		}
        	}
        	else if (minHpCount < maxHpCount)
        	{
        		// if the next element is bigger then the heaps need to be balanced.
        		if(arr[i]>minHeap[minHpCount-1])
        		{
        			if(arr[i]>maxHeap[0])
        			{
        				// this means the next element is greater than the minimum in the maxHeap
        				int temp = maxHeap[0];
        				maxHeap[0] = arr[i];
        				// sort the maxHeap as well after addition
        				heapAndSort(maxHeap, maxHpCount);
        				//add to Min Heap and sort
        				minHeap[minHpCount] = temp;
        				minHpCount++;
        				heapAndSort(minHeap, minHpCount);
        			}
        			else
        			{
        				minHeap[minHpCount] = arr[i];
        				minHpCount++;
        				heapAndSort(minHeap, minHpCount);
        			}
        		}
        		else
        		{
        			minHeap[minHpCount] = arr[i];
					minHpCount++;
					heapAndSort(minHeap, minHpCount);
        		}
        	}
        	else if (minHpCount > maxHpCount)
        	{
        		
        		if(arr[i] <= minHeap[minHpCount-1])
        		{
        			int temp = minHeap[minHpCount-1];
        			minHeap[minHpCount-1] = arr[i];
        			heapAndSort(minHeap, minHpCount);
        			
        			maxHeap[maxHpCount] = temp;
        			maxHpCount++;
        			heapAndSort(maxHeap, maxHpCount);
        		}
        		else
        		{
        			maxHeap[maxHpCount] = arr[i];
        			maxHpCount++;
        			heapAndSort(maxHeap, maxHpCount);
        		}
        		
        	}
        	
        	// Now get Median
        	double median = 0.0;
        	if(maxHpCount==minHpCount)
        		median = (minHeap[minHpCount-1] + maxHeap[0])/2.0;
        	else if (maxHpCount>minHpCount)
        		median = maxHeap[0];
        	else if(minHpCount>maxHpCount)
        		median = minHeap[minHpCount-1];
        	
        	System.out.println(median);
        	
        }
		
	}

	
	public static void heapAndSort(int[] arr, int l)
	{
		// tried the qSort but same performance as heapsort 
		//qSort(arr, 0, l-1);
		
		int mid = l/2 -1;
		for(int i=mid;i>=0;i--)
		{
			heapify(arr,i,l);
		}
		
		for(int i = l-1;i>=0;i--)
		{
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapify(arr,0,i);
		}
	}
	
	public static void qSort(int[] arr,int low , int high)
	{
		if (low < high)
		{
			int pivot =high;
			
			int j = low-1;
			for(int i=low;i<=high;i++)
			{
				if(arr[i]<=arr[pivot])
				{
					//swap with the j element which was big
					j++;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}	    		
			}

			qSort(arr,low,j-1);
			qSort(arr,j+1,high);	
		}
		
	}
	
	public static void heapify(int[] arr, int start, int end)
	{
		
		int leftI = 2*start+1;
		int rightI = 2*start +2;
		int largest = start;
		if(leftI<end && arr[largest]<arr[leftI])
			largest = leftI;
			
		if(rightI<end && arr[largest]<arr[rightI])
			largest = rightI;
		if(largest!=start)
		{
			int tmp = arr[start];
			arr[start] = arr[largest];
			arr[largest] = tmp;
			heapify(arr,largest,end);
		}
	}
	
	
	
	
}
