package hackerRank;

import java.util.Scanner;

public class InsertDeleteInArray {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
	        int q = scan.nextInt();
        	int[] ret = arr;
	        while(q-- > 0)
	        {
	        	String ops = scan.next();
	        	if(ops.equalsIgnoreCase("Insert"))
	        	{
	        		int index = scan.nextInt();
	        		int eleAdd = scan.nextInt();
	        		ret = addOps(ret,index,eleAdd);
	        		
	        		
	        	}
	        	else if (ops.equalsIgnoreCase("Delete"))
	        	{
	        		int eleDel = scan.nextInt();
	        		ret = delOps(ret,eleDel);
	        		
	        	}
	        	
	        	
	        }
    		printArray(ret);

	        scan.close();

	}
	
	public static void printArray(int[] arr)
	{
		for(int i = 0 ;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	public static int[] addOps(int[] arr, int indx, int ele)
	{
		int[] ret = null;
		// setup boundary cases first
		if(indx > arr.length +1-1) // to accommodate for increaes in size and then n-1 for array index
			System.out.println("Cant Add");
		if(arr.length==0)
		{
			ret = new int[1];
			ret[0] = ele;
		}
		
		ret = new int[arr.length+1];
		for(int i = 0,k=0;i<arr.length;i++,k++)
		{
			ret[k]=arr[i];
			if(k==indx-1)
			{
				ret[k+1]=ele;
				k++;
			}
		}
		return ret;
	}
	
	public static int[] delOps(int[] arr , int indx)
	{
		int[] ret = null;
		if(arr.length==0)
			System.out.println("Cant Delete");
		if(arr.length==1)
			ret = new int[0];
		
		ret = new int[arr.length-1];
		for(int i=0,k=0;i<arr.length;i++)
		{
			if(i==indx);
			else
			{
				ret[k] = arr[i];
				k++;
			}
				
		}
		
		return ret;
	}

}
