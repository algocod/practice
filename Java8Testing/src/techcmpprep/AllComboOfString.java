package techcmpprep;

import java.util.*;

public class AllComboOfString {

	public static void main(String[] args) {
		String sample = "ABCD";
		HashSet<String> hst = new HashSet<>();
		HashMap<Character,Character> hmp = new HashMap<>();
		
		char[] arr = sample.toCharArray();
		for(int i=0;i<arr.length;i++)
		{
			char tmp = arr[i];
			arr[i]=arr[0];
			arr[0]=tmp;
			String str = new String(arr, 0, 1);
			allCombos(String.valueOf(arr),str , 1,hst);
		}
		
		//allCombos(sample,sample.substring(0, 1) , 1);
		//allCombos(sample,sample.substring(sample.length()-1,sample.length()) , 0);
		for(String str:hst)
			System.out.println(str);
		
		int[] numArr = {1,2,3,4};
		permute(numArr);
	}
	
	public static void allCombos(String input, String temp, int i, HashSet<String> hst)
	{
		if(i==input.length())
		{
			//print
			//System.out.println(temp);
			if(hst.contains(temp))
				System.out.println("Already exists"+temp);
			hst.add(temp);
		}
		else
		{
			allCombos(input,temp+input.substring(i, i+1),i+1,hst);
			allCombos(input,input.substring(i, i+1)+temp,i+1,hst);
			
		}
	}
	
	public static  List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
		}

		public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		   if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);
		         backtrack(list, tempList, nums);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		} 

}
