package techcmpprep;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NumbersByFrequency {
/**
 *  2 3 3 3 3 4 4 2 2 4 6 4 5 6 7 8 9 8 7 6 5 5 4 43 2 1 1 2 3 4 5 6 9 8 7 6 5 4 3 2 1 2 3 4 5 6 7 8 9 0
 * 2 3 3 3 3 4 4 2 2 4 6 4 5 6 7 8 9 8 7 6 5 5 4 43 2 1 1 2 3 4 5 6 9 8 7 6 5 4 3 2 1 2 3 4 5 6 7 8 9 0 4 4 4 4 4 4 4 4 4 4 4 
 * @param args
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer,NumWithFreq> hmp = new HashMap<>();
		PriorityQueue<NumWithFreq> pq = new PriorityQueue<>((a,b)->a.freq<b.freq?1:-1);
		int j = 0;
		while(sc.hasNext()&&j<55)
		{
			int temp =sc.nextInt();
			if(hmp.containsKey(temp))
			{
				hmp.get(temp).incrementAndSetFreq();
				// In place updates of the object will reflect ONLY when a new element gets added and heapify occurs. 
				pq.remove(hmp.get(temp));
				pq.add(hmp.get(temp));
				
			}
			else
			{
				hmp.put(temp, new NumWithFreq(temp,1));
				pq.add(hmp.get(temp));
			}
			j++;
		}
		
		while(!pq.isEmpty())
			System.out.println(pq.poll());
		
	}

}
