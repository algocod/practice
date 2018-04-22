package algorithms.firstlevel;

import java.util.Scanner;

/**
 * Find total such sub arrays where the sum of K continuous elements in an array is P
 * The below solution solves it in O(n)
5
1 2 1 3 2 
3 2

Ans = 2 , there are two such sub arrays whose 2 contiguous elements have sum 3 

6
1 1 1 1 1 1
3 2

Ans = 0 , no such elements 
 * @author hemant
 *
 */
public class SumOfKElementsArray {

	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] s = new int[n];
	        for(int s_i=0; s_i < n; s_i++){
	            s[s_i] = in.nextInt();
	        }
	        int d = in.nextInt();
	        int m = in.nextInt();
	        int result = solve(n, s, d, m);
	        System.out.println(result);
	    }
	   
	   public static int solve(int n, int[] s, int d, int m){
	     int tc=0;
	     int kSum = 0;
	     for(int i=0;i<m;i++)
	     {
	    	 kSum = kSum +s[i];
	     }
	     if(kSum==d)
	    	 tc++;
	     
	     for(int j =m, i =0;j<n;j++,i++)
	     {
	    	 kSum = kSum + s[j]-s[i]; // drop the first element and add the last
	    	 if(kSum==d)
		    	 tc++;
	     }
	     
	     return tc;
	    }
}
