package techcmpprep;
import java.util.*;

public class AllPermutationOfStrings {

	public static void main(String[] args) {

		String sample = "ABCD";
		char[] arr = sample.toCharArray();
		char[] subset = new char[arr.length];
		allCombo(arr,subset,0);
		int[] arrI = {1,2,3};
		getAllComboIterative(arrI);
		subsets(arrI);
		subsetsSimple(arrI);
		int[] dups = {1,2,2};
		subsetsWithDup(dups);
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
			// the new subset is formed either with the next character or WITHOUT it hence the null character .
			subset[i] = '\u0000';
			allCombo(arr, subset, i+1);
			subset[i] = arr[i];
			allCombo(arr,subset,i+1);	
		}
		
		
	}
	/**
	 * Iterate over each item, add it to each element of already existing answer set and then add back to the answer like this :
	 * {},{1} , iterate over 2 and add 2 to each {2}{1,2} and now addd this to previous so {}{1} + {2}{1,2}
	 * @param S
	 */
	public static void getAllComboIterative(int[] S)
	{
	        List<List<Integer>> res = new ArrayList<>();
	        res.add(new ArrayList<Integer>());
	        for(int i : S) {
	            List<List<Integer>> tmp = new ArrayList<>();
	            // For every new element , all existing sets within the parent answer is being added by this new num, looks like n2 solution
	            for(List<Integer> sub : res) {
	                List<Integer> a = new ArrayList<>(sub);
	                a.add(i);
	                tmp.add(a);
	            }
	            res.addAll(tmp);
	        }
	}
	//////////////////////////////////////////////////////////////////////////
	public static List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	public static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
	
	//////////////////////////////////////////////////////////////////////////

    public static List<List<Integer>> subsetsSimple(int[] nums)
    {
        ArrayList<List<Integer>> arl = new ArrayList<>();
        List<Integer> li = new ArrayList<Integer>();
        arl.add(new ArrayList<Integer>());
        recurWithJavaApi(arl,li,nums,0);
        return arl;
    }
    
    public static void recurWithJavaApi(ArrayList<List<Integer>> arl, List<Integer> li,int[] nums, int start)
    {
        if(start>=nums.length)
            return;
        arl.add(li);
        recurWithJavaApi(arl,new ArrayList<Integer>(li),nums,start+1);
        li.add(nums[start]);
        recurWithJavaApi(arl,new ArrayList<Integer>(li),nums,start+1);
    }
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static List<List<Integer>> subsetsWithDup(int[] nums)
    {
        HashSet<List<Integer>> hst = new HashSet<>();
        List<Integer> li = new ArrayList<Integer>();
        hst.add(new ArrayList<Integer>());
        recurWithJavaApi(hst,li,nums,0);
        ArrayList<List<Integer>> arl = new ArrayList<>(hst);
        return arl;
    }
    
    public static void recurWithJavaApi(HashSet<List<Integer>> hst, List<Integer> li,int[] nums, int start)
    {
        if(start==nums.length)
        {
        	hst.add(li);
        	return;
        }
            
        recurWithJavaApi(hst,new ArrayList<Integer>(li),nums,start+1);
        if(start<nums.length && nums[start]!=nums[start+1])
        {
        	li.add(nums[start]);
            recurWithJavaApi(hst,new ArrayList<Integer>(li),nums,start+1);	
        }
        
    }
	
}
