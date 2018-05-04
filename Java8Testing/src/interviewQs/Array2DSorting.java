package interviewQs;
/**
 * sort a 2d array based on the second row elements. This comes useful when you have to sort a given array based on its derived values.
 * Like sort the array based on the frequency of numbers present in the array. 
 */
import java.util.Scanner;

public class Array2DSorting 
{
	
	public static void main (String[] args)
	{
		//Scanner sc = new Scanner(System.in);
		int[] arr = {5,2,6,8,1,3};
		int[][] arr2d = {{5,2, 6, 8, 1, 3}, 
						{93,92,91,90,95,96}};
		int[] toSort = arr2d[1];
		int[] upperRow = arr2d[0];
				
		qSort2D(toSort, arr2d, 0, arr.length-1);
		for(int i:toSort)
		{
			System.out.println(i);
		}
		for(int i:upperRow)
		{
			System.out.println(i);
		}
	}
	
	public static void qSort2D(int[] arr, int[][] parent,int low, int high)
	{
		if(low<high)
		{
			int pivot = high;
			int j = low-1;
			for(int i=low;i<=high;i++)
			{
				if(arr[i]<=arr[pivot])
				{
					j++;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
					// swap the coumn values
					int tm = parent[0][i];
					parent[0][i] = parent[0][j];
					parent[0][j] = tm;
				}
			}
			
			qSort2D(arr, parent,low, j-1);
			qSort2D(arr, parent,j+1, high);
		}
	}
	
}
