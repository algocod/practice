package algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
/**
 * This is a very good example of DFS using a queue object which does a poll to mimic the visited array which one would have to do in case of matrix traversing
 * Use Queues to poll for checking Visited. 
 * @author hemant
 *
 */
public class AirportTravelling {

	public static void main(String[] args) {

		String[][] lst = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
		AirportTravelling ap = new AirportTravelling();
		ap.connected(lst);
		
	}
	HashMap<String,PriorityQueue<String>> hmp  = new HashMap<>();
    List<String> ans = new ArrayList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) 
    {
     
        
        for(List<String> lst : tickets)
        {
            hmp.computeIfAbsent(lst.get(0), k -> new PriorityQueue<>()).offer(lst.get(1));
        }
        
        visitHelper("JFK");
        return ans;
    }
    
    public void visitHelper(String startCity)
    {
        while(hmp.get(startCity)!=null && hmp.get(startCity).size()>0)
        {
            String nextCity = hmp.get(startCity).poll();
            visitHelper(nextCity);
        }
     
        ans.add(0,startCity);
     
    }
    
    // Find if two cities are connected
    public void connected(String[][] cities)
    {
    	for(String[] pair : cities)
    		hmp.computeIfAbsent(pair[0], k -> new PriorityQueue<>()).offer(pair[1]);
    	
    	String start = "JFK";
    	String end = "CNZ";
    	boolean val = connHelper(start,end);
    	System.out.println(val);
    }
    
    public boolean connHelper(String city, String dest)
    {
    	if(city.equals(dest))
    		return true;
    	
    	boolean retVal = false;
    	while(hmp.containsKey(city) && hmp.get(city).size()>0)
    	{
    		retVal = connHelper(hmp.get(city).poll(),dest);
    	}
    	
    	return retVal;
    }
}
