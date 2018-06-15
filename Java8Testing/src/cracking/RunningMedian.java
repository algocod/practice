package cracking;

import java.util.LinkedList;
import java.util.Scanner;

public class RunningMedian 
{
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Double median = 0.0;
        double[] a = new double[n];
        LinkedList<Double> lk  = new LinkedList<Double>();
        for(int i=0; i < n; i++){
            a[i] = in.nextInt();
            if(i==0)
            {
            	median = a[0];
            }
            if(i==1)
            {
            	median = (a[0] + a[1])/2;
            	if(a[1]>a[0])
            	{
            		lk.add(a[0]);
            		lk.add(a[1]);
            	}
            	else
            	{
            		lk.add(a[1]);
            		lk.add(a[0]);
            	}
            }
            if(i>1)
            {
            	double t = a[i];
            	addToN(lk, a[i], 0, i-1);
            	if(i%2==0)
            		median = lk.get(i/2);
            	else
            		median = (lk.get((i+1)/2) + lk.get(((i+1)/2)-1))/2.0;
            }
            if(i==366)
            {
            	System.out.println("Breaking point");	
            }
            
            System.out.println(median);
        }
    }
	
	public static void addToN(LinkedList<Double> lk , double ele, int low, int high)
	{
		if(low>=75 && high<91)
		{
			for(int i=75;i<84;i++)
			{
				double d1 = lk.get(i);	
				System.out.println(d1);
			}
			
		}
		if(low<high)
		{
			if(ele>=lk.get(high))
				lk.add(high+1,ele);
			else if (ele<=lk.get(low))
				lk.add(low==0?0:low-1,ele);
			else if (ele>lk.get(low) && ele <lk.get(high) && (high-low)==1)
				lk.add(high, ele);
			else
			{
				int diff = high-low;
				int mid = 0;
				if(diff%2==0)
					mid = diff/2;
				else 
					mid = (diff+1)/2;
				if(ele>lk.get(low+mid) && ele<=lk.get(high))
				{
					addToN(lk, ele, low+mid, high);
				}
				else if (ele<=lk.get(low+mid) && ele>lk.get(low))
					addToN(lk, ele, low, low+mid);
			}
			
		}
		
	}

}
