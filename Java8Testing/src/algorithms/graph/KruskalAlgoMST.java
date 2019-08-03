package algorithms.graph;

import java.util.Arrays;

public class KruskalAlgoMST {


    int[] sets;
    int n=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KruskalAlgoMST kst = new KruskalAlgoMST();
		int N = 3 ;
		int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
		int cost = kst.minimumCost(N, connections);
		System.out.println("minimum cost=="+cost);
	}

	
    public int minimumCost(int N, int[][] connections) 
    {
        // This problem will be solved using Kruskals algorithm
        // Sort the edges given with increasing cost, e.g. a Min Heap
        // Create disjoint sets and keep merging them when edge is found in two different sets
        
        sets = new int[N+1];
        n= N;
        for(int i=0;i<=N;i++)
        {
            sets[i]=i;
        }
        
        Arrays.sort(connections, (a,b) -> (a[2] - b[2]));
        int result = 0;
        
        for(int[] a : connections)
        {
            int x = a[0], y=a[1];
            if(findSetOf(x)!=findSetOf(y))
            {
                result = result + a[2]; // add the distance to the minimum spanning tree ;
                combine(x,y);
            }
        }
        
        return n==1?result:-1; // the check on n is to make sure all vertices are visited and the ultimate set is reduced to one big set of all vertices.
    }
    
    
    // how to find if the vertices are in the same set 
    // Just make sure the parent of the vertices are different , if they are then in separate sets
        
    public int findSetOf(int x)
    {
        if(sets[x]==x)
            return sets[x];
        
        sets[x] = findSetOf(sets[x]); // if its in a different set then find its parent like 1 2 3  stores 1 1 3 so sets[2] will give 1 which !=2 
        // so find parent of 1 which will turn out to be 1
        
        return sets[x];
    }
    
    public void combine(int x , int y)
    {
        int sx = findSetOf(x);
        int sy = findSetOf(y);
        
        if(sx!=sy)
        {
            sets[sx] = sy; // making hte parent set of one element the same as another, in this case parent of x is now set as parent of y.
            n--;
        }
    }
    
    
 
}
