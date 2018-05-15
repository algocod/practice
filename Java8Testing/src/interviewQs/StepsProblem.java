package interviewQs;

/**
 * 5
21
35
24
36
30

223317
1132436852
1389537
2082876103
53798080

 * @author hemant
 *
 */
		
public class StepsProblem 
{
	
public static void main(String[] args)
{

	System.out.println(countSteps(3));
	System.out.println(calcWays(4));
	System.out.println(calcWays(5));
	System.out.println(calcWays(10));

	
	System.out.println(calcWays(21));
	System.out.println(calcWays(35));
	System.out.println(calcWays(24));
	System.out.println(calcWays(36));
	System.out.println(calcWays(30));
	

}
	
	
public static int calcWays(int n) {
    if (n < 1) return 0;
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (n == 3) return 4;
    
    int[] ways = new int[] {1,2,4};
    
    for (int i = 4; i < n; i++) {
        int idx = (i - 1) % 3;
        ways[idx] = ways[0] + ways[1] + ways[2];
    }
    return ways[0] + ways[1] + ways[2];
}	

public static int countSteps(int n)
{
	if(n==0)
		return 1;
	if(n==1)
		return 1;
	if(n==2)
		return 2;
	
	
		return  countSteps(n-1) + countSteps(n-2) + countSteps(n-3);
}

}