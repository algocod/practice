package datastructures;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyQeueue {

	//public static int[] qArr = new int[8];
	public static Integer[] qintArr = new Integer[200000];
	public static int popC = 0;
	public static int pushC= 0 ;
	
	public static void main(String[] args) {

		ExecutorService exr = Executors.newCachedThreadPool();
		Callable<Integer> cl =null;
		
		MyQueueObject qObj = new MyQueueObject(5);
		
		for(int i=2;i<9;i= i+2 )
		{
			/*
			final int j = i;
			cl = ()-> {return qObj.push(j);};
			exr.submit(cl);
			*/
			qObj.push(i);
			//push(i);
		}
			
		
		//System.out.println(Arrays.toString(qintArr));
		
		
		for(int i=0;i<2;i++ )
		{
			/*
			final int j = i;
			cl = ()-> {return qObj.pop();};
			exr.submit(cl);
			*/
			qObj.pop();
		}
		
		qObj.push(10);
		qObj.push(12);
		//System.out.println(Arrays.toString(qintArr));

	}
	
	public static synchronized Integer push(int element)
	{
		try
		{
			if(qintArr[pushC]!=null)
			{
				System.out.println("Queue is full");
				Thread.currentThread().wait();
			}
		
			
			if(pushC<qintArr.length && qintArr[pushC]==null)
			{
				qintArr[pushC]=element;
				pushC = pushC + 1;
				Thread.currentThread().notifyAll();
			}
			
			
			if(pushC==qintArr.length)
				pushC=0;
		
		}
		catch (Exception e)
		{
			
		}
		
		System.out.println("Array after every push"+Arrays.toString(qintArr));		
		return 0;
	}
	
	public static synchronized Integer pop()
	{
		Integer popEle = null;
		try
		{
			
			if(qintArr[popC]==null)
			{
				System.out.println("Queue is Empty");	
				Thread.currentThread().wait();	
			}
			
			if(qintArr[popC]!=null && popC<qintArr.length )
			{
				popEle = qintArr[popC];
				qintArr[popC] = null;
				popC = popC+1;
				Thread.currentThread().notifyAll();
			}
			
			if(popC==qintArr.length)
				popC = 0;
	
		}
		catch(Exception e )
		{
			
		}			
		
		System.out.println("Array after every pop"+Arrays.toString(qintArr));
		
		return popEle;
	}

}
