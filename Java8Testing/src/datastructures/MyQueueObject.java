package datastructures;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueueObject {
	
	private Integer[] arrInt= null;
	private AtomicInteger pushC= new AtomicInteger(0);
	private AtomicInteger popC= new AtomicInteger(0);
	// This class implementation mimics the ArrayBlockingQueue which is different from LinkedBlockingQueue
	BlockingQueue<Integer> blk = new ArrayBlockingQueue<>(20);
	/**
	 * FIX THE QUEUE IMPLEMENTATION OF PUSH AND POP. THE CURRENT CODE WILL ONLY PUSH IF POP HAS CLEARED ALL THE QUEUE.
	 * NULLL NULL 6 8 10 WILL NOT ACCEPT PUSH(12) ALTHOUGH THERE IS OPEN SPACE. 
	 * AFTER EVERY PUSH PUT THE COUNTER BACK TO ZERO IF THE OBJECT IS NULL
	 * 
	 */
	public MyQueueObject(int n )
	{
		arrInt = new Integer[n];
	}
	
	public Integer push(int addInt)
	{

		Lock objPutLk = new ReentrantLock();
		objPutLk.lock();
		try
		{
			if(arrInt[pushC.get()]!=null)
			{
				System.out.println("Queue is full");
				this.wait();
			}
			
			if(pushC.get()<arrInt.length && arrInt[pushC.get()]==null)
			{
				arrInt[pushC.get()]= addInt;
				pushC.getAndIncrement();
				this.notifyAll();
			}
			
			
			if(pushC.get()==arrInt.length)
				pushC.set(0);			
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			objPutLk.unlock();
		}
		
		System.out.println("Array after every PUSH"+Arrays.toString(arrInt));
		return 0;
	}
	
	public Integer pop()
	{
		Lock objTakeLk = new ReentrantLock();
		objTakeLk.lock();
		Integer popEle = null;
		try
		{
			
			if(arrInt[popC.get()]==null)
			{
				System.out.println("Queue is Empty");	
				this.wait();
}
			
			if(arrInt[popC.get()]!=null && popC.get()<arrInt.length )
			{
				popEle = arrInt[popC.get()];
				arrInt[popC.get()] = null;
				popC.getAndIncrement();
				this.notifyAll();
			}
			
			if(popC.get()==arrInt.length)
				popC.set(0);
	
		}
		catch(Exception e )
		{
			
		}
		finally
		{
			objTakeLk.unlock();
		}
		
		System.out.println("Array after every POP"+Arrays.toString(arrInt));
		
		return popEle;

	}

	
	// For remove and contains, writeObject,Iterator,splitIterator methods, the whole Array needs to be locked which can happen like below
	// TakeLock.lock and PutLock.lock and the release the same. 
	
}
