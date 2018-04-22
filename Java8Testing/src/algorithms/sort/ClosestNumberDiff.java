package algorithms.sort;
/**
 * Challenge 
Given a list of unsorted integers, , can you find the pair of elements that have the smallest absolute difference between them? If there are multiple pairs, find them all.

Input Format 
The first line of input contains a single integer, , representing the length of array . 
In the second line, there are  space-separated integers, , representing the elements of array .

Output Format 
Output the pairs of elements with the smallest difference. If there are multiple pairs, output all of them in ascending order, all on the same line (consecutively) 
with just a single space between each pair of numbers. If there's a number which lies in two pair, print it two times (see the sample case #3 for explanation).

Key here was sorting the numbers and then finding the duplicate pairs
INNPUT
12
-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470

OUTPUT
-520 -470 -20 30

 */
import java.util.Scanner;

public class ClosestNumberDiff {
	
    static int[] closestNumbers(int[] arr) {
        // first sort the array
        qSort(arr,0,arr.length-1);
        int minDiff = Integer.MAX_VALUE;        
        int[] pair = new int[arr.length];
        for(int i = 1;i<arr.length;i++)
        {
            int tempDiff = arr[i]-arr[i-1];
            if(tempDiff<minDiff)
            {
                minDiff = tempDiff; 
            }
                
        }
        
        int j = 0;
        for(int i = 1;i<arr.length;i++)
        {
            int tempDiff = arr[i]-arr[i-1];
            if(tempDiff==minDiff)
            {
                pair[j] = arr[i-1];
                j++;
                pair[j] = arr[i];
                j++;
            }
                
        }
        
        int[] retarr = new int[j];
        
        for(int k =0;k<j;k++)
        {
            retarr[k] = pair[k];
        }
        
        return retarr;
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
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = closestNumbers(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }


}
