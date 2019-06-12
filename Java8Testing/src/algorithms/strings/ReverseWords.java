package algorithms.strings;

public class ReverseWords {

	public static void main(String[] args) 
	{
		String input = "Hello  oooooo    123";
		String output = reverseString(input);
		System.out.println(output);
		
		String output2 = revIndexHelp(input, 0, input.length()-1);
		System.out.println(output2);
		
		String inputP = "abrarba";
		boolean palinCheck = palindromeRec(inputP.toCharArray(), 0, inputP.length()-1);
		System.out.println(palinCheck);
	}
	
	public static String reverseString(String s)
	{
		if(s==null || s.length()<1)
            return"";
        StringBuffer sb = new StringBuffer();
        revRecHelp(s,s.length()-1,sb);
        return sb.toString();
	}

	public static void revRecHelp(String s , int index,StringBuffer sb)
    {
        if(index<0)
            return;
        sb.append(s.charAt(index));
        index--;
        revRecHelp(s,index,sb);
    }
	
	public static String revIndexHelp(String s,int start,int end)
	{
		char[] arr = s.toCharArray();
		while(start<end)
		{
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
		return new String(arr);
	}
	/**
	 * Palindrom function via recursion.
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean palindromeRec(char[] arr, int start, int end)
	{
		if(start>=end)
			return true;
		
		return arr[start]!=arr[end]?false:palindromeRec(arr,++start,--end);
	}
	
}
