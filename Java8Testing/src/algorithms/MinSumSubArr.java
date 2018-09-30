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

			System.out.println(minSum);

		}
	
		//System.out.println(minSum);
		System.out.println(gotMin);

	}

}
