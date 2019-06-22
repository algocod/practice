package algorithms.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WeightedBiGraph {

	public static void main(String[] args) {
		
		String[][] currInput = {
				{"a","b","2"},
				{"b","c","3"},
				{"c","d","4"}
		};
		
		HashMap<String,LinkedList<Edge>> hmp = new HashMap<>();
		HashMap<String,Boolean> visited = new HashMap<>();
		
		for(String[] in : currInput)
		{
			String source = in[0];
			String dest = in[1];
			double rt = Double.parseDouble(in[2]);
			Edge tmp = new Edge(source,dest,rt);
			Edge tmp2 = new Edge(dest,source,1/rt);
			hmp.computeIfAbsent(source, k -> new LinkedList<Edge>()).add(tmp);
			hmp.computeIfAbsent(dest, k -> new LinkedList<Edge>()).add(tmp2);
			
		}
		
		String from = "a";
		String to =  "d";
		
		double rate = edgeHelper(from,to,hmp,visited);
		if(rate <0)
			System.out.println("No Rates found");
		else
			System.out.println(Double.toString(rate));
	}
	
	static double edgeHelper(String source, String end,HashMap<String,LinkedList<Edge>> edg, HashMap<String,Boolean> visited)
	{
		double fxRate = -1.0;
		if(visited.get(source)!=null && visited.get(source)==true)
			return fxRate;
		while(edg.get(source)!=null && edg.get(source).size()>0)
		{
			Edge e = edg.get(source).removeFirst();
			if(visited.get(e.destination)!=null && visited.get(e.destination)==true)
				continue;
			visited.put(source, true);
			if(e.destination==end)
				return e.rate;
			else
				return e.rate*edgeHelper(e.destination, end, edg, visited);
		}
		
		return fxRate;
	}

	static class Edge
	{
		String source;
		String destination;
		double rate;
		
		public Edge(String src, String dest, double rt)
		{
			this.source = src;
			this.destination = dest;
			this.rate = rt;
		}
	}
	
	
}
