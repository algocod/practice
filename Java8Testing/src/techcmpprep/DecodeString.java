package techcmpprep;

/**
 * If letters are mapped like a=1,b=2,c=3,d=4 .........z=26
 * Find out the number of ways an input can be decoded e.g. if input is 123 then it can be 
 * put as ax that 1 and 23 or lc that is 12 and 3 or just abc that is 123
 * Problem is to find out the number of ways in which its possible.
 * @author hemant
 *
 */
public class DecodeString {

	public static void main(String[] args) {
		//String input = "11111111"; //34
		String input = "123"; //3 
		System.out.println(num_ways(input));
	}
	
	public static int num_ways(String data)
	{
		char[] sendData = data.toCharArray();
		Integer[] dpArr = new Integer[sendData.length+1]; // one extra element is to store 1 ,2 ,3 ,4 and then a zero for hte last one.
		return helper_numWaysDP(sendData, sendData.length,dpArr);
		//return helper_numWays(sendData, sendData.length);
	}

	// The last K digits are being looked at and stored into the DpArr accordingly.
	// One will reach the end solution first  and thats how the dpArr works. 
	public static int helper_numWaysDP(char[] data, int k,Integer[] dpArr)
	{
		if(k==0)
			return 1;
		int s = data.length-k;
		if(data[s]=='0')
			return 0;
		if(dpArr[k]!=null)
			return dpArr[k];
		
		int result =  helper_numWaysDP(data, k-1,dpArr);
		StringBuffer twoDigit = new StringBuffer();
		if(k>=2)
		{
			twoDigit.append(data[s]).append(data[s+1]);
			if(Integer.valueOf(twoDigit.toString())<=26)
				result = result + helper_numWaysDP(data, k-2,dpArr);
		}
		
		dpArr[k] = result;
		
		return result;
	}
	
	/**
	 * DP is more about storing pre achieved results also called memoization. One can do this in a 1D array or a 2D array.
	 * @param data
	 * @param k
	 * @return
	 */
	public static int helper_numWays(char[] data, int k)
	{
		if(k==0)
			return 1;
		int s = data.length-k;
		if(data[s]=='0')
			return 0;
		
		int result =  helper_numWays(data, k-1);
		StringBuffer twoDigit = new StringBuffer();
		if(k>=2)
		{
			twoDigit.append(data[s]).append(data[s+1]);
			if(Integer.valueOf(twoDigit.toString())<=26)
				result = result + helper_numWays(data, k-2);
		}
		
		return result;
	}
}
