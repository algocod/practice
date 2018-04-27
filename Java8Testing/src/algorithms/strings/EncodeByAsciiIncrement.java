package algorithms.strings;
/**
 * Encode the given set of letters by moving them K forward. If they reach end like Z or z, then move back to a or A.
 * SPecial characters to be not rotated.
 The key here was adding the modulus of 26 to the difference. 
 */
import java.util.Scanner;

public class EncodeByAsciiIncrement 
{
    static String caesarCipher(String s, int k) {

    	char[] arr = s.toCharArray();
    	for(int i=0;i<arr.length;i++)
    	{
    		if(arr[i]>=97 && arr[i]<=122)
    		{
    			int asc = arr[i];
    			asc = asc + k;
    			if (asc >122)
    			{
    				if((asc -122)%26==0)
    					asc = 122;
    				else
    					asc = (asc -122)%26 +96;	
    			}
    				
    			arr[i] = (char)asc;
    		}
    		else if (arr[i]>=65 && arr[i]<=90)
    		{

    			int asc = arr[i];
    			asc = asc + k;
    			if (asc >90)
    			{
    				if((asc -90)%26 ==0)
    					asc = 90;
    				else
    					asc = (asc -90)%26 +64;	
    			}
    				
    			arr[i] = (char)asc;
    		
    		}
    	}
    	
    	return String.valueOf(arr);
    	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        String result = caesarCipher(s, k);
        String expected = "!w-bL`-yX!.G`mVKmFlX/MaCyyvSS!CSwts.!g/`He`eJk1DGZBa`eBLdyu`hZD`vV-jZDm.LCBSre..-!.!dmv!-E";
        String actual   = "!w-bL`-yX!.G`mVKmFlX/MaCyyvSS!CSwts.!g/`He`eJk1DG@Ba`eBLdyu`h@D`vV-j@Dm.LCBSre..-!.!dmv!-E";
        String input    = "!m-rB`-oN!.W`cLAcVbN/CqSoolII!SImji.!w/`Xu`uZa1TWPRq`uRBtok`xPT`lL-zPTc.BSRIhu..-!.!tcl!-U";

        System.out.println(result);
        System.out.println(result.equals(expected));
        in.close();
    }


}
