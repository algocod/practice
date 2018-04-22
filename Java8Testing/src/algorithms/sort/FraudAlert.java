package algorithms.sort;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. If the amount spent by a client on a particular day is greater than or equal to  the client's median spending for the last  days, they send the client a notification about potential fraud. The bank doesn't send the client any notifications until they have at least  prior days of transaction data.

Given the value of  and a client's total daily expenditures for a period of  days, find and print the number of times the client will receive a notification over all  days.

Note: The median of a list of numbers can be found by arranging all the numbers from smallest to greatest. If there is an odd number of numbers, the middle one is picked. If there is an even number of numbers, median is then defined to be the average of the two middle values. (Wikipedia)

Input Format

The first line contains two space-separated integers denoting the respective values of  (the number of days there is transaction data for) and  (the number of prior days the bank uses to calculate median spending). 
The second line contains  space-separated non-negative integers where each integer  denotes  (i.e., the client's total  for day ).

9 5
2 3 4 2 3 6 8 4 5

2

5 4
1 2 3 4 4

0

EXPENDITURE IS <=200 SO BETTER USE COUNTING SORT ARRAY

 */
import java.util.Scanner;

public class FraudAlert 
{
	
/*
    
    
    public static void replaceAndSort(int[] arr, int first, int next)
    {
    	int repInd = 0;
    	for(int i = 0;i<arr.length;i++)
    	{
    		if(arr[i]==first)
    		{
    			arr[i] = next;
    			repInd = i;
    			break;
    		}
    	}
    	
    	boolean isGreater = false;
    	
    	for(int k = repInd;k<arr.length-1;k++)
    	{
    		if(arr[k]>arr[k+1])
    		{
    			isGreater= true;
    			int temp = arr[k+1];
    			arr[k+1] = arr[k];
    			arr[k]=temp;
    		}
    	}
    	
    	if(!isGreater)
    	{
    		for(int k = repInd;k>0;k--)
        	{
        		if(arr[k]<arr[k-1])
        		{
        			int temp = arr[k-1];
        			arr[k-1] = arr[k];
        			arr[k]=temp;
        		}
        	}
    	}
    }
    
    public static int[] makeCopy(int[] arr, int offset, int curr)
    {
        int[] ret = new int[offset];
        for(int j =curr-1,k=offset-1;j>=curr-offset;j--,k--)
        {
            ret[k] = arr[j];
        }
        
        return ret;
    }
    
    public static void qSort(int[] arr,int low , int high)
	{
		if (low < high)
		{
			int pivot =high;
			
			int j = low-1;
			for(int i=low;i<=high;i++)
			{
				if(arr[i]<=arr[pivot])
				{
					//swap with the j element which was big
					j++;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

			qSort(arr,low,j-1);
			qSort(arr,j+1,high);	
		}
		
	}
*/
	

    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File("C:\\Study\\Algo\\countingsortInput.txt");
        Scanner in = new Scanner(file);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();
        }
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        in.close();
    }
    
    static int activityNotifications(int[] expenditure, int d) {
        int actNot = 0;
        // First make the first array of d length that will be sorted
        int[] tobeSort = new int[201];
        // sort this initial array 
        for(int i=0;i<d;i++)
        {
        	int num = expenditure[i];
        	tobeSort[num]++;
        }
        
        double median = getMedian(tobeSort,d);
        
        for (int i=d;i<expenditure.length;i++)
        {
            int firstEle = expenditure[i-d];
            int nextEle = expenditure[i];
            if(expenditure[i]>=2*median)
                actNot++;
            
            // replace the first ele with the next and put it in its proper place
            tobeSort[firstEle] = tobeSort[firstEle] -1;
            tobeSort[nextEle] = tobeSort[nextEle] +1;
            median = getMedian(tobeSort,d);
            //System.out.println(" Value of i to be sorted---"+i);
        }
        
        if(expenditure[expenditure.length-1]>=2*median)
        	actNot++;
    
        
        return actNot;
    }
    
    public static double getMedian(int[] arr, int offset)
    {
        double retMed = 0;
        if (offset%2==0)
        {
        	int med1 = offset/2;
        	int med2 = (offset+2)/2;
        	int retmed1 = 0;
        	int retmed2=0;
        	int sum = 0;
        	for(int k =0;k<arr.length;k++)
        	{
        		sum = sum + arr[k];
        		if(sum>=med1)
        		{
        			retmed1 = k;
        			break;
        		}
        	}
        	
        	sum =0;
        	for(int k =0;k<arr.length;k++)
        	{
        		sum = sum + arr[k];
        		if(sum>=med2)
        		{
        			retmed2 = k;
        			break;
        		}
        	}
        	
        	retMed = (retmed1+retmed2)/2.0;
        }
        else
        {
        	int medIn = (offset+1)/2;
        	int sum = 0;
        	for(int k =0;k<arr.length;k++)
        	{
        		sum = sum + arr[k];
        		if(sum>=medIn)
        		{
        			retMed = k;
        			break;
        		}
        			
        	}
        	
        }
        
        return retMed;
    }
}
