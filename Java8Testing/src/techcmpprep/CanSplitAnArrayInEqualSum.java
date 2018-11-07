package techcmpprep;

import java.util.HashMap;

public class CanSplitAnArrayInEqualSum {

	public static Boolean splitFound = false;
	public static void main(String[] args) {
	int[] a = {15, 5, 20, 10, 34, 15, 11};
	HashMap<String,Boolean> hmp = new HashMap<>();
 
	 getEqualSum(a, hmp, 0, 0);
	 System.out.println(splitFound);
	 
	}
	
	public static boolean getEqualSum(int[] a, HashMap<String,Boolean> hmp, int i,int sum)
	{
		if(sum==55)
		{
			splitFound = true;
			return true;	
		}
		if( i >=a.length || sum>55)
			return false;
		if(hmp.containsKey(i+"-"+sum))
			return hmp.containsKey(i+"-"+sum);
		
		hmp.put(i+"-"+sum, getEqualSum(a, hmp, i+1, sum));
		sum = sum+a[i];
		hmp.put(i+"-"+sum, getEqualSum(a, hmp, i+1, sum));
		
		// hmp.put(i+"-"+sum,getEqualSum(a, hmp, i+1, sum) || getEqualSum(a, hmp, i+1, sum+a[i]));
		// the above way doesnt reduce the computations as no valid entries are there in the hashmap.
		
		return splitFound;		
		
	}
	

}
