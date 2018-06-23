package techcmpprep;

/**
 * A matrix where one can move only right and down, need to figure out where the given end point is reachable via 1's.
 * @author hemant
 *
 */
public class EndToEndPathMatrix {

	public static boolean findPath = false;
	public static void main(String[] args) {

		int[][] mat = { 
				{1,0,1,0},
				{1,1,1,0},
				{1,0,1,0},
				{1,0,1,1}
		};
		boolean isReachable = false;
		searchMat(mat, 0, 0, isReachable, mat.length);
		System.out.print(findPath);
	}
	
	public static void searchMat(int[][] mat, int i, int j, boolean ret , int len)
	{
		if(i>=len || j>=len || i<0 || j<0 || mat[i][j]==0)
			return;
		
		mat[i][j]=0;
		if(i==len-1 && j==len-1) // Every method in the stack has its own set of variables and its NOT visible  to any parent calling method until returned through some value. 
			findPath = true;	// Thats why recursive methods return values .
			//ret = true;
		
		searchMat(mat, i, j+1, ret, len);
		searchMat(mat, i+1, j+1, ret, len);
		searchMat(mat, i+1, j, ret, len);
	}

}
