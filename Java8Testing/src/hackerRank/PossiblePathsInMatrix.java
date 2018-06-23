package hackerRank;

import java.io.IOException;
import java.util.Scanner;

public class PossiblePathsInMatrix {

/**
* Key facts to note that this problem will have a solution only for restricted movements like more right or move bottom.
* One need NOT reach the exact cell, getting in the same row or column is enough to say that there is ONLY one path from there.
3
4
1 1 1 1
1 1 1 1
1 1 1 1
10
-----------------------------------------------------------
3
4
1 0 0 1
1 1 1 1
1 0 0 1


@param args
	 */
	
	public static int totNumPaths = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rowNum = in.nextInt();
		int colNum = in.nextInt();
		int[][] arr = new int[rowNum][colNum];
		
		for (int i = 0 ; i<rowNum;i++)
		{
			for (int j =0;j<colNum;j++)
			{
				arr[i][j] = in.nextInt();
			}
		}
		
		int total = getTotalPathCount(arr,0,0,rowNum-1,colNum-1);
		//possiblePaths(arr,0,0,rowNum,colNum);
		System.out.println(total);
		System.out.println("----Power of DP------");
		int[][] dist = new int[rowNum][colNum];
		dynamicPaths(arr, dist, 0, 0, rowNum-1, colNum-1);

	}
	/**
	 * The method below is recursive way to find all possible paths through a matrix but the cost is high . As in every call to method breaks into two further calls.
	 * This way it would be 2^n . The below program DOESNT take care of 0 and 1 in a matrix path which needs to be fixed.
	 */
	public static int getTotalPathCount(int[][] mat, int row, int col, int endRow, int endCol)
	{
		if(row==endRow || col==endCol)
			return 1;
		
		return getTotalPathCount(mat, row+1, col, endRow, endCol) + getTotalPathCount(mat, row, col+1, endRow, endCol);
		
	}
	
	/**
	 * 
	 */
	public static void dynamicPaths(int[][] mat , int[][] dist, int i , int j , int row, int col)
	{
		// one can only move to right or bottom  which means if you are on first row, then all cols in that row can be reached in ONLY one way so that will be
		int setCVal = 1;
		for(int p =0;p<=col;p++)
		{
			if(mat[0][p]!=1)
				setCVal = 0;
			dist[0][p] = setCVal;
		}
			
		
		// one can move down as well so all rows right below the starting col , can be reached in exactly one way.
		int setVal = 1;
		for(int k =0;k<=row;k++)
		{
			if(mat[k][0]!=1)
				setVal = 0;
			dist[k][0] = setVal;
		}
			
		
		for(int m = 1;m<=row;m++)
		{
			for(int n =1;n<=col;n++)
				if(mat[m][n]==1)
					dist[m][n] = dist[m][n-1] + dist[m-1][n];
				else
					dist[m][n]=0;
		}
		
		System.out.println(dist[row][col]);
	}
	
	/**
	 * This method tried to do a DFS to find if point is reachable from a given start point. 
	 * @param arr
	 * @param i
	 * @param j
	 * @param rows
	 * @param cols
	 */
	public static void possiblePaths(int[][] arr , int i, int j, int rows, int cols)
	{
		if(i>=rows || j >=cols || i<0 || j<0 || arr[i][j]==0)
			return;
		
		
		if(i==rows-1 && j==cols-1) // need to find the rest of the possible paths , perhaps another array for visit
		{
			totNumPaths++;
			return;
		}
			

		arr[i][j]=0;
		
		for(int k =i-1;k<=i+1;k++)
		{
			for(int p =j-1;p<=j+1;p++)
			{
				if(k!=i && p!=j)
				possiblePaths(arr, k, p, rows, cols);
			}
		}
	}
	
	
	
	public void checkExceptions(int m) throws Exception
	{
		throw new IOException();
	}

	public void uncheckExceptions(int m)
	{
		throw new IllegalArgumentException();
	}
}
