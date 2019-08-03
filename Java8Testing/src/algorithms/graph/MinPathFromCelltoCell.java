package algorithms.graph;

/**
 * There are two ways to solve this within DFS.
 * Using backtracking as below method shows where the visited value is set to -1 and then back to 1 to allow for other traversals
 * When the path before the cell matters to the value of the cell then backtracking is used like finding a word in a 2d chars.
 * 
 * Other way would have been to update all 1 to integer.maxValue and then run the logic where 
 * arr[i][j]<dist then return. This would then work similar to walls and gates.
 * @author hemant
 *
 */
public class MinPathFromCelltoCell {

	public static int[][] input = {
			{1,0,1},
			{1,0,1},
			{1,0,0},
			{1,9,0}
	};
	
	public static int[][] advanceinput = {
			{1,1,1},
			{0,1,1},
			{1,9,0},
			{1,0,0}
	};
	
	public static int minDis = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		for(int i =0 ;i <input.length;i++)
		{
			for(int j =0; j < input[0].length; j++)
			{
				if(input[i][j]==9)
				{
					//input[i][j]=0;
					helper(input,i,j,0);
					break;
				}
					
			}
		}

		System.out.println(minDis==Integer.MAX_VALUE?0:minDis);
	}
	
	public static void helper(int[][] arr, int i , int j , int dist)
	{
		if(i==0 && j==0)
		{
			minDis = Math.min(minDis,dist);
			return;
		}
		
		if(i<0 || i>=arr.length || j<0 || j>=arr[0].length || arr[i][j]==0 || arr[i][j]==-1)
			return;
		arr[i][j]= -1;
		
		dist++;
		helper(arr,i,j+1,dist);
		helper(arr,i,j-1,dist);
		helper(arr,i-1,j,dist);
		helper(arr,i+1,j,dist);
		arr[i][j]=1;
	}

}
