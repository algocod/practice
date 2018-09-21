package techcmpprep;

public class AllPermutationOfStrings {

	public static void main(String[] args) {

		String sample = "ABCD";
		char[] arr = sample.toCharArray();
		char[] subset = new char[arr.length];
		allCombo(arr,subset,0);
	}
	
	public static void allCombo(char[] arr, char[] subset,int i)
	{
		if(i==arr.length)
		{
			//print 
			for(int j =0;j<subset.length;j++)
			{
				System.out.print(subset[j]);
			}
			System.out.println("------");
		}
		
		else
		{
			subset[i] = ' ';
			allCombo(arr, subset, i+1);
			subset[i] = arr[i];
			allCombo(arr,subset,i+1);	
		}
		
		
	}

}
