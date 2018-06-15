package cracking;

public class MatrixExpo {

	public static void main(String[] args) 
	{
		// The transformation matrix is made of last row as 1's while the rest above them start with have a single 1 in each row.
		// the 1's are placed at i+1 position in each ith row.
		int[][] transFormmat = {	{0,1,0},
					    			{0,0,1},
					    			{1,1,1}
					    		};
		// making it 2D as there is no way to make a 3*1 matrix in java
		int[][] initVals = { {1,0,0},
							 {2,0,0},
							 {4,0,0}
							};
		// 
		int[][] ans3 = sqMat(transFormmat, initVals,3);
		int[][] ans4 =  sqMat(sqMat(transFormmat, transFormmat,3),initVals,3);
		System.out.println(ans3[2][0]);
		System.out.println(ans4[2][0]);
		int[][] ansn = new int[3][3];
		ansn = transFormmat;
		int n = 10;
		
		if(n%2==0)
		{
			int numtimes = (n)/2;
			int[][] interimMat = transFormmat;
			while(numtimes >0)
			{
				interimMat = sqMat(transFormmat,interimMat, 3) ;
				numtimes--;
			}
			
			ansn = sqMat(interimMat, initVals, 3);
		}
		else
		{
			int numtimes = (n-1)/2;
			int[][] interimMat = transFormmat;
			while(numtimes >0)
			{
				interimMat = sqMat(transFormmat, interimMat, 3) ;
				numtimes--;
			}
			if(n==3)
				ansn = sqMat(interimMat, initVals, 3);
			else
			{
				interimMat = sqMat(transFormmat,interimMat, 3);
				ansn = sqMat(interimMat, initVals, 3);
			}
				
			
		}
		
		System.out.println(ansn[2][0] + ansn[1][0] + ansn[0][0]);

	}
	
	public static int[][] sqMat(int[][] a,int[][] b, int k)
	{
		int[][] ans = new int[k][k];
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<k;j++)
			{
				for(int p=0;p<k;p++)
					ans[i][j] = ans[i][j] + a[i][p]*b[p][j]; 
			}
		}
		
		return ans;
	}
	

}
