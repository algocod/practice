package algorithms;

import java.util.ArrayList;

public class QuickSortAlgo {

	public static void main(String[] args) {

		Integer[] objArr= {5,2,6,3,8,1,9};
		int[] arr = {9,2,6,3,8,1,5};	
		// take the last element as pivot
        ArrayList al = new ArrayList();
		qSort(arr,0,arr.length-1);
		for(int k =0;k<arr.length;k++)
		{
			System.out.print(arr[k]+" ");
		}
		System.out.print("\n");
		
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
				// print the array
				
	    		for(int k =0;k<arr.length;k++)
	    		{
	    			System.out.print(arr[k]+" ");
	    		}
	    		System.out.print("\n");
	    		
			}

			qSort(arr,low,j-1);
			qSort(arr,j+1,high);	
		}
		
	}

}
