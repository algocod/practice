package hackerRank;

import java.util.Scanner;

public class PossiblePathsInMatrix {

/**
*
3
4
1 1 1 1
1 1 1 1
1 1 1 1
10
	 * @param args
	 */
	
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
		
		int total = 	possiblePaths(arr,0,0,rowNum-1,colNum-1);
		System.out.println(total);

	}
	
	public static int possiblePaths(int[][] arr , int beginRow, int beginCol, int rowEnd, int colEnd)
	{
		if(beginRow==rowEnd)
		{
			boolean path = true;
			while(beginCol<=colEnd)
			{
				if(arr[beginRow][beginCol]==0)
				{
					path = false;
					break;
				}
				beginCol++;
					
			}
			if(path)
			{
				return 1 ;
			}
			else
				return 0 ;
		}
		
		if(beginCol==colEnd)
		{
			boolean path = true;
			while(beginRow<=rowEnd)
			{
				if(arr[beginRow][beginCol]==0)
				{
					path = false;
					break;
				}
				beginRow++;
					
			}
			if(path)
			{
				return 1 ;
			}
			else
				return 0 ;
		}
		
		return possiblePaths(arr,beginRow+1,beginCol,rowEnd,colEnd) + possiblePaths(arr,beginRow,beginCol+1,rowEnd,colEnd); 
		
	}

}
