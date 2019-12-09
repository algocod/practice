package algorithms.graph;
import java.util.*;

public class AllNodesInCircularPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] relationG = {
				{0, 1, 1, 1, 1},
				{2, 0, 1, 2, 0},
				{2, 1, 0, 1, 0},
				{1, 1, 1, 0, 2},
				{1, 0, 0, 2, 0}
							};
		int num = 5; // number of dogs
		HashMap<Integer,List<Integer>> hmp = new HashMap<>();
		for(int i =0 ; i<num;i++)
		{
			for(int j = 0;j<num;j++)
			{
				if(i!=j)
				{
					if(relationG[i][j]==2 || relationG[j][i]==2)
						continue;
					else
						hmp.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
				}
			}
			
		}
		System.out.println(hmp);
		HashSet<Integer> visiting = new HashSet<>();
		boolean[] visited = new boolean[num];
		Stack<Integer> order = new Stack<>();
		if(dfs(hmp, visiting, visited, 0, 0, order));
			System.out.println(order);
		
	}
	
	public static boolean dfs(HashMap<Integer,List<Integer>> hmp , HashSet<Integer> visiting, boolean[] visited, int next, int counter,Stack<Integer> order)
	{
		if(counter==visited.length)
			return true;
		if(visiting.contains(next))
			return false ;
		if(visited[next])
			return false;
		
		counter++;
		visiting.add(next);
		if(hmp.get(next).size()>0)
		{
			List<Integer> lst = hmp.get(next); 
			for(int a =0;a<lst.size();a++ )
			{
				if(dfs(hmp,visiting,visited,lst.get(a),counter,order))
					break;
				
			}
		}
		visited[next] = true;
		visiting.remove(next);
		order.push(next);
		
		return order.size()==visited.length;
	}

}
