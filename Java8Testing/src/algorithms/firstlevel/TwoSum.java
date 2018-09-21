package algorithms.firstlevel;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

	public static void main(String[] args) {

	}
	
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer,Integer> hmp = new HashMap<>();
        HashSet<Integer> ht = new HashSet<>();
        
        int[] sol = new int[2];
        
        for(int i=0;i<nums.length;i++)
        {
            if(hmp.get(target-nums[i])!=null)
            {
                sol[0]=i;
                sol[1]=hmp.get(target-nums[i]);
                break;
            }
            else
                hmp.put(nums[i],i);
        }
        
        return sol;
    }
}
