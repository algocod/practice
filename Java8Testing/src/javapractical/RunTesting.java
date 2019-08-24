package javapractical;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

public class RunTesting {
	
	static final String TEXT = "I am a {0} account with {1,number,#} units of {2} currency";
	public static void main(String[] args) {

		BigDecimal bd1, bd2;     
        // Assigning value into BigDecimal object       
        bd1 = new BigDecimal("-36755");   
        bd2 = new BigDecimal("63745");  
        
		BigDecimal[] arrBD = {bd1,bd2,null};
		System.out.println("Stream testing");
		Stream<BigDecimal> str = (Stream<BigDecimal>)Arrays.stream(arrBD);
		str.filter( p -> p!=null).filter( p -> p .longValueExact()>0).forEach( p -> System.out.println(p.toString()));
		StringBuffer sb = new StringBuffer();
		sb.deleteCharAt(sb.length()-1);
		/*
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
		
		HashMap<Integer,List<Integer>> hmp = new HashMap<>();
		HashMap<Integer,Integer> hmp1 = new HashMap<>();
		for(Map.Entry<Integer,List<Integer>> mpe : hmp.entrySet())
		{
			
		}
				System.out.println(cc);
		*/
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
