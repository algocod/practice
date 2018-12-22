package algorithms.strings;

public class SubsequenceOfString {

	public static void main(String[] args) {

		String S = "wcbsuiyzacfgrqsqsnodwmxzkz";
		String T = "xwqe";
		//String S ="abcdebdde";
		//String T ="bde";
		String result = minWindow(S,T);
		System.out.println("-----------------------"+result);
	}
	
    public static String minWindow(String S, String T) 
    {
        char[] main = S.toCharArray();
        char[] sub = T.toCharArray();
        int j = 0;
        int begin=-1;
        int end = 0;
        boolean matchFound = false;
        for(int i =0;i<sub.length;i++)
        {
            char temp = sub[i];
           matchFound  = false;
            while(j<main.length)
            {
                if(temp==main[j])
                {
                	if(begin==-1)
                		begin = j;
                	matchFound = true;
                	break;
                }
                    
                j++;
            }
            
            if(!matchFound)
            	break;
        }
        
        if(matchFound && begin>=0 && j>=0)
            return S.substring(begin,j+1);
        else
            return "";
        
    }

}
