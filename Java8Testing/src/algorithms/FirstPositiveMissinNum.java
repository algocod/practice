package algorithms;

import java.util.HashSet;

public class FirstPositiveMissinNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstMissingPositive(int[] nums) 
    {
        int min = 0;
        int max = 0;;
        HashSet<Integer> hst = new HashSet<>();
        for(int a : nums)
        {
            if(a>0)
            {
                hst.add(a);
            }
            
        }
        
        int find = 1;
        while(hst.contains(find))
        {
            find++;
        }
        
        return find;
    }
	
}
