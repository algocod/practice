package algorithms;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,AtomicInteger> hmp = new HashMap<>();
		hmp.computeIfAbsent(2, k -> new AtomicInteger(0)).incrementAndGet();
		hmp.computeIfAbsent(2, k -> new AtomicInteger(0)).incrementAndGet();
		hmp.computeIfAbsent(2, k -> new AtomicInteger(0)).incrementAndGet();
		

		System.out.println(hmp);
		
		Deque< Integer> dq = new LinkedList<>();
		dq.addFirst(0);
		dq.addLast(1);
		System.out.println(dq);
		printT(dq);

	}
	
	public static void printT(Deque<Integer> q)
	{
		int counter = 7;
		while(q!=null && !q.isEmpty())
		{
			Deque<Integer> temp = new LinkedList<>();
			temp.addFirst(0);
			while(!q.isEmpty())
			{
				Integer next = q.poll();
				Integer aftern = q.peek()==null?0:q.peek();
				//System.out.println(next+aftern);
				temp.addLast(next +aftern);
			}
			System.out.println(temp);
			
			q = temp;
			counter--;
			if(counter<0)
				break;
		}
		
		
	}

}
