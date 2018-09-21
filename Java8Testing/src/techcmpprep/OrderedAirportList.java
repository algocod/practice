package techcmpprep;

public class OrderedAirportList 
{
	public static String[][] airP = {{"ITO", "KOA"},{"ANC", "SEA"},{"LGA", "CDG"},{"KOA", "LGA"},{"PDX", "ITO"},{"SEA", "PDX"}};
	
	public static void main(String[] args)
	{
		String[] landingAps = new String[airP.length];
		String[] departingAps = new String[airP.length];
		
		for(int i =0;i<airP.length;i++)
		{
			landingAps[i] = airP[i][0];
			departingAps[i] = airP[i][1];				
		}
		
		sortList(landingAps, 0, landingAps.length-1);
		sortList(departingAps, 0, departingAps.length-1);
		
	}
	
	public static void sortList(String[] arL , int low , int high)
	{
		if(low<high)
		{
			int pivot = high;
			int j = low-1;
			for(int i=low;i<=high;i++)
			{
				if(compareStrings(arL[i],arL[pivot]))
				{
					j++;
					String tmp = arL[i];
					arL[i] = arL[j];
					arL[j] = tmp;
				}
			}

			sortList(arL,low, j-1);
			sortList(arL,j+1,high);	
		}
	}
	
	public static boolean compareStrings(String one , String two)
	{
		int rank = one.compareTo(two);
		boolean ret = rank<=0?true:false;
		
		return ret;
	}
	
}
