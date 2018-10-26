
/**
 * Count the number of splits in an array where the three contiguous elements are in incremental fashion with equal difference . for e.g.
 * 2 4 6 8 is one such example or 1 2 3 4 5
 * DP is being used below to calculate the cumulative number of slices so dp[i] = 1 + dp[i-1];
 * for array 1 2 3 4 we start at 3 means one slice , once we move to 4 , another slice is added hence total is 1 +1 = 2;
 */
package techcmpprep;

public class ArithmeticSliceinArray 
{
	
	public static void main (String[] args)
	{
		int[] a = {1,2,3,7,4,5,6};
		int result = numberOfArithmeticSlices(a);
		System.out.println(result);
	}
	
	 public static int numberOfArithmeticSlices(int[] A) {
	        int[] dp = new int[A.length];
	        int sum = 0;
	        for (int i = 2; i < dp.length; i++) {
	            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
	                dp[i] = 1 + dp[i - 1];
	                sum += dp[i];
	            }
	        }
	        return sum;
	    }

}
