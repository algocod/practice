package algorithms.graph;

public class MinPathSumDPArr {

	int numIter = 0;
    Integer[][] dpArr = null;
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		   int[] dpA = new int[grid[0].length];
		   for(int j =dpA.length-1;j >=0; j--)
		   {
			   int gr = grid[grid.length-1][j];
			   int rr = j+1>=grid[0].length?0:dpA[j+1];
			   dpA[j] =  gr + rr;
		   }
			   
	       dpArr1D(grid,grid.length, grid[0].length,dpA);

	}    
    
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
	                
	            	//System.out.println(dpA1[j]);
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
}
