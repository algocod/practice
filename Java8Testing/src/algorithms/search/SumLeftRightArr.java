package algorithms.search;

import java.util.Scanner;

/**
 * Watson gives Sherlock an array of integers. His challenge is to find an element of the array such that the sum of all elements to the left is equal to the sum of all elements to the right. For instance, given the array ,  is between two subarray that sum to . If your starting array is , that element satisfies the rule as left and right sum to .

You will be given arrays of integers and must determine whether there is an element that meets the criterion.

FInd the point in Array where the left and the right part of it sums are equal

2
3
1 2 3
4
1 2 3 3

NO
YES

10
1
1
1
2
1
3
2
1 2
3
1 4 1
3
1 5 1
1
234
1
20000
3
6 23 6
1
1

YES
YES
YES
NO
YES
YES
YES
YES
YES
YES


 * @author hemant
 *
 */
public class SumLeftRightArr {

    static String solve(int[] a){
        String result = "NO";
        if (a.length==1)
        {
        	result = "YES";
        	return result;
        }
        else if (a.length==2)
        {
        	if(a[0]==a[1])
        		result = "YES";
        	
        	return result;
        }
        
    	int totalSum = sumArr(a,a.length-1);
    	int leftSum = 0;
    	for(int i =1;i<a.length-1;i++)
    	{
    		leftSum = leftSum + a[i-1];
    		int rightSum = totalSum-a[i]-leftSum;
    		if(leftSum==rightSum)
    		{
    			result = "YES";
    			break;
    		}
    			
    	}
    	
    	return result;
    }
    
    static int sumArr(int[] a , int ind)
    {
    	if(ind>-1)
    	{
    		return a[ind] + sumArr(a,ind-1);
    	}
    	else
    		return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
	
}
