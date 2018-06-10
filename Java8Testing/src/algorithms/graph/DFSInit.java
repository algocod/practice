package algorithms.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * the following is an implementation of Depth First Search on on Un-Directed graph using the Adjacency List 
 * @author hemant
 *
 */
public class DFSInit 
{
	
	public static void DFS(Integer node, boolean[] visited,LinkedList<Integer>[] lI)
	{
		
		visited[node] = true;
		System.out.println(node+" ");
		
		Iterator<Integer> l = lI[node].listIterator();
		
		while(l.hasNext())
		{
			Integer nextN = l.next();
			if(!visited[nextN])
				DFS(nextN,visited,lI);
		}
	
		
	}
	
	/**
	 * THis method handles graphs Depth traversal where all nodes are connected to each other in some way.
	 * @param g
	 * @param len
	 * @param startNode
	 */
	public static void callDFS(Graph g , int len, int startNode)
	{
		boolean visited[] = new boolean[len];
		LinkedList<Integer>[] lI = g.adjListArray;
		//let start node be 2 which would index 1 
		DFS(startNode, visited, lI);
		
	}
	
	/**
	 * This method traverses and UN-Connected graph in Depth first manner. This can be case of two trees sitting side by side but NOT connected in any way to each other.
	 * In this case, one has to traverse each node to make sure its NOT missed.
	 * @param g
	 * @param len
	 * @param startNode
	 */
	public static void callDFSForUnConnected(Graph g, int len)
	{
		boolean[] visited  = new boolean[len];
		LinkedList<Integer>[] ll = g.adjListArray;
		
		// starting node doesnt matter anymore
		for(int i =0;i<len;i++)
		{
			if(!visited[i])
				DFS(i,visited,ll);
		}
	}

}
