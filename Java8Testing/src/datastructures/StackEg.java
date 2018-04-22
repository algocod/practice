package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * Although the class says Stack, the below example is of Pub/Sub using a LinkedBlockingQueue
 */
public class StackEg {

	public static void main(String[] args) throws Exception  
	{

		Stack<Integer> st = new Stack<Integer>();
		Queue<Double> qu = new LinkedBlockingQueue<Double>();
		List<Runnable> ls = new ArrayList<Runnable>();
		ExecutorService exr = Executors.newCachedThreadPool();
		
		Runnable  rnWrite1 = ()-> {try {
			Thread.sleep(5000);
			qu.add(Math.random()); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}};
		ls.add(rnWrite1);
		Runnable  rnWrite2 = ()-> qu.add(Math.random());
		ls.add(rnWrite2);
		Runnable  rnWrite3 = ()-> qu.add(Math.random());
		ls.add(rnWrite3); // no invokeALl for Runnables 
		
		exr.execute(rnWrite1);
		exr.execute(rnWrite2);
		exr.execute(rnWrite3);
		
		
		Callable<Double> clRead = ()-> { 
										System.out.println("Sleeping");
										Thread.sleep(4000);
										System.out.println("Waking");
										System.out.println(qu.toString());System.out.print(qu.peek());
										return qu.poll();
										
										};
		clRead.call();
	}

}
