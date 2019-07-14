package algorithms.graph;

import java.util.HashMap;
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
		PriorityQueue<Node> pq = new PriorityQueue<>( (a,b) -> b.value-a.value);
		HashMap<String,Node> hmp = new HashMap<>();
		int[] arr = {1,2,5,3,8,9};
		for(Integer a : arr)
		{
			Node n = new Node(String.valueOf(a), a);
//			System.out.println(n.value);
			hmp.put(String.valueOf(a), n);
			pq.offer(n);
		}
		
		System.out.println(hmp);
		hmp.computeIfAbsent("2", k -> new Node("0",0)).updateValue(20);
		pq.offer(pq.poll());
		System.out.println(pq.peek());
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
			return String.valueOf(key)+ String.valueOf(this.value);
		}
	}
	
}
