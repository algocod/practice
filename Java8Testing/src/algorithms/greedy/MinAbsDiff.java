package algorithms.greedy;
/**
 * Find the minimum absolute difference between two integers, abs(-10)= 10 . 
 * Sort it and then calculate the diff between two consecutive integers and choose the minimum one
 
  ---------------------
  There is another similar problem where you sort the cupcakes by the order of their calories and then sum up the miles

3
1 3 2
11

  
 */
import java.util.Scanner;

public class MinAbsDiff 
{
    static int minimumAbsoluteDifference(int n, int[] arr) {

    	int[] getSorted = arr.clone(); 
    	qSort(getSorted,0,arr.length-1);
    
    	int minDiff = Integer.MAX_VALUE;
    	
    	for(int i=0;i<getSorted.length-1;i++)
    	{
    		int diff = Math.abs(getSorted[i]-getSorted[i+1]);
    		if(diff<minDiff)
    			minDiff = diff;
    	}
    	
    	return minDiff;
    }
 // ascending order sort
    public static void qSort(int[] arr, int low, int high)
    {
    	if(low<high)
    	{
    		int pivot = arr[high];
    		int j = low-1;
    		for(int i=low;i<=high;i++)
    		{
    			if(pivot <=arr[i])
    			{
    				j++;
    				int temp = arr[i];
    				arr[i] = arr[j];
    				arr[j]=temp;
    				
    			}
    		}
    		qSort(arr,low,j-1);
    		qSort(arr,j+1,high);
    	}
    	
    }


    static long marcsCakewalk(int[] calorie) {

    	int[] getSorted = calorie.clone(); 
    	qSort(getSorted,0,calorie.length-1);
    
    	long minMiles = 0;
    	
    	for(int i=0;i<getSorted.length;i++)
    	{
    		long tempMiles = (long)(Math.pow(2, i)*getSorted[i]);
    		minMiles = minMiles + tempMiles;
    		
    	}
    	
    	return minMiles;
    }
    
    
    // descending order sort
    public static void qSortDesc(int[] arr, int low, int high)
    {
    	if(low<high)
    	{
    		int pivot = arr[high];
    		int j = low-1;
    		for(int i=low;i<=high;i++)
    		{
    			if(pivot >=arr[i])
    			{
    				j++;
    				int temp = arr[i];
    				arr[i] = arr[j];
    				arr[j]=temp;
    				
    			}
    		}
    		qSortDesc(arr,low,j-1);
    		qSortDesc(arr,j+1,high);
    	}
    	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] calorie = new int[n];
        for(int calorie_i = 0; calorie_i < n; calorie_i++){
            calorie[calorie_i] = in.nextInt();
        }
        long result = marcsCakewalk(calorie);
        System.out.println(result);
        in.close();
    }
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = minimumAbsoluteDifference(n, arr);
        System.out.println(result);
        in.close();
    }
*/
}
