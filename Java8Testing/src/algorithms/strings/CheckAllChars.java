package algorithms.strings;

public class CheckAllChars 
{

	  static String pangrams(String s) {
	        String isAna = "pangram";
	    	int[] arr = new int[26];
	    	char[] arC = s.toCharArray();
	    	for(int i=0;i<arC.length;i++)
	    	{
	    		char c = arC[i];
	    		c = Character.toLowerCase(c);
	    		int asciV = c;
	    		if(asciV>=97 && asciV<=122)
	    		{
		            if(arr[asciV-97]==0)
		    		    arr[asciV-97]++;	
	    		}
	    	}

	        for(int i=0;i<arr.length;i++)
	    	{
	    		if(arr[i]==0)
	            {
	                isAna = "not pangram";
	                break;
	            }
	                
	    	}

	        return isAna;
	    }

	    public static void main(String[] args)  {

	        String s = "We promptly judged antique ivory buckles for the next prize";
	        String s2 = "The quick brown fox jumps over the laz dog";
	        String result = pangrams(s);
	        System.out.println(result);
	         result = pangrams(s2);
	        System.out.println(result);
	    }
}
