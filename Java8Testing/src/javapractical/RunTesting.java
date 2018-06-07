package javapractical;

import java.util.HashMap;

public class RunTesting {

	public static void main(String[] args) {

		// Run the TwoInterface problem
		
		Study tfsI = new TwoInterfaceProblem();
		Health tfsI2 = new TwoInterfaceProblem();
		
		tfsI.workHard();
		tfsI2.workHard();
		
		int a =1 <<2;
		//int b = a++;
		//int c = ++b;
		System.out.println(a);
		//System.out.println(b);
		//System.out.println(c);
	}

	public int test(int a , int b) throws Exception
	{
		
		if (b==0)
			throw new RuntimeException("zero");
		return (a>b)?a:b;
	}
	
}
