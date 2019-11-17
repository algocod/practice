package concurrency;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockEg {


	// The variables are final so that the references are not instead pointed to any other object
	// which will defeat the purpose of Locking teh same object and sharing it. 
	private final ReadWriteLock rwl = new ReentrantReadWriteLock(true);
	private final Lock rl = rwl.readLock();
	private final Lock wl = rwl.writeLock();
	private final ArrayList<Integer> arl = new ArrayList<Integer>();
	
	public Integer writeTolist(Integer i)
	{
		wl.lock();
		try {
			arl.add(i);
			System.out.println("Adding "+i.toString());
			System.out.println(arl.toString());
			// One can actually call the wait and notify method on the lock objects
			//rwl.wait();
			//System.out.println("Adding element by thread"+Thread.currentThread().getName());
			System.out.println("Does the executing Thread have lock on the Lock Object ?"+Thread.holdsLock(wl));//check this out, perhaps you cant run it on Lock object itself
			Thread.sleep(1000);
			
		}catch (InterruptedException ie)
		{
			System.out.println("Interrupted in sleep");
		}
		finally {
			wl.unlock();
		}
		
		return i;
	}
	
	public Integer readFromList(Integer i)
	{
		rl.lock();
		try {
//			System.out.println("Printing elements by thread"+Thread.currentThread().getName());
			System.out.println("Elements in array before reading"+arl.toString());
			if(arl.contains(i))
			return arl.get(i);
			else return 0;
			
		}finally {
			rl.unlock();
		}
		
	}

}
