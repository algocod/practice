package algorithms.strings;
/**
 * Check given password for its rules like  length>6
 Louise joined a social networking site to stay in touch with her friends. The signup page required her to input a name and a password. However, the password must be strong. The website considers a password to be strong if it satisfies the following criteria:

Its length is at least .
It contains at least one digit.
It contains at least one lowercase English character.
It contains at least one uppercase English character.
It contains at least one special character. The special characters are: !@#$%^&*()-+
She typed a random string of length  in the password field but wasn't sure if it was strong. Given the string she typed, can you find the minimum number of characters she must add to make her password strong?
3
Ab1

3

11
#HackerRank

1
 */
import java.util.Scanner;

public class StrongPwd 
{
	public static String numbers = "0123456789";
	public static String lower_case = "abcdefghijklmnopqrstuvwxyz";
	public static String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String special_characters = "!@#$%^&*()-+";
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
    	char[] arr = password.toCharArray();
    	int minChars = 0;
    	boolean ruleBreak = true;
    	for(int i=0;i<password.length();i++)
    	{
        	if(lower_case.contains(password.substring(i, i+1)))
        	{
        		ruleBreak = false;
        		break;
        	}
    	}
    	if(ruleBreak)
    		minChars++;
    	ruleBreak = true;
    	for(int i=0;i<password.length();i++)
    	{
        	if(upper_case.contains(password.substring(i, i+1)))
        	{
        		ruleBreak = false;
        		break;
        	}
    	}

    	if(ruleBreak)
    		minChars++;
    	ruleBreak = true;
    	for(int i=0;i<password.length();i++)
    	{
        	if(special_characters.contains(password.substring(i, i+1)))
        	{
        		ruleBreak = false;
        		break;
        	}
    	}
    	if(ruleBreak)
    		minChars++;
    	ruleBreak = true;
    	for(int i=0;i<password.length();i++)
    	{
        	if(numbers.contains(password.substring(i, i+1)))
        	{
        		ruleBreak = false;
        		break;
        	}
    	}

    	if(ruleBreak)
    		minChars++;
    	if(password.length()<6)
    	{
    		if(password.length()+minChars<6)
    		{
    			minChars = minChars + (6-(password.length()+minChars));
    		}
    	}
    	return minChars;
   }

    public static void main(String[] args) {
        
    	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
        
        
    }

}
