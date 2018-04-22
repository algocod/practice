package hackerRank;

import java.util.Scanner;
/*
Let's play a game on an array! You're standing at index  of an -element array named . From some index (where ), you can perform one of the following moves:

Move Backward: If cell  exists and contains a , you can walk back to cell .
Move Forward:
If cell  contains a zero, you can walk to cell .
If cell  contains a zero, you can jump to cell .
If you're standing in cell  or the value of , you can walk or jump off the end of the array and win the game.
In other words, you can move from index  to index , , or  as long as the destination index is a cell containing a . If the destination index is greater than , you win the game.

Given  and , complete the function in the editor below so that it returns true if you can win the game (or false if you cannot).
Input : 
4
5 3
0 0 0 0 0
6 5
0 0 0 1 1 1
6 3
0 0 1 1 1 0
3 1
0 1 0



OUTPUT
YES
YES
NO
NO

--- THe below test case if failing 

3
6 2
0 1 0 1 0 1
10 6
0 0 1 1 0 0 1 1 0 0
10 3
0 0 1 1 0 0 1 1 0 0

YES
NO
YES

We perform the following  queries:

For game 1  and leap 3 , we can walk and/or jump to the end of the array because every cell contains a . Because we can win, we return true.
For game and leap 5 , we can walk to index  and then jump  units to the end of the array. Because we can win, we return true.
For game and leap 3 , there is no way for us to get past the three consecutive ones. Because we cannot win, we return false.
For game and leap 1, there is no way for us to get past the one at index . Because we cannot win, we return false.

*/

public class LeapGame {
	 
	public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
		int len = game.length;
		if(game[0]==1)
			return false;
		
		return findPath(game,0,len,leap);
		
    }
	
	public static boolean findPath(int[] ar , int offset, int length, int leap)
	{
		if(offset<0 || ar[offset]==1)
			return false;
		else if(offset>=length-1)
			return true;
		else if(ar[offset]==0 && (length-offset<=leap || length-offset<=1))
		{
			return true;
		}
			
		ar[offset]=1 ; // to mark this cell as visited to close out the infinite loops. 
		
		return findPath(ar,offset+leap,length,leap) || findPath(ar,offset+1,length,leap) || findPath(ar,offset-1,length,leap); 
		
	}
	
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
