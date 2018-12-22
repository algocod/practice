package techcmpprep;

public class DividendAndDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer dividend = 10;
		Integer divisor = -3;
		int ans = divide(Math.abs(dividend), Math.abs(divisor));
		if((dividend<0 && divisor>0) || (dividend>0 && divisor<0))
			ans= ans*-1;
		System.out.println(ans);
	}
	
	public static Integer divide(Integer Dividend, Integer Divisor)
	{
		if(Dividend==0 || Divisor>Dividend)
			return 0;
		
		int quotient = 0;
		Dividend = Dividend - Divisor;
		while(Dividend>-1)
		{
			quotient++;
			Dividend = Dividend - Divisor;
		}
		return quotient;
	}
	
	/**
	 * How to reduce division from simple substraction, try doing a square each time and reduce the Dividend.
	 * long sum = ldivisor;
	long multiple = 1;
	while ((sum+sum) <= ldividend) {
		sum += sum;
		multiple += multiple;
	}
	 */

}
