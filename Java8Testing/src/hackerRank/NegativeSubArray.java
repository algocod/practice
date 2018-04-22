package hackerRank;

import java.util.Scanner;

public class NegativeSubArray {

	/**
	 * Total count of sub arrays whose sum is negative including the element itself so we.g. [-2] is one and then [-2,4,-5] is another
	 * 5
	1 -2 4 -5 1
9 -- Answer
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] arr = new int[num];
		for (int i = 0;i<num;i++)
		{
			arr[i] = in.nextInt();
		}
		
		int nSubArr = 0;
		for(int j =0;j<num;j++)
		{
			int subSum=0;
			
			for(int k =j;k<num;k++)
			{
				subSum = subSum + arr[k];
				if (subSum<0)
				{
					nSubArr++;
				}
					
			}
		}
		
		System.out.println(nSubArr);
	}

}
