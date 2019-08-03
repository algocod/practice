package bgc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * This class determines if a given pair of cities are connected or not with input as a file of comma separated pair of cities. 
 * Explanation : Its a  Un-directed graph where each node has a given set of Edges and its possible to travel from A to B as well as B to A
 * What To Find : Need to find if a given destination Node is reachable from a given source Node.
 * How : Traverse all the edges from a node in a DFS manner and check whether the destination is one of the nodes in the path.
 * @author hemant
 *
 */
public class ConnectingCitiesProblem {

	public static void main(String[] args) {
		
		HashMap<String,LinkedList<String>> hmp = new HashMap<>();
		HashMap<String,Boolean> visited = new HashMap<>();
		
		try
		{
			String filePath = args[0];
			String city1 = args[1];
			String city2 = args[2];
			
			if(city1==null || city1.trim().length()<1 || city2==null || city2.trim().length()<1)
			{
				System.out.println("Malformed arguments");
    			return;
			}
			
			city1 = city1.trim();
			city2 = city2.trim();
			
			File file = new File(filePath);
	        Scanner in = new Scanner(file);
	    	while(in.hasNextLine())
	    	{
	    		String input = in.nextLine();
	    		String pair1 = input.substring(0, input.indexOf(","));
	    		String pair2 = input.substring(input.indexOf(",")+1,input.length());

	    		if(pair1==null || pair2==null)
	    		{
	    			System.out.println("Malformed inputs");
	    			return;
	    		}
	    		pair1 = pair1.trim();
	    		pair2 = pair2.trim();
	    		
	    		// For a Bi-Directed graph, the edges need to be added from src to dest and back dest to src. 
	    		hmp.computeIfAbsent(pair1, k -> new LinkedList<String>()).add(pair2);
	    		hmp.computeIfAbsent(pair2, k -> new LinkedList<String>()).add(pair1);
	    	}

	    	// Check if either of  the cities are even present in the connected list.
	    	if(!hmp.containsKey(city1) || !hmp.containsKey(city2))
	    	{
	    		System.out.println("No");
    			return;
	    	}
	    	
	    	// Populate the visited map to false
	    	for(Map.Entry<String, LinkedList<String>> me : hmp.entrySet())
	    		visited.put(me.getKey(), false);
	    	
	    	String isConnected = establishConn(city1, city2, hmp, visited);
	    	System.out.println(isConnected);
	    	
		}catch(FileNotFoundException | ArrayIndexOutOfBoundsException| OutOfMemoryError e )
		{
			System.out.println(" Failed to parse Inputs/Arguments, details below ");
			e.printStackTrace();
		}
		
	}
	
	
	public static String establishConn(String source, String destination, HashMap<String,LinkedList<String>> adjList, HashMap<String,Boolean> visited)
	{
		if(destination.equals(source))
			return "Yes";
		if(visited.get(source))
			return "No";
		
		String isConn = "No";
		// set visited as true.
		visited.put(source, true);
		while(!adjList.get(source).isEmpty())
		{
			String nxt = adjList.get(source).removeFirst();
			isConn = establishConn(nxt, destination, adjList, visited);
			if(isConn.equals("Yes"))
				break;
		}
		
		return isConn;
	}

}
