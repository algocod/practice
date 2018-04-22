package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

public class CallRWLEg {

	
	public static void main(String[] args) {

	ReadWriteLockEg reg = new ReadWriteLockEg();
	ExecutorService exr = new ForkJoinPool();
	List<Callable<Integer>> ls = new ArrayList<Callable<Integer>>();
	/*
	Integer ret = reg.readFromList(2);
	System.out.println("Element received"+ret);
	reg.writeTolist(1);
	System.out.println("Element received"+reg.readFromList(0));
	reg.writeTolist(2);
	reg.writeTolist(3);
	
	System.out.println("Element received"+reg.readFromList(2));
	// in the above example , list.contains(i) compares values while list.get(i) returns from the index position hence out of bound error in some cases.
	*/
	// try m*n thread example where m reads and n writes
	
	for(int i = 1;i<10;i++)
	{
		final int j = i;
		Callable<Integer> c4 = ()-> reg.writeTolist(j);
		/*
		Callable<Integer> cl = new Callable() {
			@Override
			public Integer call() throws Exception {
				reg.writeTolist(j);
				return j;
			} };
			ls.add(cl);
			*/
			ls.add(c4);
	}
	
	Callable<Object> c2 = ()-> 4;
	
	for(int i = 1;i<2;i++)
	{
		final int j = i;
		Callable<Integer> c3 = ()-> reg.readFromList(j);
		// Below is the old way of writing anonymous class and making callable, see how the input is supposed to be final. Anonymous class can consume final inputs only.
		// If it was part of input params then not needed.
		/*
		Callable<Integer> cl = new Callable() {
			@Override
			public Integer call() throws Exception {
				reg.readFromList(j);
				return j;
			} };
		*/
			ls.add(c3);
	}
	
	try
	{
		exr.invokeAll(ls);
		
	}catch(InterruptedException ie)
	{
		System.out.println("Interrupted");
	}
	
	
	}
	
	// writes get prioritized while read waits as the lock is RW-Rentrant
}
