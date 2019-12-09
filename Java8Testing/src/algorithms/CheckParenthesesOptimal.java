package algorithms;

import java.util.Stack;

public class CheckParenthesesOptimal {

	public static void main(String[] args) 
	{
		String input = "(]";
		boolean result = isValid(input);
		System.out.print(result);
	}

	public static boolean callOptimal(String s)
	{
		Stack<Character> stk = new Stack<>();
		int i =0;
		boolean isMatching = true;
		while(i<s.length())
		{
			char c = s.charAt(i);
			isMatching = findMatchingOptimal(stk, c);
			if(!isMatching)
				break;
			i++;
		}
		
		return isMatching;
		
	}
	
	public static boolean findMatchingOptimal(Stack<Character> stk, char brak)
	{
		if(brak=='(')
			stk.push(')');
		else if(brak=='{')
			stk.push('}');
		else if (brak=='[')
			stk.push(']');

		return(!stk.isEmpty() || stk.pop()!=brak);
			
	}
	// This is the actual clean method to be revised.
	public static boolean isValid(String s) 
    {
        if(s==null || s.isEmpty())
            return true;
        int i =0;
        Stack<Character> stk = new Stack<>();
        while(i<s.length())
        {
            char c = s.charAt(i);
            if(c=='(')
                stk.push(')');
            else if(c=='{')
                stk.push('}');
            else if(c=='[')
                stk.push(']');
            else if(stk.isEmpty() || stk.pop()!=c)
            {
            	return false; // return statement will do the job of breaking and returning the value as well
            	/*
                isBal = false;
                break;
                */
            }
            
            i++;
        }
        
        return stk.isEmpty() ; // &&isBal; this part of boolean is taken care by the above return statement.
    }

	
}
