package algorithms.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author hemant
 *
 */
public class BFSInit 
{
	
	public static void main (String[] args)
	{
		/*
		Graph graph = new Graph(5);
		 GraphAdjList.addEdge(graph, 0, 1);
		 GraphAdjList.addEdge(graph, 0, 4);
		 GraphAdjList.addEdge(graph, 1, 2);
		 GraphAdjList.addEdge(graph, 1, 3);
		 GraphAdjList.addEdge(graph, 1, 4);
		 GraphAdjList.addEdge(graph, 2, 3);
		 GraphAdjList.addEdge(graph, 3, 4);
	     
		 printBFS(graph,1);
		 //DFSInit.callDFS(graph, 5, 1);
		 */

		Graph graph = new Graph(4);
		 
		GraphAdjList.addEdge(graph,0, 1);
		GraphAdjList.addEdge(graph,0, 2);
		GraphAdjList.addEdge(graph,1, 2);
		GraphAdjList.addEdge(graph,2, 0);
		GraphAdjList.addEdge(graph,2, 3);
		GraphAdjList.addEdge(graph,3, 3);
		
		//printBFS(g, 2);
		DFSInit.callDFS(graph, 4, 2);

	}
	
	public static void printBFS(Graph g, int startNode)
	{
		Queue<Integer> q = new LinkedBlockingQueue<Integer>(g.V);
		
		LinkedList<Integer>[] adj = g.adjListArray;
		int[] visited = new int[5];
		
		// lets start with node 2, which will position 1 in the adjArray list
		q.add(startNode);
		visited[startNode] = 1;
		while(!q.isEmpty())
		{
			int node = q.poll();
			System.out.println(node);
			Iterator<Integer> l = adj[node].listIterator();
			while(l.hasNext())
			{
				Integer n = l.next();
				if(visited[n]!=1)
				{
					q.add(n);
					visited[n]=1;
				}
					
			}
		}
	}

}
