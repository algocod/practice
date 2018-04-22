package algorithms.recursion;

import java.util.Scanner;

/**
 Find the number of ways that a given integer, , can be expressed as the sum of the  powers of unique, natural numbers.

Input Format

The first line contains an integer . 1< x <=1000 
The second line contains an integer . 1< n <=10

Output Format

Output a single integer, the answer to the problem explained above.

Sample Input 0

10
2
Sample Output 0

1
Explanation 0

If x=10  and n=2, we need to find the number of ways that  can be represented as the sum of squares of unique numbers.

10^2 = 1^2 + 3^2;

This is the only way in which  can be expressed as the sum of unique squares.

Sample Input 1

100
2
Sample Output 1

3
Explanation 1

100^2 = 10^2 = 6^2 + 8^2 = 1^2 +3^2 + 4^2+ 5^2 + 7^2;

Sample Input 2

100
3
Sample Output 2

1
Explanation 2

 can be expressed as the sum of the cubes of . 
 1^3 + 2^3 + 3^3 + 4^3 = 100 
. There is no other way to express  as the sum of cubes.
 * @author hemant
 *
 */
public class SumofPowers 
{

    static int powerSum(int sum, int n, int k) {
    	if(sum==0) // this statement has to be the first validation to identify the correct answer
    		return 1;
    	if(k<1 || sum <0)
    		return 0;
    	if(k>0 && sum >0)
    	{
    		int originalSum = sum;
    		sum = (int) (sum - Math.pow(k, n));
    		return powerSum(sum, n, k-1) + powerSum(originalSum,n,k-1); // the two recursive calls have different *sum* being sent as input hence the top validation works.
    		
    	}
    	else 
    		return 0;
    
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int N = in.nextInt();
        int k = 100;
        int result = powerSum(X, N, k );
        System.out.println(result);
        in.close();
    }
	
}
