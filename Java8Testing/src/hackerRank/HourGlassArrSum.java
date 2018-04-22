package hackerRank;

import java.util.Scanner;

import concurrency.Adult;
import concurrency.Child;
import concurrency.Person;

public class HourGlassArrSum {

	public static void main(String[] args) {
		
		// below are some testing code snippets
		
		Person p = new Person(100,"A", "M");
		Child cp = new Child(8,"B","F");
		Adult ad = new Adult(21,"C","M");
		try
		{
			//c=ad;
		}
		catch(NullPointerException ne ) // Null and ClassNFE can be handled and are Unchecked and Checked exceptions
		{
			
		}
		/*The below is hour glass sum in an array of 1 01 01 Max possible sums of all such glass hours, the numbers can be from -1 to 9 
		 * hence i have put the min sum as -64 which -9*7 +1 
		1 1 0 1
		0 1 0 1
		1 0 1 1
		*/
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        int maxSum = -64;
        int currSum = -64;
        /*
        for(int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
            	System.out.println(i+" "+j + "  "+arr[i][j]);
            }
        }
        */
        for(int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
            	int a = arr[i][j];
            	int b = arr[i][j+1];
            	int c = arr[i][j+2];
            	int d = arr[i+1][j+1];
            	int e = arr[i+2][j] ;
            	int f = arr[i+2][j+1];
            	int g = arr[i+2][j+2];
            	
                 currSum =  a + b  + c + d + e + f +g ; 
                 if(currSum>=maxSum)
                     maxSum = currSum;
            }
        }
        
        System.out.println(maxSum);
        
    }

}
