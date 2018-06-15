package algorithms.sort;

public class HeapSorting 
{
	public static void main(String[] args)
	{
		int[] arr = {10,3,6,9,8};
//        int arr[] = {12, 11, 13, 5, 6, 7};

		int mid = arr.length/2 -1;
		for(int i=mid;i>=0;i--)
		{
			heapify(arr,i,arr.length);
		}
		
		for(int i = arr.length-1;i>=0;i--)
		{
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapify(arr,0,i);
		}
		
		for(int j:arr)
			System.out.println(j);
	}
	
	public static void heapify(int[] arr, int start, int end)
	{
		
		int leftI = 2*start+1;
		int rightI = 2*start +2;
		int largest = start;
		if(leftI<end && arr[largest]<arr[leftI])
			largest = leftI;
			
		if(rightI<end && arr[largest]<arr[rightI])
			largest = rightI;
		if(largest!=start)
		{
			int tmp = arr[start];
			arr[start] = arr[largest];
			arr[largest] = tmp;
			heapify(arr,largest,end);
		}
	}

}
