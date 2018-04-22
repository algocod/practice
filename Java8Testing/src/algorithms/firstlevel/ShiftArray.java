package algorithms.firstlevel;
/**
 * SHift the array by k bits and print it out
 * input is size and k bits and array
8 3
2 2 2 2 2 3 3 3
1 2 3 4 5 6 7 8
  
 output
 6 7 8 1 2 3 4 5
 */
import java.util.Scanner;

public class ShiftArray {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
               a[a_i] = in.nextInt();
            }
        
        int [] result = shiftArray(n, a, k);
        for (int i = 0;i<n;i++)
        {
        	System.out.print(result[i]+" ");
        }
        in.close();
        
        }
	
	public static int[] shiftArray(int n ,int[] arr, int k)
	{
		int[] kbit = new int[k];
		
		// copy the last k elements to a diff array
		for(int i=n-k,j=0;i<n;i++,j++)
		{
			kbit[j] = arr[i];
		}
		
		// now shift the elements 
		for(int i=n-1;i>=k;i--)
		{
			arr[i]=arr[i-k];
		}
		
		// now fill the first k elements from the array copied earlier
		for (int i = 0; i<k;i++)
		{
			arr[i]=kbit[i];
		}
		
		return arr;
	}
}
	
