package algorithms.strings;

/**
 * GIve a String , find out if the word hackerrank exists in it, in the right sequence 
 Iterate over the input and keep removing the first letter of the String Builder until nothing is left.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindStringInStrings 
{

    static String hackerrankInString(String s) {
        
    	StringBuilder sb  = new StringBuilder("hackerrank");
    	char[] arr = s.toCharArray();
    	for(int i = 0;i<arr.length;i++)
    	{
    		if(arr[i]==sb.charAt(0))
    		{
    			sb = sb.deleteCharAt(0);
    		}
    		if(sb.length()<1)
    			break;
    	}
    	
    	if(sb.length()<1)
    		return "YES";
    	else
    		return "NO";
    }

    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File("C:\\Study\\Algo\\StringInStringsInput.txt");
        Scanner in = new Scanner(file);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = hackerrankInString(s);
            System.out.println(result);
        }
        in.close();
    }

}
