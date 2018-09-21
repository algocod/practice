package algorithms.firstlevel;

public class RecursiveSumArr {

	/**
	 * Calculate the sum of numbers in an Array using Recursion
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] intar = {23,12,54,65,87,11};
		
		for(int j = 0;j<intar.length;j++)
		{
			
		}
		
		int totalSum = sum(intar,0);
		System.out.println(totalSum);
	}
	
	public static int sum(int[] ar, int offset)
	{
		if (offset==ar.length)
			return ar[offset-1];
		else 
			return ar[offset] + sum (ar,offset+1);
	}

}
