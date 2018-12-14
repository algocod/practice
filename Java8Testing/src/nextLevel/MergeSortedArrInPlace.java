package nextLevel;

public class MergeSortedArrInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {4,5,6};
		merge(nums1,3,nums2,3);

	}
	
	public static void merge(int[] nums1, int m , int[] nums2, int n)
	{
        int total = m+n-1;
        m--;
        n--;
        
        while(m>=0 && n>=0)
        {
        	//shortened smart version
        	if(nums1[m]>nums2[n])
        		nums1[total--]=nums1[m--]; // assign and then increment
        	else
        		nums1[total--]=nums2[n--];
        	/*
        	if(nums1[m]>nums2[n])
            {
            	nums1[total] = nums1[m];
            	m--;
            }
            else
            {
            	nums1[total] = nums2[n];
            	n--;
            }
            total--;
            */
        }
        /*  // This is not required  as its the original array that is being compared to another array 
         / so if there was anything larger in nums2 they all went to the end of the array and m is as such, checck above example 
        while(m>=0)
        {
        	nums1[total] = nums1[m];
        	total--;
        	m--;
        }
        */
        while(n>=0)
        {
        	nums1[total] = nums2[n];
        	total--;
        	n--;
        }
        
        
    }

}
