package algorithms.strings;

public class ColasecStrings {

	public static void main(String[] args) {
		String result = colasec("ABBBBBBAACCCD");
		System.out.println(result);
		String resultC = compactStrings("ABBBBBBAACCCD");
		System.out.println(resultC);

	}

	public static String colasec(String input)
	{
		if(input==null)
			return null;
		if(input.length()<3)
			return input;
		
		int startIndex = 0;
		int endIndex = 0;
		boolean triplets = false;
		for(int i=1;i<input.length()-1;i++)
		{
			
			if((input.charAt(i-1)==input.charAt(i)) && (input.charAt(i)==input.charAt(i+1)))
			{
				startIndex = i-1;
				endIndex = i+1;
				triplets = true;
			}
			if(triplets)
			{
				int j = endIndex+1;
				while(j<input.length() && input.charAt(j)==input.charAt(i))
				{
					
					endIndex = j;
					j++;
				}
				break;
			}
		}
		
		if(triplets)
			return colasec(input.substring(0, startIndex) + input.substring(endIndex+1));
		else
			return input;
		
		
	}
	
	public static String compactStrings(String inp)
	{
		
		if(inp.length()<3)
			return inp;
		int i =1;
		int k = 1;
		while(i<inp.length())
		{
			if(inp.charAt(i)==inp.charAt(i-1)&&inp.charAt(i)==inp.charAt(i+1))
			{
				k++;
				while(i<inp.length()-1&&inp.charAt(i)==inp.charAt(i+1))
				{
					i++;
					k++;
				}
				if(k>=3)
					break;
			}
			else
				i++;
		}
		if(k>=3)
		{
			String left = inp.substring(0, i-k+1);
			String right = inp.substring(i+1, inp.length());
			return compactStrings(left+right);
		}
		else
			return inp;
	}
	
}
