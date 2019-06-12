package algorithms.graph;

public class MinDistFromCellToCell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] input = {
						{2147483647,-1,0,2147483647},
						{2147483647,2147483647,2147483647,-1},
						{2147483647,-1,2147483647,-1},
						{0,-1,2147483647,2147483647}
						};
		// Answer [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
		
		wallsAndGates(input);
		//System.out.println(input[0].toString());

	}
	
	   public static void wallsAndGates(int[][] rooms) 
	    {
	        int row = rooms.length;
	        int col = rooms[0].length;
	        
	        for(int i =0;i<row;i++)
	        {
	            for(int j =0;j<col;j++)
	            {
	            	/* This is the brute force approach, start from every cell to find a spot that can be reached with value zero
	                if(rooms[i][j]==Integer.MAX_VALUE)
	                {
	                    int[][] visited = new int[row][col];
	                    int dist = getMinDis(i,j,row,col,rooms,visited,0);
	                    if(dist>0 && dist!=Integer.MAX_VALUE)
	                        rooms[i][j]=dist;
	                }
	                */
	                // First find the value that is being looked up , like zero in this case and now trace back to all valid cells
	                if(rooms[i][j]==0)
	                {
	                    setMinDis(rooms,i,j,row,col,0);
	                }
	            }
	        }
	        
	    }
	    
	   public static void setMinDis(int[][] rooms, int i , int j , int row, int col, int dist)
	    {
	        if(i<0 || i>=row || j<0 || j>=col || rooms[i][j]==-1 || rooms[i][j]<dist)
	            return;
	        rooms[i][j] = dist; // the increment happens after to take care of the zero case which is the origin.
	        dist++;

	        setMinDis(rooms,i+1,j,row,col,dist);
	        setMinDis(rooms,i-1,j,row,col,dist);
	        setMinDis(rooms,i,j+1,row,col,dist);
	        setMinDis(rooms,i,j-1,row,col,dist);
	    }
	   
	    public static int getMinDis(int i, int j , int row, int col, int[][] rooms, int[][] visited, int dist)
	    {
	        if(i<0 || i>=row || j<0 || j>=col || visited[i][j]==1 || rooms[i][j]==-1)
	            return 0;
	        
	        if(rooms[i][j]==0)
	            return dist;
	        
	        dist++;
	        visited[i][j]=1;
	        int rightP = getMinDis(i,j+1,row,col,rooms,visited,dist);
	        int downP = getMinDis(i+1,j,row,col,rooms,visited,dist);
	        
	        if(rightP!=0 && downP!=0)
	        	return Math.min(rightP, downP);
	        else
	        	return rightP!=0?rightP:downP!=0?downP:0;
	    }
	    
	 

}
