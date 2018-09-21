package techcmpprep;

import java.util.HashSet;

public class AllComboOfString {

	public static void main(String[] args) {
		String sample = "ABCD";
		HashSet<String> hst = new HashSet<>();
		char[] arr = sample.toCharArray();
		StringBuffer sbf = new StringBuffer();
		for(int i=0;i<arr.length;i++)
		{
			char tmp = arr[i];
			char curr = arr[0];
			arr[i]=arr[0];
			arr[0]=tmp;
			String str = new String(arr, 0, 1);
			allCombos(String.valueOf(arr),str , 1,hst);
		}
		
		//allCombos(sample,sample.substring(0, 1) , 1);
		//allCombos(sample,sample.substring(sample.length()-1,sample.length()) , 0);
		for(String str:hst)
			System.out.println(str);
	}
	
	public static void allCombos(String input, String temp, int i, HashSet<String> hst)
	{
		if(i==input.length())
		{
			//print
			//System.out.println(temp);
			hst.add(temp);
		}
		else
		{
			allCombos(input,temp+input.substring(i, i+1),i+1,hst);
			allCombos(input,input.substring(i, i+1)+temp,i+1,hst);
			
		}
	}

}
