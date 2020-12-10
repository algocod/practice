package algorithms.graph;
import java.util.*;


public class RemInValidPrnthAllAnsStrings {


public List<String> ans = new ArrayList<>();
 public Set<String> unq = new HashSet<>();
 Integer maxLen = 0;
 
	public static void main(String[] args) {

		String input = "()())()";
		String output = "()()(), (())()";
		List<String> ans = new RemInValidPrnthAllAnsStrings().removeInvalidParentheses(input);
		System.out.println(ans);
		
	}
	    
	    public List<String> removeInvalidParentheses(String s) {
	        // helper(s,0); // for dfs 
	        helperBFS(s);
	        if(ans.size()<1)
	            ans.add("");
	        return ans;
	        
	    }
	   
	   // All combinations via BFS which is replacing each parenthesis one at a time unlike the DFS below which used to go in depth with the same string.  
	    public void helperBFS(String s)
	    {
	        Queue<String> q = new LinkedList<>();
	        q.add(s);
	        unq.add(s); // this is the visited set 
	        boolean found = false; // this is a very key control as in once the correct value has been found at a length , it skips the rest of the 
	        // BFS levels as in it doesnt go any deeper.
	        while (!q.isEmpty())
	        {
	            s = q.poll();
	         
	            if(isValidArr(s.toCharArray()))
	            {
	                ans.add(s);
	                found = true;
	            }
	            
	            if(found)
	                continue; 
	            for(int i=0;i<s.length();i++)
	            {
	                if(s.charAt(i)!='(' && s.charAt(i)!=')')
	                    continue;
	                String next = s.substring(0,i) + s.substring(i+1);
	                if(!unq.contains(next))
	                {
	                    q.add(next);
	                    unq.add(next);
	                }
	            }
	        }
	    }
	    
	    
	    // helper function checks if string s contains valid parantheses
	    public boolean isValidArr(char[] arr)
	    {
	        int sum = 0;
	        for(int i =0;i<arr.length;i++)
	        {
	            if(sum <=-1)
	                return false;
	            if(arr[i]=='(')
	                sum+=1;
	            else if (arr[i]==')')
	                sum-=1;
	            else
	                continue;
	        }
	        
	        return sum==0?true:false;
	            
	    }
	    

	    // the below is the brute force DFS where all possible combinations are being checked which is 2^N a very costly process.
	    // although it goes to all possible smaller solutions. 
	    public void helper(String s, int i)
	    {
	        if(i>=s.length())
	            return;
	        if(isValidArr(s.toCharArray()))
	        {
	            StringBuffer sb = new StringBuffer();
	            for(char c : s.toCharArray())
	                if(c!='*')
	                    sb.append(c);
	            //System.out.println("Answer length--"+sb.toString().length());
	           // System.out.println("actual string length--"+s.length());
	            if(sb.toString().length() >=maxLen)
	            {
	                //ans.add(sb.toString());
	                unq.add(sb.toString());
	                maxLen = Math.max(maxLen,sb.toString().length());
	            }
	            
	            return;
	        }
	        
	        char[] arr = s.toCharArray();
	        int next = i+1;
	        helper(String.valueOf(arr),next);
	        while(i<arr.length)
	        {
	            if(arr[i]=='(' || arr[i]==')')
	            {
	                arr[i] = '*';
	                break;
	            }
	            i++;
	        }
	        
	        helper(String.valueOf(arr),i++);
	        
	    }
	
}
