package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdvanceExecutors {

	public static void main (String[] args) throws InterruptedException
	{
	// The number of threads equal to the number of cpu cores present , it doesnt gurantee the sequnece of 
	// task submission
	// NEXT tasks to be Locks, reEntrant, readWriteLock Mutex Semaphore etc. 
	ExecutorService exFrkJoin = Executors.newWorkStealingPool();
	Callable<String> cl1 = ()-> "callable 1 ";
	Callable<String> cl2 = ()-> "callable 2 ";
	Callable<String> cl3 = ()-> "callable 3 ";
	Callable<String> cl4 = ()-> "callable 4 ";
	
	
	List<Callable<String>> lCstr = Arrays.asList(cl1,cl2,cl3,cl4);
	
	List<Callable<String>> callables = Arrays.asList(
	        () -> "task1",
	        () -> "task2",
	        () -> "task3");
	
	//exFrkJoin.submit(callables); The submit takes only one at a time. 
	exFrkJoin.invokeAll(callables).stream().map(future-> 
											{
												try
												{
													return future.get();	
												}
												catch(Exception e)
												{
													throw new IllegalStateException(e);
												}
												
											}).
									forEach(System.out::println);
	
	}

}
