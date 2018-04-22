package algorithms.firstlevel;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {
	
	  static void plusMinus(int[] arr, int n) {
	        
	        int jP=0;
	        int jN=0;
	        int j0 = 0;
	        for(int i =0;i<n;i++)
	        {
	            if(arr[i]==0)
	                j0++;
	            else if (arr[i]>0)
	                jP++;
	            else
	                jN++;
	            
	        }
	        
	        double dP = (jP*1.0)/(n*1.0);
	        double dN = (jN*1.0)/(n*1.0);
	        double d0=  (j0*1.0)/(n*1.0);
	        
	        DecimalFormat df = new DecimalFormat("###.######");
	    	System.out.println(df.format(dP));
	        System.out.println(df.format(dN));    
	        System.out.println(df.format(d0));    
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] arr = new int[n];
	        for(int arr_i = 0; arr_i < n; arr_i++){
	            arr[arr_i] = in.nextInt();
	        }
	        plusMinus(arr,n);
	        in.close();
	    }


}
