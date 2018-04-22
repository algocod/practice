package algorithms.search;

import java.util.Scanner;

public class DFSCopied 
{

	static class Count{
		 int c;
	 }
	    // A function to check if a given cell (row, col) can
	    // be included in DFS
	    static boolean isSafe(int M[][], int row, int col, int m, int n,
	                   boolean visited[][])
	    {
	        // row number is in range, column number is in range
	        // and value is 1 and not yet visited
	        return (row >= 0) && (row < m) &&
	               (col >= 0) && (col < n) &&
	               (M[row][col]==1 && !visited[row][col]);
	    }
	 
	    // A utility function to do DFS for a 2D boolean matrix.
	    // It only considers the 8 neighbors as adjacent vertices
	    static void DFS(int M[][], int row, int col,int m , int n, boolean visited[][],Count c)
	    {
	        // These arrays are used to get row and column numbers
	        // of 8 neighbors of a given cell
	        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
	        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
	 
	        // Mark this cell as visited
	        visited[row][col] = true;
	 
	        // Recur for all connected neighbours
	        for (int k = 0; k < 8; ++k)
	            if (isSafe(M, row + rowNbr[k], col + colNbr[k],m,n, visited) ){
	            	c.c=c.c+1;
	                DFS(M, row + rowNbr[k], col + colNbr[k], m,n,visited,c);
	            }
	    }
	 
	    // The main function that returns count of islands in a given
	    //  boolean 2D matrix
	    static int countIslands(int M[][], int m, int n)
	    {
	        // Make a bool array to mark visited cells.
	        // Initially all cells are unvisited
	        boolean visited[][] = new boolean[m][n];
	 
	 
	        // Initialize count as 0 and travese through the all cells
	        // of given matrix
	        int res = Integer.MIN_VALUE;
	        for (int i = 0; i < m; ++i)
	            for (int j = 0; j < n; ++j)
	                if (M[i][j]==1 && !visited[i][j]) // If a cell with
	                {                                 // value 1 is not
	                    // visited yet, then new island found, Visit all
	                    // cells in this island and increment island count
	                	Count c=new Count();
	                    DFS(M, i, j,m,n, visited,c);
	                    res=  Math.max(res, c.c);
	                   }
	 
	        return res;
	    }
	 
	    // Driver method
	    public static void main (String[] args) throws java.lang.Exception
	    {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int[][] matrix = new int[n][m];
	        for(int matrix_i = 0; matrix_i < n; matrix_i++){
	            for(int matrix_j = 0; matrix_j < m; matrix_j++){
	                matrix[matrix_i][matrix_j] = in.nextInt();
	            }
	        }
	        int result = countIslands(matrix,m,n);
	        System.out.println(result);
	        in.close();
	    }
}
