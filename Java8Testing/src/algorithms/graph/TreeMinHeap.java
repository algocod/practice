package algorithms.graph;

import java.util.*;
import java.util.PriorityQueue;
/*
 * This class is a Map and Heap structure combined to solve the Djikstra Algorithm to get shortest path.
 * Djikstra : Get All the neighbours of the source Node and update distance as Int MAX and self as zero and add to a MinHeap 
 * Pop out source node and zero distance.
 * Update all adjacent nodes to distance as source to adjacent.
 * Pop out the min one and repeat the above. While updating the neighbour node in heap, add the current value to the existing one and update only if its less
 * than what is present -- Remember its the shortest path. 
 * 
 * Until heap is empty .
 * 
 */
public class TreeMinHeap {

	public static void main(String[] args) {
		TreeSet<Node> st = new TreeSet<>(Comparator.comparing((a) ->a.value));
		
		PriorityQueue<Node> pq = new PriorityQueue<>( (a,b) -> a.value-b.value);
		HashMap<String,Node> hmp = new HashMap<>();
		int[] arr = {1,2,3,5,8,9};
		for(Integer a : arr)
		{
			Node n = new Node(String.valueOf(a), a);
//			System.out.println(n.value);
			hmp.put(String.valueOf(a), n);
			pq.offer(n);
		}
	/*	
		while(pq.size()>0)
		{
			System.out.println(pq.poll());
			// Works fine for initial Min Heap construction
		}
*/
		hmp.computeIfAbsent("2", k -> new Node("0",0)).updateValue(2000);
		//System.out.println(hmp);

		while(pq.size()>0)
		{
			System.out.println(pq.poll()); // The tree doesnt re-arrange itself post a poll activity. 
			if(pq.peek()!=null)
				pq.offer(pq.poll());
			// Post updates of values Min Heap construction
		}
		
		
/*
		// for IntegerValue you DONT need Atomic Integer
		// hmp.put(key, hmp.getOrDefault(key,0)+1);
		
		pq.offer(pq.poll());
		System.out.println(pq.peek());
		*/
	}

	static class Node
	{
		Integer value;
		String key;
		
		public  Node(String key, Integer Value)
		{
			this.value = Value;
			this.key = key;
		}
		
		public void updateValue(Integer upd)
		{
			this.value = upd;
		}
		
		@Override
		public String toString()
		{
			//return String.valueOf(key)+ String.valueOf(this.value);
			return String.valueOf(this.value);
		}
	}
	
}
