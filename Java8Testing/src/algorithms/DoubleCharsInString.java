package algorithms;
/**
 * Remove all consecutive characters from a String.
 */
import java.util.Scanner;

public class DoubleCharsInString 
{
    static String super_reduced_string(String s){
    	// find the double characters
    	String ret =  findDoubles(s);
    	if(ret!=null && ret.length()<1)
    		ret = "EMPTY STRING";
    	
    	char[] chAr = s.toCharArray();
    	int totalNum = 0;
    	for(char ch:chAr)
    	{
    		if(Character.isUpperCase(ch))
    			totalNum++;
    	}
    	
    	return ret;
    }
    
    static String findDoubles(String s)
    {
    	String ret = "";
    	int conP=0;
    	StringBuilder sb = new StringBuilder();
    	boolean hasDoubles = false;
    	for(int i=0;i<s.length()-1;i++)
    	{
    		char left = s.charAt(i);
    		char right = s.charAt(i+1);
    		if(left==right)
    		{
    			conP=i;
    			hasDoubles = true;
    			sb.append(s.substring(0,conP)).append(s.substring(conP+2,s.length()));
    			break;
    		}
    	}
    	if(!hasDoubles)
    		ret = s;
    	else
    	{

        	String temp = sb.toString();
        	if(temp!=null)
        		ret = findDoubles(temp);	
    	}
    	
    	return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }


}
