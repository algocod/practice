package algorithms.search;

import java.util.Scanner;

/**
 * You will be given an array of integers and a target value. Determine the number of pairs of array elements that have a difference equal to a target value.

For example, given an array of [1, 2, 3, 4] and a target value of 1, we have three values meeting the condition: 
solution is to sort and then compare hte values from the high to low and look for further elements if diff is <=k
 * @author hemant
 *
 */
public class PairsWithDiffinArr 
{

	static int pairs(int k, int[] arr) 
	{
		int numPairs = 0;
		qSort(arr,0,arr.length-1);
		for(int p= arr.length-1;p>0;p--)
		{
			if(arr[p]-arr[p-1]<=k)
			{
				int j = p-1;
				while(j>=0 && arr[p]-arr[j]<=k)
				{
					if(arr[p]-arr[j]==k)
						numPairs++;
					j--;
				}
			}
		}
		
		return numPairs;
	}
	
	static void qSort(int[] arr, int low, int high)
	{
		if(low<high)
		{
			int pivot = arr[high];
			int j = low-1;
			for(int i = low;i<=high;i++)
			{
				if(arr[i]<=pivot)
				{
					j++;
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
			
			qSort(arr, low, j-1);
			qSort(arr, j+1, high);
		}
	}
    
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = pairs(k, arr);
        System.out.println(result);
        in.close();
    }
}
