package algorithms.firstlevel;

import java.util.Scanner;

/**
 * Print a staircase for a given n like for 4
 *    #
 *   ##
 *  ### 
 * ####
 * 
 * @author hemant
 *
 */
public class Staircase {
	
	static void staircase(int n) {
		String space = "";
		String hash = "";
		for(int i=0;i<n;i++)
		{
			space = space+" ";
			hash = hash+"#";
		}
		int k = n-1;
        for(int i=0;i<n;i++)
        {
        	String spax = space.substring(0,k-i);
        	String hashx = "";
        	if(i!=k)
        		hashx = hash.substring(k-i-1, k);
        	else
        		hashx = hash;
        	System.out.println(spax+hashx);
        }
		
		
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }

}
