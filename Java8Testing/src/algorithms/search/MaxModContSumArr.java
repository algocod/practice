package algorithms.search;
/**
 e define the following:

A subarray of array  of length  is a contiguous segment from  through  where .
The sum of an array is the sum of its elements.
Given an -element array of integers, , and an integer, , determine the maximum value of the sum of any of its subarrays modulo . For example, Assume  and . The following table lists all subarrays and their modulus:

		sum	%2
[1]		1	1
[2]		2	0
[3]		3	1
[1,2]		3	1
[2,3]		5	1
[1,2,3]		6	0
The maximum modulus is .

Input Format

The first line contains an integer , the number of queries to perform.

The next  pairs of lines are as follows:

The first line contains two space-separated integers  and , the length of  and the modulo divisor.
The second line contains  space-separated integers .
Constraints

1
5 7
3 3 9 9 5

6

 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxModContSumArr 
{
    static long maximumSum(long[] a, long m) {
    	long curr = 0;
    	// the below is the array that has a modulo for each position if all the elements were summed starting from 0 to n-1
    	for(int i = 0;i<a.length;i++)
    	{
    		curr = (curr+a[i]%m)%m;
    		a[i] = curr;
    	}
    	long maxMod = 0;
    	long currMax = 0;
    	int intInd = 0;
    	//Once the ending modulo at each index is created, now iterate and find which one is the largest behind it and subtract it from the current position 
    	// add a factor of M to make it look positive
    	// The finding of a max is a n2 function hence it times out , if it can be taken to a treeset or something then good.. 
    	for(int k =0;k<a.length;k++)
    	{
    		
    		for(int j =k-1;j>=0;j--)
    		{
    			maxMod = max(maxMod, (a[k]-a[j]+m)%m);
    		}
    		maxMod = max(maxMod,a[k]);
    		/* This was a good attempt to get over the answer
    		currMax = (currMax + a[k]);
    		if(currMax<=m-1)
    		{
    			if(currMax>maxMod)
    				maxMod = currMax;
    		}
    		else if(currMax>=m)
    		{
    			while(currMax>=m && intInd<k)
    			{
    				currMax = currMax - a[intInd];
    				intInd++;
    			}
    			
    			if(currMax<=m-1 && currMax>maxMod)
    				maxMod = currMax;
    		}
    		*/
    	}
    	
    	
    	return maxMod;
    }
    
    static long max(long a, long b)
    {
    	if(a>b)
    		return a;
    	else 
    		return b;
    				
    }

    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File("C:\\Study\\Algo\\ModInput2.txt");
        Scanner in = new Scanner(file);
    	//Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            long m = in.nextLong();
            long[] a = new long[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextLong();
            }
            long result = maximumSum(a, m);
            System.out.println(result);
        }
        in.close();
    }


}
