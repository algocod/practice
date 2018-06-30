package algorithms.firstlevel;

import java.util.Scanner;

import org.junit.Test;

import junit.framework.Assert;

/**
 * Given five positive integers, find the minimum and maximum values that can be calculated 
 * by summing exactly four of the five integers. Then print the respective minimum and maximum values as a 
 * single line of two space-separated long integers.
 * For e.g. 1 2 3 4 5 
 * 14 13 12 11 10 
 * 10 14 
 * @author hemant
 *
 */
public class MinMaxSum {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        long sum = 0;
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
            sum = sum + arr[arr_i];
        }
        miniMaxSum(arr,sum);
        in.close();
    }
	
	public static void miniMaxSum(int[] arr,long tSum)
	{
		long max= Long.MIN_VALUE;
		long min = Long.MAX_VALUE;
		
		for(int i = 0;i<5;i++)
		{
			long currSum = tSum-arr[i];
			if(currSum<=min)
				min = currSum;
			if(currSum>=max)
				max = currSum;
		}
		
		System.out.println(min+" "+max);
	}
	
	@Test
	public static void runUnitCase()
	{
		
	}

}
