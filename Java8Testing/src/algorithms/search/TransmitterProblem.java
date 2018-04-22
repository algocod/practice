package algorithms.search;
/**
 Hackerland is a one-dimensional city with  houses, where each house  is located at some  on the -axis. The Mayor wants to install radio transmitters on the roofs of the city's houses. Each transmitter has a range, , meaning it can transmit a signal to all houses  units of distance away.

Given a map of Hackerland and the value of , can you find and print the minimum number of transmitters needed to cover every house in the city? (Every house must be covered by at least one transmitter) Each transmitter must be installed on top of an existing house.

Input Format

The first line contains two space-separated integers describing the respective values of  (the number of houses in Hackerland) and  (the range of each transmitter). 
The second line contains  space-separated integers describing the respective locations of each house (i.e., ).
5 1
1 2 3 4 5

2

8 2
7 2 4 6 5 9 12 11 

3
 */
import java.util.Scanner;

public class TransmitterProblem 
{
	public static void main(String[] args) {		
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);
        in.close();
    }
	

	static int hackerlandRadioTransmitters(int[] x, int k) {
		
		qSort(x,0,x.length-1);
		
        int transm = 0;
        int i = 0;
        while(i<x.length)
        {
        	int trnsHouse = getNextElement(x, i, k);
        	if(trnsHouse==i)
        	{
        		transm++;
        		i++;
        	}
        		
        	else
        	{
        		transm++;
        		int nextCoveredH = getNextElement(x, trnsHouse, k);
        		i = nextCoveredH+1;
        	}
        }
        
        return transm;
    }
	
	public static int getNextElement(int[] arr, int init, int k)
	{
		int index = init;
		for(int p =init; p<arr.length;p++)
		{
			if(arr[init]+k>=arr[p])
				index=p;
		}
		
		return index;
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


}
