package algorithms.sort;
/**
 * This class implements the Insertion sort , starting from the 2nd element from the left. It starts comparing with previous element and puts it in right place.
 * So it iterates over every sub array, sorts it and then moves to next element so which is like sorted array plus one element. Input and Output below
6
1 4 3 5 6 2

1 4 3 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 2 3 4 5 6 
 * 
 */
import java.util.Scanner;

public class InsertionSortPart2 {
	
    static void insertionSort2(int n, int[] arr) {
    	
    	for(int i =1;i<n;i++)
    	{
    		int ele = arr[i];
    		for(int j = i;j>0;j--)
    		{
    			if(arr[j]<arr[j-1])
    			{
    				arr[j] = arr[j-1];
    				arr[j-1] = ele;
    			}
    		}
    		// print the array
    		for(int k =0;k<n;k++)
    		{
    			System.out.print(arr[k]+" ");
    		}
    		System.out.print("\n");
    	}
    	
    
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort2(n, arr);
        in.close();
    }


}
