package algorithms.firstlevel;

import java.util.Scanner;

/**
 * Compare three numbers to each other like a0, a1,a2 with b0,b1,b2 in the same order for e.g.
 * a0 with b0 
 * if a>b then a gets a point else b gets a point
 * if they are equal nobody gets a point
 * 
 * @author hemant
 *
 */
public class CompareTriplets {

    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
        int[] alice = new int[3];
        int[] bob = new int[3];
        
        if(a0>b0)
        	alice[0]=1;
        else if(b0>a0)
        	bob[0]=1;
        
        if(a1>b1)
        	alice[1]=1;
        else if(b1>a1)
        	bob[1]=1;
        
        if(a2>b2)
        	alice[2]=1;
        else if(b2>a2)
        	bob[2]=1;
        
        int ap = 0;
        for(int i =0;i<alice.length;i++)
        {
        	ap = ap+alice[i];
        }
        int bp = 0;
        for(int i =0;i<bob.length;i++)
        {
        	bp = bp+bob[i];
        }
        int[] appts = new int[2];
        appts[0]=ap;
        appts[1] = bp;
        
        return appts;
   }

   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int a0 = in.nextInt();
       int a1 = in.nextInt();
       int a2 = in.nextInt();
       int b0 = in.nextInt();
       int b1 = in.nextInt();
       int b2 = in.nextInt();
       int[] result = solve(a0, a1, a2, b0, b1, b2);
       for (int i = 0; i < result.length; i++) {
           System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
       }
       System.out.println("");
       

   }

}
