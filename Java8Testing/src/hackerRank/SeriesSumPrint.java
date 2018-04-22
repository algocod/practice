package hackerRank;

import java.util.Scanner;

public class SeriesSumPrint {
	
	static
	{
	    Scanner sc = new Scanner(System.in);
	    int b = 0 ;
	    int h = 0;
	    int area = 0;
	    try
	    {	
	    	String breadth = sc.nextLine();
		    b = Integer.parseInt(breadth);
		    String height = sc.next();
		    h = Integer.parseInt(height);
		        	
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	        if(b<0||h<0)
	        {
	            System.out.println("java.lang.Exception: Breadth and height must be positive");
	        }
	        else
	        {
	            area = b*h;
	            System.out.println(area);
	        }
	}

/**
 * The below method is for calculating the series as below 
 * a + 2^0*b + 2^1*b + .......2^n-1*b
 * @param argh
 */
    public static void main(String []argh){
        int a = 5;
        int b = 3;
        int n = 5;
    	
        int[] ret = new int[8];
        ret = new int[]{};
          StringBuffer sbr = new StringBuffer();
        for(int j=0;j<n;j++)
        {
            int Sum = a + getSum(b,j);
            sbr.append(Sum+" ");
        }
        System.out.println(sbr.toString());
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Integer.parseInt(sc.nextLine());
        int k = 0;
        
        while (sc.hasNext())
        {
        	System.out.println(k+sc.next());
        }
    }
    
    public static int getSum(int b , int i)
    {
        if(i==0)
            return b;
        else
        {
        	int p = (int) (Math.pow(2,i)*b);
        	return p + getSum(b,i-1);
        }
            
    }

}
