package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorExample {
	
	//public static ExecutorService thrServ = Executors.newSingleThreadExecutor();
	public static ExecutorService thrServ = Executors.newFixedThreadPool(3);
	
	public static void main (String[] args) throws Exception
	{
		Callable<Person> cl = new Callable<Person>() {  public Person call() throws InterruptedException
		{
			System.out.println("Going to sleep");
		  Thread.sleep(1000);
		  System.out.println("Waking after sleep");
		  return new Person(36,"BAC","M");
		}
			};
		// simple callable call and create a thread
		Person p = (Person)cl.call();
		System.out.println(p.getAge());
							
		// the below get method will block on the main thread hence submit is enough
		//System.out.println(getFutures(321).get());
		System.out.println(getFutures(321));

		Future<Person> fp = thrServ.submit(cl);// the old method of Execute(Runnable) is 
												  // also there which returns void
		//fp.get();
		 
		
			System.out.println("Seems like finished");
		 
		 thrServ.shutdown(); // else Threadpool keeps runing forever, although no task to complete
		 
	}
	
	
	public static Future<Integer> getFutures(Integer i )
	{
		return thrServ.submit(()-> {
									System.out.println("In anonymous thread for 4 secs");
									Thread.sleep(4000); 
									System.out.println("Done sleeping");
									return i*i;
									}
							);
	}
	
	// Fixed thread pool multi threading
	public static Callable<Integer> getCallable(Integer i )
	{
		Callable<Integer> clI =   ()-> i*i;
									
		return clI;
	}

}
