package techcmpprep;

public class MinSumSubArr {

	public static void main(String[] args) {
		int[] input = {2,3,1,2,4,3}; //2
		int[] input1 = {1,4,4};
		int result = minSubArrayLen(7, input1);
		System.out.println(result);
	}
	
    public static int minSubArrayLen(int s, int[] nums) {
        int minL = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0,j=0;j<nums.length;j++)
        {
        	sum +=nums[j];
            while(sum>=s)
            {
                sum = sum-nums[i];
                i++;
                minL = Math.max(minL,(j-i));
            }
            
        }
        
        return minL;
    }

}
