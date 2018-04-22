package algorithms.recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SuperDigit {
	
    static long digitSum(long sum) {
        
    	if (sum<10)
    		return sum;
    	else
    	{
    		sum = getSum(sum);
    		return digitSum(sum);
    	}
    	
    }
    
    static long getSum(long sum)
    {
    	long divider = sum/10;
    	long remain = sum%10;
    	
    	if(divider > 0)
    		return remain + getSum(divider);
    	else
    		return remain;
    }

    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File("C:\\Study\\Algo\\RecursiveDivide.txt");
        Scanner in = new Scanner(file);
        String n = in.next();
        int k = in.nextInt();
        long sum = 0;
        for(int i=0;i<n.length();i++)
        {
        	// fix the below problem 
        	String s = n.substring(i, i+1);
        	long temp = Long.parseLong(s);
        	sum = sum + temp;
        }
        sum = sum*k;
        long result = digitSum(sum);
        System.out.println(result);
        in.close();
    }


}
