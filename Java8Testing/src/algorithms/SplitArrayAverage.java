package algorithms;

import java.util.Arrays;

public class SplitArrayAverage {

	public static void main(String[] args) {
		//int[] input = {1,2,3,4,5,6,7,8};
		int[] input = {2,0,5,6,16,12,15,12,4};
		new SplitArrayAverage().splitArraySameAverage(input);

	}

    public boolean splitArraySameAverage(int[] A) 
    {
        Arrays.sort(A);
        int j=A.length-1;
        int sumA=0, sumB=0, sumT=0;
        int cntA=0,cntB=A.length,cntT=A.length;
        double avgA=0.0, avgB=0.0, avgT=0.0;
        for(int a : A)
            sumT +=a;
        
        for(int i =0; i<A.length/2;i++)
        {
            sumA +=A[i] +A[j];
            cntA +=2;
            cntB -=2;
            sumB = sumT-sumA;
            if(cntA==cntB)
                if(sumA/cntA == sumB/cntB)
                {
                    System.out.println("Average matches");
                    return true;
                }
            j--;
            
        }
        
        return false;
    }

	
}
