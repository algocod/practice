package algorithms;

import java.util.Scanner;
import java.util.Stack;

/**
 * Brackets sequence of opening and closing checks. Key rules are to first define the entry condition, middle logic and finally end condition.
 * @author hemant

({}[])
(({()})))
({(){}()})()({(){}()})(){()}
{}()))(()()({}}{}
}}}}
))))
{{{
(((
[]{}(){()}((())){{{}}}{()()}{{}{}}
[[]][][]
}{

true
false
true
false
false
false
false
false
true
true
false

 */
public class CheckBrackets {


	public static char[] brack = {'{','{','{','}'};
	public static String brk = "{{{}}[]()}}";
	public static String brk1 = "{{{{{{{{}";
	public static Stack<String> stk = new Stack();
	public static char openCurly = '{';
	public static char closeCurly = '}';
	public static char openSq = '[';
	public static char closeSq = ']';
	public static char openRnd = '(';
	public static char closeRnd = ')';
	
	
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      
	      while (sc.hasNext()) {
	         String input=sc.next();
	         Stack<String> stk = new Stack<String>();  
	         boolean isCorrect = false;
	         for(char a : input.toCharArray())
			{
				// the first element has to be open
				if(stk.size()==0)
				{
					if (a==closeCurly || a==closeSq || a==closeRnd)
					{
						isCorrect = false;
						break;
					}
						
	                else 
						stk.push(String.valueOf(a));
				}
	             
				else if(stk.size()>0 && (a==openCurly || a==openSq || a==openRnd))
				{
					stk.push(String.valueOf(a));
				}
				else if(stk.size()>0 && (a==closeCurly || a==closeSq || a==closeRnd))
				{
					char lastEle = stk.pop().charAt(0);
	                boolean match = true;
	                while(!(lastEle==openCurly || lastEle==openSq || lastEle==openRnd))
	                {
	                    lastEle = stk.pop().charAt(0);
	                }
	                
					match = findMatching(lastEle,a);
					if(!match)
					{
						isCorrect=false;
						break;
					}
					else
	                {
	                    isCorrect = true;
	                }
						
				}
				// Check the end condition
				if(a==input.charAt(input.length()-1) && !stk.isEmpty())
	            {
	                isCorrect = false;
	            }

				
			}
	          
	          System.out.println(isCorrect);
	          
	      }
	    }
	
	public static boolean findMatching(char openBraces, char closingBraces)
	{
		if(closingBraces==closeCurly && openBraces==openCurly)
			return true;
		if(closingBraces==closeSq && openBraces==openSq)
			return true;
		if(closingBraces==closeRnd && openBraces==openRnd)
			return true;
			
		return false;
	}

}
