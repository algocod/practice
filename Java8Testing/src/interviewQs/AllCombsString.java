package interviewQs;

import java.util.Arrays;

public class AllCombsString {

	public static String str = "abcd";
	public static char[] chr = {'a','b','c','d'};
	public static void main(String[] args) {

		char temp = chr[0];
		char[] copy = Arrays.copyOf(chr,chr.length);
		for(int i =0 ; i<chr.length;i++)
		{
			char repCh = chr[i];
			chr[i] = temp;
			chr[0] = repCh;
			//System.out.println(Arrays.toString(chr));
			StringBuilder stb = new StringBuilder();
			for(char c : chr)
			{
				stb.append(c);
			}
			String tobeSp = stb.toString();
			System.out.println("Inut provided as "+stb.toString());
			System.out.println(swapStrings(tobeSp,tobeSp.length(),false));
			//System.out.println(swapStrings(tobeSp,tobeSp.length(),true));

			chr = new char[]{'a','b','c','d'};
			/*
			String resultant = str.substring(i,i+1) + str.substring(i+1,str.length());
			String st  = str.substring(i,i+1);
			System.out.println(st);
			*/
			
		}
		
		
	}
	
	public static String swapStrings(String s , int length,boolean simple)
	{
		if(length==1)
		{
			System.out.println("Only one combination "+s);
			return s;
		}
		if (length==2)
		{
			String first = s.substring(0,1);
			String second = s.substring(1,2);
			String revSwap = second+first;
			//System.out.println(s);
			//System.out.println("reverse strings"+revSwap);
			if(simple)
				return first+second;
			else
				return second+first;
		}
		if (length==3)
		{
			String first = s.substring(0,1);
			String second = s.substring(1,3);
			String revSwap = second+first;
			//System.out.println(s);
			//System.out.println("reverse strings"+revSwap);
			if(simple)
				return first+second;
			else
				return second+first;
		}
		
		if (length>3)
		{
			//System.out.println("THe String itself is ----"+s );

			String first = s.substring(0,1);
			String second = s.substring(1,s.length());
				
			//System.out.println("frist part of strings"+first +"---"+second+"--and length--"+second.length()+"--total string lenght--"+s.length());

			//System.out.println(first + swapStrings(second,second.length(),true));
			//System.out.println(first + swapStrings(second,second.length(),false));
			/*
			if(simple)
				return first + swapStrings(second,second.length(),simple);
			else
				return swapStrings(second,second.length(),simple) + first;
			*/
			System.out.println(first + swapStrings(second,second.length(),simple));
			System.out.println(swapStrings(second,second.length(),simple)+first);
			return "Hello";
		}
		
		return "Hello";
	}

}
