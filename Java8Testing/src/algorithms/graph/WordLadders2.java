package algorithms.graph;
import java.util.*;

public class WordLadders2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void bfs(String start, String end, HashSet<String> dict, HashMap<String, List<String>> nodeNeighbors, HashMap<String, Integer> distance) {
		  for (String str : dict)
		      nodeNeighbors.put(str, new ArrayList<String>());

		  Queue<String> queue = new LinkedList<String>();
		  queue.offer(start);
		  distance.put(start, 0);

		  while (!queue.isEmpty()) {
		      int count = queue.size();
		      boolean foundEnd = false;
		      for (int i = 0; i < count; i++) {
		          String cur = queue.poll();
		          int curDistance = distance.get(cur);                
		          ArrayList<String> neighbors = getNeighbors(cur, dict);

		          for (String neighbor : neighbors) {
		              nodeNeighbors.get(cur).add(neighbor);
		              if (!distance.containsKey(neighbor)) {// Check if visited
		                  distance.put(neighbor, curDistance + 1);
		                  if (end.equals(neighbor))// Found the shortest path
		                      foundEnd = true;
		                  else
		                      queue.offer(neighbor);
		                  }
		              }
		          }

		          if (foundEnd)
		              break;
		      }
		  
		  System.out.println(nodeNeighbors);
		  System.out.println(distance);
		  }
	
	public ArrayList<String> getNeighbors(String node, Set<String> dict) {
		  ArrayList<String> res = new ArrayList<String>();
		  char chs[] = node.toCharArray();

		  for (char ch ='a'; ch <= 'z'; ch++) {
		      for (int i = 0; i < chs.length; i++) {
		          if (chs[i] == ch) continue;
		          char old_ch = chs[i];
		          chs[i] = ch;
		          if (dict.contains(String.valueOf(chs))) {
		              res.add(String.valueOf(chs));
		          }
		          chs[i] = old_ch;
		      }

		  }
		  return res;
		}

	public List<List<String>> getDistance(HashMap<String,Integer> dist, HashMap<String,List<String>> adjList, List<List<Character>> lct, HashSet<String> hst , String begin, String end)
	{
		bfs(begin, end, hst, new HashMap<String,List<String>>(), new HashMap<String,Integer>());

		Queue<String> q = new ArrayDeque<>();
		q.offer(begin);
		WordLaddersHard whd = new WordLaddersHard();
		HashSet<String> local = new HashSet<>(hst);
		int distance = 0;
		dist.put(begin, 0);
		while(!q.isEmpty())
		{
			Queue<String> qT = new ArrayDeque<>();
			while(!q.isEmpty())
			{
				String next = q.poll();
				int curr = dist.get(next);
				List<String> nbrs = whd.getNbrs(next, lct, local, new HashMap<String,Boolean>());
				if(nbrs.isEmpty())
					continue;
				//adjList.put(next, nbrs);
				for(String str : nbrs)
				{
					adjList.computeIfAbsent(next, k -> new ArrayList<String>()).add(str);
					if(!dist.containsKey(str))
					{
						dist.put(str,curr+1);
						if(end.equals(str))
							break;
						else
							qT.offer(str);
					}
				}
					
			}
			distance++;
			q = qT;
		}
		//System.out.println(dist);
		//System.out.println(adjList);
		
		List<List<String>> result = new ArrayList<>();
		//System.out.println(result);
		getPaths(dist, adjList, begin, end, 0, dist.get(end), new ArrayList<String>(), result);
		return result;
	}
	
	public void getPaths(HashMap<String,Integer> dist, HashMap<String,List<String>> adjList, String begin, String end , int curr, int max,
			List<String> tmp , List<List<String>> result)
	{
		tmp.add(begin);
		if(begin.equals(end))
		{
			result.add(new ArrayList<>(tmp));
			//return result;
		}
		List<String> lst = adjList.get(begin);
		if(lst!=null && !lst.isEmpty())
		{
			for(String str : lst)
			{
				if(dist.get(str)==dist.get(begin) +1) // KEY to NOT go back in the cycle, keep moving forward 
				{
					getPaths(dist, adjList, str, end, curr, max, tmp, result);
				}				
				
			}	
		}
		

		tmp.remove(tmp.size()-1);
		
	}
	
}
