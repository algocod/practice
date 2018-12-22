package algorithms.strings;

import java.util.*;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		String input = "()())()";
		
		List result = removeInvalidParentheses(input);

	}

    public static List<String> removeInvalidParentheses(String s) 
    {
        List<String> lst = new ArrayList<>();
        lst.add("");
        Stack<Character> stk = new Stack<>();
        char[] arr = s.toCharArray();
        if(s==null || s.isEmpty())
            return lst;
        else
        {
            lst.remove(0);
            helper(s,lst,stk,'(',')');
            StringBuilder sb = new StringBuilder(s).reverse();
            System.out.println(sb.toString());
            helper(sb.toString(),lst,stk,'(',')');
            return lst;
        }
        
    }
    
    public static void helper(String s, List<String> lst, Stack<Character> stk, char starc, char close )
    {
        int init = 0;
        int end = 0;
        int start = 0;
        char[] arr = s.toCharArray();
        for(Character c:arr)
        {
            if(c==starc)
                stk.push(close);
            else if (c==close)
            {
                if(stk.isEmpty())
                {
                    end = start;
                    lst.add(s.substring(init,end));
                    init = end+1;
                }
                else
                    stk.pop();    
            }
            start++;
            
        }
        end = start;
        lst.add(s.substring(init,end));
        if(end==0)
            lst.add(s);
        
    }

	
}
