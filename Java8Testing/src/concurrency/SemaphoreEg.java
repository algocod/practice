package concurrency;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Semaphore is more of a way of restricting the number of Threads to a certain resource/object . Although, the allowed threads will run in parallel hence 
 * Synchronization is NOT THe objective of this class rather fair sharing is. 
 * After all permits are given , the next coming thread blocks unitl available. 
 * BLockingDQueue is an example of double bounded Semaphore as in boundations on both take and give.
 * Other examples below are AtomInteger being Syncrhonized and Integer being non-synchronized
 * @author hemant
 *
 */
public class SemaphoreEg {

	public static String[] arConn =  {"con1","con2","con3","con4"};
	public static Semaphore sem = new Semaphore(4);
	public static AtomicInteger ai = new AtomicInteger(11);
	public static Integer i = 21;

	//Do some Semaphore and Mutex examples 
	public static void main(String[] args) throws InterruptedException {
		
		//ExecutorService srV = Executors.newFixedThreadPool(100);
		ExecutorService srV = Executors.newWorkStealingPool();
		List<Callable<Integer>> clS = new ArrayList<Callable<Integer>>();
		for(int i =0;i<5000;i++)
		{
			final int j = i%4;
			System.out.println("Thread Num--"+i);
			Callable<Integer> cl = ()-> {return getConn(j);};
			//Callable<Integer> cl = ()-> {return chkNonAtomic();}; // At threads above 5000, it shows inconsistency 
			//Callable<Integer> cl = ()-> {return chkAtomicity();};// The end result is always incremental
			clS.add(cl);
		}
		srV.invokeAll(clS);
		srV.awaitTermination(20000,TimeUnit.MILLISECONDS);
	}
	
	public static int getConn(int i) 
	{
		try
		{
			System.out.println(	sem.availablePermits());
			sem.acquire();
			System.out.println(arConn[i]+"going to give this object to Thread-- "+Thread.currentThread().getName());
			System.out.println("Let me sleep");
			Thread.sleep(10000);
			sem.release();	
		}
		catch(Exception e)
		{
			
		}
		return i;

	}
	
	public static int chkAtomicity()
	{
		System.out.println("Before updating Atomic"+ai);
		ai.incrementAndGet();
		System.out.println("After updating Atomic"+ai);
		return ai.get();
	}
	
	public static int chkNonAtomic()
	{
		System.out.println("Before updating Non-Atomic"+i);
		i = i+1;
		System.out.println("After updating Non-Atomic"+i);
		return i;
	}

}
