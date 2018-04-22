package interviewQs;

public class StepsProblem 
{
	
public static void main(String[] args)
{
	System.out.println(countSteps(3));
	System.out.println(countSteps(4));
	System.out.println(countSteps(5));
	System.out.println(countSteps(10));
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