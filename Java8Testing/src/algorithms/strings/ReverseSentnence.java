package algorithms.strings;
/**
 * Reversing a sentence but keeping the words intact like feed a dog becomes dog a feed. 
 * Target is to keep the solution simplistic with minimum usage of variables.
 * @author hemant
 *
 */
public class ReverseSentnence {

	public static void main(String[] args) {
		
		String inp = "Hemant       builds a solution";
		char[] arr = new char[5];
		String ex = new String(arr);
		StringBuffer sb = new StringBuffer();
		reverseSent(inp, inp.length()-1, sb);
		System.out.println(sb.toString());
		
		String inPlaceOutput = reverseInPlace(inp);
		System.out.println(inPlaceOutput);
		//String[] arrs = {"t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"};
	}
	
	public static void reverseSent(String inp, int index,StringBuffer sb)
	{
		if(index<0)
			return;
		if(inp.charAt(index)==' ')
		{
			sb.append(inp.charAt(index));
			index--;
			reverseSent(inp,index,sb);
		}
		else
		{
			StringBuffer loc = new StringBuffer();
			while(index>=0 && inp.charAt(index)!=' ')
			{
				loc.insert(0,inp.charAt(index));
				index--;
			}
			sb.append(loc.toString());
			reverseSent(inp, index, sb);
		}
			
			
	}

	
	//TODO in place without extra space.
	// First reverse the whole sentence and then go word by word reversing it again 
	public static String reverseInPlace(String input)
	{
		char[] output = revIndexHelp(input.toCharArray(), 0, input.length()-1);
		int start = 0;
		int end = 1;
		while(end<input.length())
		{
			if(output[end]==' ' || end==input.length()-1)
			{
				revIndexHelp(output, start, end);
				start= end+1;
			}
			end++;
		}
		
		return new String(output);
	}
	
	public static char[] revIndexHelp(char[] arr,int start,int end)
	{
		while(start<end)
		{
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
	return arr;
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
	 * Below is an attempt to solve it via char[], not much of a difference other than converting char arr to String and the result back.
	 * @param str
	 */
public static void reverseWords(char[] str) {
        
        String stri = new String(str);
        StringBuffer sb = new StringBuffer();
		reverseSent(stri, stri.length()-1, sb);
        System.out.println(sb.toString());
        char[] result = sb.toString().toCharArray();
        str = result;
    }
    
    public static void reverseSentChar(String inp, int index,StringBuffer sb)
	{
		if(index<0)
			return;
		if(inp.charAt(index)==' ')
		{
			sb.append(inp.charAt(index));
			index--;
			reverseSent(inp,index,sb);
		}
		else
		{
			StringBuffer loc = new StringBuffer();
			while(index>=0 && inp.charAt(index)!=' ')
			{
				loc.insert(0,inp.charAt(index));
				index--;
			}
			sb.append(loc.toString());
			reverseSent(inp, index, sb);
		}
			
			
	}

}
