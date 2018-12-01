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
		StringBuffer sb = new StringBuffer();
		reverseSent(inp, inp.length()-1, sb);
		System.out.println(sb.toString());
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

}
