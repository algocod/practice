package algorithms.search;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Lauren has a chart of distinct projected prices for a house over the next  years, where the price of the house in the  year is . She wants to purchase and resell the house at a minimal loss according to the following rules:

The house cannot be sold at a price greater than or equal to the price it was purchased at (i.e., it must be resold at a loss).
The house cannot be resold within the same year it was purchased.
Find and print the minimum amount of money Lauren must lose if she buys the house and resells it within the next  years.

Note: It's guaranteed that a valid answer exists.

Input Format

The first line contains an integer, , denoting the number of years of house data. 
The second line contains  space-separated long integers describing the respective values o
3
5 10 3

2

5
20 7 8 2 5

2

 * @author hemant
 *
 */
public class MinLoss 
{

	/*
    static long minimumLoss(long[] price) {
    	
    	// cant sell in the past
    	long[] sortedPrice = price.clone();
    	long minLoss = Long.MAX_VALUE;
    	for(int i=0;i<price.length-1;i++)
    	{
    		long pi = price[i];
    		int pidIndex = 0;
    		int lessThanIndex = getMaxLessthan(price, pi, i+1);
    		
    		long currLoss = pi - price[lessThanIndex];
    		if(currLoss<minLoss && currLoss>0)
    			minLoss = currLoss;
    	}
    	
    	return minLoss;
    
    }
    */
    /*
     * Below is the solution that iterates to find the next immediate smallest number but its in O(N2) 
     */
    static int getMaxLessthan(long[] price, long lessThan, int startIndex)
    {
    	int index = startIndex;
    	long max = Long.MIN_VALUE;
    	for(int k =startIndex;k<price.length;k++)
    	{
    		if(price[k]>max && price[k]<lessThan)
    		{
    			max = price[k];
    			index = k;
    		}
    			
    	}
    	
    	return index;
    }
    
    /*
     * Below is the solution to first sort and then find diff between adjacent pairs where their original indices are in increasing order.
     * We will use HashMap to store original index to reduce it to O(nlogn) + n 
     */
    static long minimumLoss(long[] price) {
    	
    	// cant sell in the past
    	long[] sortedPrice = price.clone();
    	qSort(sortedPrice, 0, price.length-1);
    	HashMap<Long, Integer> hmIndex = new HashMap<Long,Integer>();
    	for(int i=0;i<price.length;i++)
    	{
    		hmIndex.put(price[i], i);
    	}
    	long minLoss = Long.MAX_VALUE;
    	for(int i=sortedPrice.length-1;i>0;i--)
    	{
    		long pi = sortedPrice[i];
    		if(hmIndex.get(sortedPrice[i]) < hmIndex.get(sortedPrice[i-1]))
    		{
    			long currLoss = sortedPrice[i]-sortedPrice[i-1];
    			if(currLoss<minLoss)
    				minLoss = currLoss;
    		}
    	}
    	
    	return minLoss;
    
    }
    public static void qSort(long[] arr,int low , int high)
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
					long temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

			qSort(arr,low,j-1);
			qSort(arr,j+1,high);	
		}
		
	}
    
	/*
	 * Binary search method
	 */
/*
    static int searchElement(long[] sorted, long p , int start , int end)
    {
    	if((end-start)<2)
    	{
    		int foundIndex = 0;
    		if(sorted[start]==p)
    			foundIndex= start;
    		else if(sorted[end]==p)
    			foundIndex= end;
    		
    		return foundIndex;
    	}
    	else
    	{
    		int mid  = 0;
        	if((end-start)%2==0)
        	{
        		mid = (end-start)/2;
        		
        	}
        	else
        	{
        		mid = ((end-start)+1)/2;
        	}
        	
        	if(p<sorted[start+mid])
        	{
        		return searchElement(sorted, p, start, start+mid-1);
        	}
        	else
        		return searchElement(sorted, p, start+mid, end);	
    	}
    	
    	
    	
    }
*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] price = new long[n];
        for(int price_i = 0; price_i < n; price_i++){
            price[price_i] = in.nextLong();
        }
        long result = minimumLoss(price);
        System.out.println(result);
        in.close();
    }
	
}
