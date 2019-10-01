package algorithms.strings;

public class KSimilarStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KSimilarStrings().kSimilarity("bccaba", "abacbc"); //3
		new KSimilarStrings().kSimilarity("abccaacceecdeea", "bcaacceeccdeaae"); //3
		
	}

	   public int kSimilarity(String A, String B) 
	    {
	        char[] a1 = A.toCharArray();
	        char[] b1 = B.toCharArray();
	        int k =0;
	        for(int i = 0;i<a1.length;i++)
	        {
	            if(a1[i]==b1[i])
	                continue;
	            else
	            {
	                int j =i+1;
	                while(j<a1.length)
	                {
	                    if(b1[i]==a1[j])
	                    {
	                        k++;
	                        //swap chars
	                        char tmp = a1[i];
	                        a1[i] = a1[j];
	                        a1[j] = tmp;
	                        break;
	                    }
	                    j++;
	                }
	            }
	        }
	        return k;
	    }
	
}
