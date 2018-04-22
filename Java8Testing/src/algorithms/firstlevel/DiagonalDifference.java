package algorithms.firstlevel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Find the diagonal difference between a square matrix
3
11 2 4
4 5 6
10 8 -12

Answer = 15
 * 
 * @author hemant
 *
 */
public class DiagonalDifference {
	
    static int diagonalDifference(int[][] a, int n) {
    	int primD = 0;
    	int secD =0 ;
    	
    	for(int i =0,j=n-1;i<n;i++)
    	{
    		primD = primD + a[i][i];
    		secD = secD + a[i][j-i];
    	}

    	/*
    	double d = 0.78787877878787899;
    	DecimalFormat df = new DecimalFormat("###.######");
    	
    	System.out.println(df.format(d));
    	BigDecimal bd = new BigDecimal(d);
    	bd.setScale(6,RoundingMode.HALF_UP);
    	*/
    	
    	return Math.abs(secD-primD);
    
    	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a,n);
        System.out.println(result);
        in.close();
    }

}
