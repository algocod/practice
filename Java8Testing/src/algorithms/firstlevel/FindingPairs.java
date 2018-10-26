package algorithms.firstlevel;
/**
 * Find the total number of pairs available in the array for e.g. 10 20 30 20 10 20 there are two pairs 10,10 and 20,20
 *  and in addition of 20 30 which are not an array
9
10 20 20 10 10 30 50 10 20

Answer = 3 
 */
import java.util.Scanner;

public class FindingPairs {

	public static int sockMerchant(int n, int[] ar) {
		int[] tpairs = new int[n];
		for(int j=0;j<ar.length;j++)
		{
			int k = ar[j];
			tpairs[k-1]++;
		}
		int totalN = 0;
		for(int k =0;k<n;k++)
		{
			if(tpairs[k]>0)
			{
				tpairs[k] = tpairs[k]/2;
			}
			
			totalN = totalN + tpairs[k];
		}
		
		
		return totalN;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int max = getMax(ar);
        int result = sockMerchant(max, ar);
        System.out.println(result);
    }
    
    static int getMax(int[] ar)
    {
    	int im =0;
    	for(int i=0;i<ar.length;i++)
    	{
    		if(ar[i]>im)
    			im = ar[i];
    	}
    	
    	return im;
    }
	
	
}
