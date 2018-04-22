package algorithms;

public class MinSumSubArr {

	public static void main(String[] args) {

		int[] arI = {3,1,-1,2,8,-1,-2,9};
		int minSum = arI[0];
		int gotMin = arI[0];
		
		for(int j = 1;j<arI.length;j++)
		{
			if(arI[j]>0)
				minSum=arI[j];
			else
				minSum = minSum+arI[j];
			
			if(minSum<gotMin)
				gotMin=minSum;
			
			/* this is the solution for minimum sum across a lenght of k size array, refine it though
			if(minSum>minSum+arI[j])
			{
				minSum = minSum+arI[j]-arI[j-1];
				if(minSum<gotMin)
					gotMin = minSum;
			}
				
			else if (minSum<minSum+arI[j])
			{
				if(minSum<gotMin)
					gotMin = minSum;
				minSum = arI[j];
			}
				**/
			System.out.println(minSum);

		}
	
		System.out.println(minSum);
		System.out.println(gotMin);

	}

}
