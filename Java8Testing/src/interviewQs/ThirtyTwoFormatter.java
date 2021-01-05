package interviewQs;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * This class takes arguments and converts it into 32 Treasury note notation.
 * @author hemant
 *
 */
public class ThirtyTwoFormatter {

	public static void main(String[] args) {
		
		if(args[0]!=null)
		{
			try
			{
				Double input = Double.parseDouble(args[0]);
				System.out.println(input.toString());
				convertInto32(input);	
			}
			catch (NumberFormatException e )
			{
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
				
		}
		
	}
		
	/**
	 * Split the input into pre and post parts of the decimal before calling concatenation.
	 * @param Double input
	 * @return String concatenated value
	 */
	public static String convertInto32(Double d )
	{
		String retVal= null;
		String decimalV = String.valueOf(d);
		System.out.println(decimalV);
		String decimalPost = "00";
		if(decimalV.indexOf('.')>0)
			decimalPost= decimalV.substring(decimalV.indexOf('.')+1);
		
		if(decimalPost.length()==1)
			decimalPost = decimalPost+"0";
		
		String decimalPre = "00";
		if(decimalV.indexOf('.')>0)
			decimalPre = decimalV.substring(0,decimalV.indexOf('.'));
		
		System.out.println(decimalPost);
		System.out.println(decimalPre);
		
		retVal = concatInto32(decimalPre, decimalPost, d);
		System.out.println(retVal);
		
		return retVal;
	}
	
	/**
	 * Concat the pre and post decimal parts , post conversion from base 100 to base 32. 
	 * @param preD
	 * @param postD
	 * @param input
	 * @return
	 */
	public static String concatInto32(String preD, String postD, Double input)
	{
		String retval = "00";
		try
		{
			Integer p = (Integer.parseInt(postD)*32)/100;
			String postHyphenVal = "";
			if(p>9)
				postHyphenVal = p.toString();
			else
				postHyphenVal = "0"+p;
			if(input<10)
				preD = "0"+preD;
			
			retval = preD+"-"+postHyphenVal;
			
		}
		catch(NumberFormatException ne)
		{
			ne.printStackTrace();
		}

		return retval;
	}
	
	@Test
	public  void runTestCases()
	{
		assertEquals("105-08", convertInto32(105.25));
		assertEquals("09-00", convertInto32(9.0));
		assertEquals("09-08", convertInto32(9.25));
		assertEquals("234587-16", convertInto32(234587.50));
		
	}
	
	@Test
	public void testingTests() {
		assertEquals("Is this correct",convertInto32(105.25));
	}
	
	

}
