package algorithms.strings;
/**
 * s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
 * @author hemant
 *
 */
public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = new WildcardMatching().isMatch("aa", "a");
		System.out.println(res); // false
	}

    public boolean isMatch(String s, String p) {
        
        int i=0,j=0,star=-1,lastmatch = 0;
        while(j<s.length())
        {
            if(i<p.length() && (p.charAt(i)==s.charAt(j) || p.charAt(i)=='?'))
            {
                i++;
                j++;
                
            }
            else if (i<p.length() && p.charAt(i)=='*'){
                star = i;
                lastmatch = j;
                i++;
                
           }
            else if (star>=0 ) // if both chars are not matching then keeping looking for the next match from the last matched character as in j
            {
                i = star +1;
                lastmatch++;
                j = lastmatch;
            }
            
            else
                return false;
            
        }
        
        //check for remaining characters in pattern
       while (i < p.length() && p.charAt(i) == '*')
           i++;
        return i==p.length()?true:false;
    }
      
   // the below dP way solves 1792 test cases out of a total 1809 
   // attempt a linear way to solve it.
   public boolean isMatchDP(String s, String p) {
       if(s==null)
           return true;
       if(s.length()<1 && p.length()<1)
           return true;
       if(s.length()<1 && onlyStars(p))
           return true;
       if(s.length()<1 && !onlyStars(p))
           return false;
        if(s.length()>=1 && p.length()<1)
           return false;
       
       if(p.length()>s.length() && onlyStars(p.substring(s.length(),p.length())))
           p = p.substring(0,s.length());
           
       
       int[][] mat = new int[p.length()][s.length()];
       
       for(int i=0;i<p.length();i++)
       {
           char col = p.charAt(i);
           for(int j=0; j<s.length();j++)
           {
               if(col=='*')
                   mat[i][j]=2;
               else if(col==s.charAt(j))
                   mat[i][j]=1;
               else if(col=='?')
                   mat[i][j]=1;
               else
                   continue;
                   
           }
           
       }
       

       if(exists(mat,0,0,mat.length,mat[0].length))
          return true;        
       return false;
   }
   
   public boolean onlyStars(String p)
   {
       for(char c : p.toCharArray()){
           if(c!='*')
               return false;
       }
           
       return true;
   }
   
   
   
   public boolean exists(int[][] adj, int i, int j , int row, int col)
   {
       if(i >=row || j >=col || adj[i][j]==0 )
           return false;
       
       if(i==row-1 && j==col-1 && (adj[i][j]==1 || adj[i][j]==2))
           return true;
       
       if(adj[i][j]==1)
          {
              boolean next = exists(adj,i+1,j+1,row,col);
              adj[i][j] =0;
              return next;
           }
          else
          {
              boolean next = exists(adj,i+1,j+1,row,col);
              boolean right = exists(adj,i,j+1,row,col);
              boolean bottom = exists(adj,i+1,j,row,col);
              adj[i][j] =0;
              return next|| right || bottom;
           }
   }
	
}
