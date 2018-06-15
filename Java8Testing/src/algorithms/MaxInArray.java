package algorithms;

import java.util.Arrays;

public class MaxInArray {

	//work out the max k elements in an array of n elements.
	public static void main(String[] args) {

		int arI[] = {21,186,5,11,4,98};
		int mxI[] = new int[3];
		int max = 0;
		int premax=Integer.MAX_VALUE;
		for (int i=0;i<mxI.length;i++)
		{
			max=Integer.MIN_VALUE;
			for (int j:arI)
			{
				if (j>max && j<premax)
					max= j;
			}
			mxI[i]=max;
			premax=max;
		}
		System.out.println(max);
		System.out.println(Arrays.toString(mxI));
	}

}
