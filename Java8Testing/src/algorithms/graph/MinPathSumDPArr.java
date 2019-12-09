package algorithms.graph;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MinPathSumDPArr {

	int numIter = 0;
    Integer[][] dpArr = null;
	public static void main(String[] args) {
		//int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		int[][] grid = {{1,4,8,6,2,2,1,7},{4,7,3,1,4,5,5,1},{8,8,2,1,1,8,0,1},{8,9,2,9,8,0,8,9},{5,7,5,7,1,8,5,5},{7,0,9,4,5,6,5,6},{4,9,9,7,9,1,9,0}};

		   int[] dpA = new int[grid[0].length];
		   for(int j =dpA.length-1;j >=0; j--)
		   {
			   int gr = grid[grid.length-1][j];
			   int rr = j+1>=grid[0].length?0:dpA[j+1];
			   dpA[j] =  gr + rr;
		   }
			   
	       //dpArr1D(grid,grid.length, grid[0].length,dpA);
	       int min = minPathSumDJ(grid);
	       System.out.println(min);
	}    
    // The below was an attempt at Djikstra algorithm 
	public static int minPathSumDJ(int[][] grid) 
    {
        Integer[][] store = new Integer[grid.length][grid[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> store[a[0]][a[1]] - store[b[0]][b[1]] );
        for(int i=0;i<grid.length;i++)
        {
            for(int j =0;j<grid[0].length;j++)
            {
                store[i][j] = Integer.MAX_VALUE;
                pq.offer(new int[]{i,j});
            }
        }
        
        int len = grid.length ;
        int wid = grid[0].length;
        store[0][0] = grid[0][0];
        pq.offer(pq.poll());
        //System.out.println("integer array"+store);
        while(pq.size()>0)
        {
        	int[] pk = pq.peek();
        	int z1 = pk[0];
        	int zz1 = pk[1];
        	System.out.println("current min value array--"+store[z1][zz1]+"  for coord"+z1+"--"+zz1);
            int[] next = pq.peek();
            int x = next[0];
            int y = next[1];
            int[] rt = {x+1,y};
            int[] bt = {x,y+1};
            System.out.println("prev value array---"+store[x][y]+"  for coord"+x+"--"+y);
            if(rt[0]<len && rt[1]<wid)
            {
                int x1 = rt[0];
                int y1 = rt[1];
                System.out.println("curr value array"+store[x1][y1]+"  for coord"+x1+"--"+y1);
                System.out.println("prev value array"+store[x][y]+"  for coord"+x+"--"+y);
               System.out.println("new  value to add"+grid[x1][y1]);
                if(store[x1][y1] > store[x][y] + grid[x1][y1])
                {
                    store[x1][y1] =  store[x][y] + grid[x1][y1];
                    System.out.println("updated curr value array"+store[x1][y1]);
                }
                    
            }
            
            //pq.offer(pq.poll());
            if(bt[0]<len && bt[1]<wid)
            {
                int x1 = bt[0];
                int y1 = bt[1];
                 System.out.println("curr bottom value array"+store[x1][y1]+"  for coord"+x1+"--"+y1);
                System.out.println("prev bottom value array"+store[x][y]+"  for coord"+x+"--"+y);
                System.out.println("new bottom  value to add"+grid[x1][y1]);
                if(store[x1][y1] > store[x][y] + grid[x1][y1])
                {
                     store[x1][y1] =  store[x][y] + grid[x1][y1];
                     if(store[x1][y1]==13)
                    	 break;
                     System.out.println("updated bottom curr value array"+store[x1][y1]);
                }
            }
            pq.poll();
            if(pq.peek()!=null)
            	pq.offer(pq.poll());
            
        }
        
        while(pq.size()>0)
        {
        	System.out.println(pq.poll()[0]+"----"+pq.poll()[1]);
        	int a = pq.poll()[0];
        	int b = pq.poll()[1];
        	System.out.println(store[a][b]);
        }
        	
        
        return store[len-1][wid-1];
    }
	
	// THe DP array becomes 1D to solve.
     public static void dpArr1D(int[][] grid, int row, int col,int[] dpA1)
	    {
	        int i = row-2;
	        int j = col-1;
	        
	        
	        while(i>=0)
	        {
	            j=col-1;
	            while(j>=0)
	            {
	            	if(j==col-1)
	            		dpA1[j] = grid[i][j] + dpA1[j] ;
	            	else
	            		dpA1[j] = grid[i][j] + Math.min(dpA1[j] , dpA1[j+1]);
	                
	            	System.out.println(dpA1[j]);
	                j--;
	            }
	            i--;
	        }
	    }
    

 	// Recursion with 2D DP array 
     public int minPathSum(int[][] grid) {
         
         dpArr = new Integer[grid.length][grid[0].length];
         int ret = getMin(grid,grid.length, grid[0].length,0,0);
         System.out.println("num of iterations--"+numIter);
         
         return ret;
     }
    public int getMin(int[][] grid, int len, int col, int r , int c)
    {
        if(r<0 || r>=len || c<0 || c>=col)
             return Integer.MAX_VALUE;
        if(r==len-1 && c==col-1)
            return grid[r][c];
        if(dpArr[r][c]!=null)
            return dpArr[r][c];
        numIter++;
        int sum = grid[r][c];
        int rsum = getMin(grid,len,col,r,c+1);
        int bsum = getMin(grid,len,col,r+1,c);
        sum = sum + Math.min(rsum,bsum);
        dpArr[r][c] = sum;
        
        return sum;
    }
    
    static class Node
    {

		int x;
    	int y ;
    	int wt;
    	
    	Node(int x,int y,int wt)
    	{
    		this.x=x;
    		this.y=y;
    		this.wt=wt;
    	}
    	@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
    	@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
    }
}
