package techcmpprep;

import java.util.Arrays;

public class HIndexForAuthor {

	public static int maxh = 0;
	public static void main(String[] args) {

		int[] arr = {3,0,1,6,5};
		int[] arr2= {4,5,2,3,6,1,8};
		getIndex(arr2);
		System.out.println(maxh);
	}
	
	public static void getIndex(int[] arr)
	{
		Arrays.sort(arr);
		for(int i = arr.length-1;i>=0;i--)
		{
			if(arr[i]<=arr.length)
			{
				if(arr[i]==(arr.length-1-i+1))
					maxh = Math.max(arr[i], maxh);
			}
		}
		
		int j=0;
		// scanning from top to bottom which is the end of the array to beginning.
		while(j<arr.length && arr[arr.length-1-j]>j)
		{
			j++;
		}
		// the +1 happens while exiting the loop
		// return j;
	}

}
