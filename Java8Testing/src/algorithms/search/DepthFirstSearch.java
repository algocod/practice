package algorithms.search;
/**
 * Depth first search of finding largest connected cells
 * 
5
5
1 1 0 0 0
0 1 1 0 0
0 0 1 0 1
1 0 0 0 1
0 1 0 1 1

Output : 5


4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0

output:5

5
5
1 1 0 0 0
0 1 1 0 1
1 0 1 1 1
0 0 0 0 0
1 0 1 0 1

Output;8
 */


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class DepthFirstSearch 
{
	static int connectedCell(int[][] matrix, int n, int m) {
        
        int maxLen = 0;
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<m;j++)
        	{
        		int currLen = 0;
        		if(matrix[i][j]==1)
        		{
        			//int[] data = Stream.of( matrix);
        			int[][] visited = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
        			currLen++;
        			visited[i][j]=2;
        			//check for adjacent nodes        		
        			currLen = checkAdjNodes(matrix,visited,i,j,n,m,currLen);
        			if(currLen>maxLen)
        				maxLen = currLen;
        		}
        	}
        }
		
        return maxLen;
		
    }
	
	public static int checkAdjNodes(int[][] mat, int[][] visited, int i, int j, int n, int m, int l)
	{
		boolean isAdjPresent = false;
		int depth = l;
		visited[i][j]=2;
		if(j>0 && i>0 && mat[i-1][j-1]==1 && visited[i-1][j-1]!=2)
		{
			isAdjPresent = true;
			depth++;
			checkAdjNodes(mat, visited, i-1, j-1, n, m, depth);
		}
        if(i>0 && mat[i-1][j]==1 && visited[i-1][j]!=2)
		{
			isAdjPresent = true;
			depth++;
			checkAdjNodes(mat, visited, i-1, j, n, m, depth);
		}
		if(i>0 && j<m-1 && mat[i-1][j+1]==1 && visited[i-1][j+1]!=2)
		{
			isAdjPresent = true;
			depth++;
			checkAdjNodes(mat, visited, i-1, j+1, n, m, depth);
		}
		if(j>0 && mat[i][j-1]==1 && visited[i][j-1]!=2)
		{
			isAdjPresent = true;
			depth++;
			checkAdjNodes(mat, visited, i, j-1, n, m, depth);
		}
		if(j<m-1 && mat[i][j+1]==1 && visited[i][j+1]!=2)
		{
			isAdjPresent = true;
			depth++;
			return checkAdjNodes(mat, visited, i, j+1, n, m, depth);
		}
		
		if(i<n-1 && j>0 &&  mat[i+1][j-1]==1 && mat[i+1][j-1]!=2)
		{
			isAdjPresent = true;
			depth++;
			checkAdjNodes(mat, visited, i+1, j-1, n, m, depth);
		}
		if(i<n-1 && mat[i+1][j]==1 && visited[i+1][j]!=2)
		{
			isAdjPresent = true;
			depth ++;
			return checkAdjNodes(mat, visited, i+1, j, n, m, depth);
		}
		if(i<n-1 && j<m-1 && mat[i+1][j+1]==1 && visited[i+1][j+1]!=2)
		{
			isAdjPresent = true;
			depth++;
			checkAdjNodes(mat, visited, i+1, j+1, n, m, depth);
		}
        
		
		return depth;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for(int matrix_i = 0; matrix_i < n; matrix_i++){
            for(int matrix_j = 0; matrix_j < m; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        int result = connectedCell(matrix,n,m);
        System.out.println(result);
        in.close();
    }

}
