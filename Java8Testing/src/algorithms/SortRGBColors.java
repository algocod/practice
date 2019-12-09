package algorithms;

public class SortRGBColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,0};
		sortColorsMine(input);
		//sortColors(input);

	}

	public static void sortColorsMine(int[] nums) 
    {
        
        int i=0,j=0;
        int k =nums.length-1;
        while(j<=k)
        {
            //System.out.println(nums);
           // System.out.println(" Current iteration "+nums[j]);
            if(nums[j]==0)
            {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
            else if(nums[j]==2)
            {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            }
            else
            	j++;
            
        }
        
    }
    
    public static void sortColors(int[] nums) {
    // for all idx < i : nums[idx < i] = 0
    // j is an index of element under consideration
    int p0 = 0, curr = 0;
    // for all idx > k : nums[idx > k] = 2
    int p2 = nums.length - 1;

    int tmp;
    while (curr <= p2) {
      if (nums[curr] == 0) {
        // swap p0-th and curr-th elements
        // i++ and j++
        tmp = nums[p0];
        nums[p0++] = nums[curr];
        nums[curr++] = tmp;
      }
      else if (nums[curr] == 2) {
        // swap k-th and curr-th elements
        // p2--
        tmp = nums[curr];
        nums[curr] = nums[p2];
        nums[p2--] = tmp;
      }
      else curr++;
    }
  }
	
}
