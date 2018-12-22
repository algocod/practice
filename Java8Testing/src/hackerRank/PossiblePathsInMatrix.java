package hackerRank;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import algorithms.sort.TotalNumSwapsForSort;

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
		HashSet<Integer> hs = new HashSet<>();
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
		possiblePaths(arr,0,0,rowNum,colNum);
		System.out.println(total+"-----"+ totNumPaths);
		System.out.println("----Power of DP------");
		int[][] dist = new int[rowNum][colNum];
		dynamicPaths(arr, dist, 0, 0, rowNum-1, colNum-1);

	}
	/**
	 * The method below is recursive way to find all possible paths through a matrix but the cost is high . As in every call to method breaks into two further calls.
	 * This way it would be 2^n .
	 */
	public static int getTotalPathCount(int[][] mat, int row, int col, int endRow, int endCol)
	{
		if(row>endRow || col>endCol || mat[row][col]==0) // the end condition of row or col > mat.length also needs to show up but because its ONLY being incremented hence it works.
			return 0;
		if(row==endRow && col==endCol) // to take care of 1 and zero put the condition as if row==EndRow && col==endCol
			return 1;
		
		// the above return stmt is wrong but the below one needs to be rectified. 
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
			
		// This can be done in O(n) space but time will still be O(m*n)
		// Create the dp array as 1D of dp[n] and fill it with 1 for initial array
		// now iterate from index 1 to end and sum up a[i] = a[i]+a[i-1] 
		// do this for every row so [1,1,1,1] => [1,2,1,1] => [1,2,3,1] => [1,2,3,4]
		// for 2nd row iteration from 1, [1,2,3,4] => [1,3,3,4] => [1,3,6,4] => [1,3,6,10]
		for(int m = 1;m<=row;m++)
		{
			for(int n =1;n<=col;n++)
				if(mat[m][n]==1)
					dist[m][n] = dist[m][n-1] + dist[m-1][n];// The number of path to a certain vertix is sum of the paths from one left and one top, this is the 
									// actual DP logic
				else
					dist[m][n]=0; // this is setting the number of ways one can reach a cell that is marked as zero , which will be zero itself.
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
	public static int possiblePaths(int[][] arr , int i, int j, int rows, int cols)
	{
		if(i>=rows || j >=cols || i<0 || j<0 || arr[i][j]==0)
			return 0;
		
		
		if(i==rows-1 && j==cols-1) 
		{
			totNumPaths++; // this has now been fixed.
			return 1;
		}
			

		//arr[i][j]=0; This statement to track visiting cells is not required as you are only moving right and down so its not like you will go back to the other 
		// upper or left cell and re do the same track.
		
		// One can only move right and down, hence the below 8 point visit is NOT required
		/*
		for(int k =i-1;k<=i+1;k++)
		{
			for(int p =j-1;p<=j+1;p++)
			{
				if(k!=i && p!=j)
				possiblePaths(arr, k, p, rows, cols);
			}
		}
		*/
		return possiblePaths(arr, i,j+1, rows, cols) + possiblePaths(arr, i+1,j, rows, cols);
		
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
