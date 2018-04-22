package algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

public class ConnecteCellsMatrix 
{
	static int connectedCells(int[][] mat, int m, int n)
	{
		int maxLen = 0;
		
		for(int i=0;i<n;i++)
		{
			for (int k=0;k<m;k++)
			{
				if(mat[i][k]==1)
				{

					int currLen = getLargestRegion(mat, i, k,m,n);
				maxLen = Math.max(currLen, maxLen);	
				}
				
			}
		}
		
		return maxLen;
	}

	
	static int getLargestRegion(int[][] mat, int i, int j,int m, int n )
	{
		if(i<0 || j<0 || i>=n || j>=m || mat[i][j]==0)
			return 0;
		mat[i][j]=0;
		int size = 1;
		for(int p=i-1;p<=i+1;p++)
		{
			for(int q=j-1;q<=j+1;q++)
			{
				if(p!=i || q!=j)
					size= size + getLargestRegion(mat, p, q,m,n);
			}
		}
		return size;
				
	}
	
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
	        int result = connectedCells(matrix,m,n);
	        System.out.println(result);
	        in.close();
	    }

	
}
