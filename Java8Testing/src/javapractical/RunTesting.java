package javapractical;

import java.util.*;

public class RunTesting {
	
	static final String TEXT = "I am a {0} account with {1,number,#} units of {2} currency";
	public static void main(String[] args) {

		// Run the TwoInterface problem
		char c='a';
		int i=9;
		
		System.out.println(c);
		//c = c + i;
		StringBuffer b=new StringBuffer("");
		b.append(c+=c+i);
		System.out.println(b.toString());
		int j='Ë';
		
		int k = (j-9)/2;
		
		char cc= (char)((j-9)/2);
		//int j=97;
		//char ;
		
		
				System.out.println(cc);
		//System.out.println(c+=c+i);
		
	//	List<BankAccount> accounts = new ArrayList<>(BankAccount);
		
		
		/*Study tfsI = new TwoInterfaceProblem();
		Health tfsI2 = new TwoInterfaceProblem();
		HashMap<Integer,Integer> hmp = new HashMap<>();
		tfsI.workHard();
		tfsI2.workHard();
		
		int a =1 <<2;
		//int b = a++;
		//int c = ++b;
		System.out.println(a);*/
		//System.out.println(b);
		//System.out.println(c);
	}

	public int test(int a , int b) throws Exception
	{
		
		if (b==0)
			throw new RuntimeException("zero");
		return (a>b)?a:b;
	}
	
	class BankAccount{
		AccountType type;
		String ccy;
		double units;
		
		//public 
	}
	
	enum AccountType{
		Savings("Savings"),Checkings("Checkings"),Brokerage("Brokerage");
		
	    private String name;

	    private AccountType(String name) {
	        this.name = name;
	    }

	    public String toString() {
	        return this.name;
	    }
		
	}
}
