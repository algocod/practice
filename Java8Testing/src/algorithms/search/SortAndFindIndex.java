package algorithms.search;
/**
 *
Sunny and Johnny like to pool their money and go to the ice cream parlor. Johnny never buys the same flavor that Sunny does. The only other rule they have is that they spend all of their money.

Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.

Complete the function icecreamParlor below to return an array containing the indexes of the prices of the two flavors they buy. The returned array must be sorted ascending.

Input Format

The first line contains an integer, , denoting the number of trips to the ice cream parlor. The next  sets of lines each describe a visit. Each trip is described as follows:

The integer , the amount of money they have pooled.
The integer , the number of flavors offered at the time.
 space-separated integers denoting the cost of each flavor: .
Note: The index within the cost array represents the flavor of the ice cream purchased.

Constraints
There will always be a unique solution.
Output Format

For each test case, print two space-separated integers denoting the indexes of the two flavors purchased, in ascending order.

Sample Input

2
4
5
1 4 5 3 2
4
4
2 2 4 3
Sample Output

1 4
1 2
 */
import java.util.Scanner;

public class SortAndFindIndex 
{
    static int[] icecreamParlor(int m, int[] arr) {
        // make a copy of this array first and then sort
    	int[] tobeSorted = arr.clone();
    	qSort(tobeSorted,0,arr.length-1);
    	int c1 = 0;
    	int c2= 0;
    	boolean sumFound = false;
    	for(int k = arr.length-1; k>0;k--)
    	{
    		if(tobeSorted[k]<m)
    		{
    			c1 = tobeSorted[k];
    			for(int p =k-1;p>=0;p--)
    			{
    				c2 = tobeSorted[p];
    				if(c1+c2==m)
    				{
    					sumFound = true;
    					break;
    				}
    			}
    			if(sumFound)
    				break;
    		}
    	}
    	
    	// now find the indexes in the original array
    	boolean sameValue = false;
    	if(c1==c2)
    		sameValue = true;
    	int c1Ind = 0;
    	int c2Ind = 0;
    	int k = 0;
    	while (k<arr.length)
    	{
    		if(arr[k]==c1)
    		{
    			c1Ind = k;
    			break;
    		}
    			
    		k++;
    	}
    	
    	if(sameValue)
    		k=c1Ind+1;
    	else
    		k=0;
    	while (k<arr.length)
    	{
			if(arr[k]==c2)
    		{
    			c2Ind = k;
    			break;
    		}		
    		k++;
    	}
    	
    	int[] ind = new int[2];
    	if(c1Ind<c2Ind)
    	{
    		ind[0] = c1Ind+1;
    		ind[1] = c2Ind+1;
    	}
    	else
    	{

    		ind[1] = c1Ind+1;
    		ind[0] = c2Ind+1;
    	}
    		
    	return ind;
    }

    static void qSort(int[] arr, int low, int high)
    {
    	if(low<high)
    	{
    		int pivot = arr[high];
    		int j = low-1;
    		for(int i=low;i<=high;i++)
    		{
    			if(arr[i]<=pivot)
    			{
    				j++;
    				int temp = arr[j];
    				arr[j] = arr[i];
    				arr[i] = temp;
    			}
    		}
    		
    		qSort(arr,low,j-1);
    		qSort(arr,j+1,high);
    	}
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = icecreamParlor(m, arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }


}
