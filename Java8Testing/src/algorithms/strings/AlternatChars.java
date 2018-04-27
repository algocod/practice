package algorithms.strings;
/**
 * In this challenge, you will be given a string. You must remove characters until the string is made up of any two alternating characters. When you choose a character to remove, all instances of that character must be removed. Your goal is to create the longest string possible that contains just two alternating letters.

As an example, consider the string abaacdabd. If you delete the character a, you will be left with the string bcdbd. Now, removing the character c leaves you with a valid string bdbd having a length of 4. Removing either b or d at any point would not result in a valid string.

Given a string , convert it to the longest possible string  made up only of altrenating characters. Print the length of string  on a new line. If no string  can be formed, print  instead.

// REMAINS PARTIALLY SOLVED
 10
beabeefeab

5

The base test case works where only two chars are left behind post removal exercise.
 */
import java.util.Scanner;

public class AlternatChars 
{
    static int twoCharaters(String s) {
    	int[] arr = new int[26];
    	char[] arC = s.toCharArray();
    	for(int i=0;i<arC.length;i++)
    	{
    		int asciV = arC[i];
    		arr[asciV-97]++;
    	}
    
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<arC.length;i++)
    	{
    		int asciV = arC[i];
    		// remove single occurrences
    		if(arr[asciV-97]>1)
    			sb.append(arC[i]);
    	}
    	String sd = sb.toString();
    	arC = sd.toCharArray();
    	arr = new int[26];
    	for(int i=0;i<arC.length-1;i++)
    	{
    		int asciV = arC[i];
    		if(arC[i]==arC[i+1])
    			arr[asciV-97]++;
    	}
    	sb = new StringBuilder();
    	for(int i=0;i<arC.length;i++)
    	{
    		int asciV = arC[i];
    		// remove single occurrences
    		if(arr[asciV-97]<1)
    			sb.append(arC[i]);
    	}
    	
    	String altPre = sb.toString();
    	arC = altPre.toCharArray();
    	arr = new int[26];
    	boolean matchFound = true;
    	for(int i=0;i<arC.length-2;i++)
    	{
    		int asciV = arC[i];
    		arr[asciV-97]++;
   			if(arC[i]!=arC[i+2])
   				matchFound = false;
    	}
    	if(!matchFound)
    	{
    		for(int i=0;i<arC.length-1;i++)
        	{
        		int asciV = arC[i];
        		int len = arr[asciV-97];
       		//	if((arr[arC[i]-97] - arr[arC[i+1]-97])==1 || (arr[arC[i]-97] - arr[arC[i+1]-97])==-1)
        	}	
    	}
    	
    	return altPre.length();
    }

    static String makeString(char a, char b, char[] arc)
    {
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<arc.length;i++)
    	{
    		if(arc[i]==a || arc[i]==b)
    			sb.append(arc[i]);
    	}
    	
    	return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        int result = twoCharaters(s);
        System.out.println(result);
        in.close();
    }


}
