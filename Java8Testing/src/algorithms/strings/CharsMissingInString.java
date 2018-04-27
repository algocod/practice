package algorithms.strings;

import java.util.Scanner;

public class CharsMissingInString
{
    static int marsExploration(String s) {

    	char[] arr = s.toCharArray();
    	int missing = 0;
    	for(int i=0;i<=arr.length-3;i=i+3)
    	{
    		if(arr[i]!='S' )
    			missing++;
    		if(arr[i+1]!='O' )
    			missing++;
    		if(arr[i+2]!='S' )
    			missing++;

    	}
    
    	return missing;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = marsExploration(s);
        System.out.println(result);
        in.close();
    }

}
