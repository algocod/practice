package algorithms.recursion;
/**
3
2
hello planet
helloworld
6
because can do must we what
wedowhatwemustbecausewecan
3
ab abcd cd
abcd

 */
import java.util.Scanner;

public class PwdCracker 
{
	static String findPwdMatch(String[] pass,String attempt, boolean matchFound, String pwdSeq, boolean solutionFound) {
	
		while (attempt.length()>0 && !matchFound)
		{
			for(int i =0;i<pass.length;i++)
	        {
	        	if(attempt.length()>=pass[i].length() && pass[i].equals(attempt.substring(0, pass[i].length())))
	        	{
	        		attempt = attempt.substring(pass[i].length());
	        		matchFound = true;
	        		if(attempt==null || attempt.length()<1)
                    {
                        solutionFound = true;
                        pwdSeq = pwdSeq+pass[i];
                    }
                    else
                        pwdSeq = pwdSeq+pass[i]+" ";
	        		return findPwdMatch(pass,attempt,false,pwdSeq,solutionFound);
	        	}
	        	else if (matchFound)
	        		break;
	        	else if(i==pass.length-1)
	        		matchFound = true;
	        }
		}
		
		if(solutionFound)
			return pwdSeq;
		else
			return "WRONG PASSWORD";
		
    }	
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            String[] pass = new String[n];
            for(int pass_i = 0; pass_i < n; pass_i++){
                pass[pass_i] = in.next();
            }
            String attempt = in.next();
            String att = findPwdMatch(pass,attempt,false,"",false);
           System.out.println(att);
        }
        in.close();
    }

}