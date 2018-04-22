package algorithms.sort;
/**
 * Insertion Sort : Start with the first element of the array and then take up next and sort . Keep taking elements one by one and find its right place in the inner array
 * This way this sort works like a sorted array + the next unsorted element , shift each element to find the right spot. 
5
2 4 6 8 3

10
2 3 4 5 6 7 8 9 10 1

Output:

2 4 6 8 8 
2 4 6 6 8 
2 4 4 6 8 
2 3 4 6 8

The trick here is to print the exact number of lines as well so once the element has found its spot, it has to  exit the loop or in case of 
1st element it has to come out and print again.

 */

import java.util.Scanner;

public class InsertionSortPart1 {
	
    static void insertionSort1(int n, int[] arr) {
        
        int toSort = arr[n-1];
        
        boolean assigned = false;
        for(int i=n-2;i>=0;i--)
        {
        	
        	if(arr[i]>toSort)
            {
                arr[i+1] = arr[i];
            }
            else
            {
            	arr[i+1] = toSort;
            	assigned = true;
            }
                
            
            for(int j = 0;j<arr.length;j++)
            {
                System.out.print(arr[j]+" ");
            }
            
            if(assigned)
            	break;
            
            System.out.print("\n");
        }
        // this must be the smallest element to be put in first place
        if(!assigned)
        {
             arr[0]=toSort;
             for(int j = 0;j<arr.length;j++)
             {
                 System.out.print(arr[j]+" ");
             }
        }
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort1(n, arr);
        in.close();
    }


}
