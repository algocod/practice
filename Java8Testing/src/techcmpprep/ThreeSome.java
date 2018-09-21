package techcmpprep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThreeSome {
	
	  public List<List<Integer>> threeSum(int[] nums) 
	    {
	        List<List<Integer>> Alllst = new ArrayList<>();
	        
	        int givenTarget = 0;
	        
	        for(int i=0;i<nums.length-2;i++)
	        {
	            List<Integer> lst = new ArrayList<>();
	            lst.add(nums[i]);
	            int target = givenTarget-nums[i];
	            HashMap<Integer,Integer> hmp = new HashMap<>();
	            for(int j=i+1;j<nums.length;j++)
	            {
	                if(hmp.get(target-nums[j])!=null)
	                {
	                    lst.add(nums[j]);
	                    lst.add(target-nums[j]);
	                    
	                    hmp.put(nums[j],j);
	                    hmp.remove(target-nums[j]);
	                    Alllst.add(lst);
	                    lst = new ArrayList<>();
	                    lst.add(nums[i]);
	                }
	                else
	                    hmp.put(nums[j],j);    
	            
	            }
	            
	            if(lst.size()>1)
	            {
	                Alllst.add(lst);
	            }
	            
	        }
	        
	        return Alllst;
	    }

}
