package algorithms.sort;
/**
In this challenge you need to print the data that accompanies each integer in a list. In addition, if two strings have the same integers, you need to print the strings in their original order. Hence, your sorting algorithm should be stable, i.e. the original order should be maintained for equal elements.

Insertion Sort and the simple version of Quicksort were stable, but the faster in-place version of Quicksort was not (since it scrambled around elements while sorting).

In cases where you care about the original order, it is important to use a stable sorting algorithm. In this challenge, you will use counting sort to sort a list while keeping the order of the strings (with the accompanying integer) preserved.

Challenge 
In the previous challenge, you created a "helper array" that contains information about the starting position of each element in a sorted array. Can you use this array to help you create a sorted array of the original list?

Hint: You can go through the original array to access the strings. You can then use your helper array to help determine where to place those strings in the sorted array. Be careful about being one off.

Details and a Twist 
You will be given a list that contains both integers and strings. Can you print the strings in order of their accompanying integers? If the integers for two strings are equal, ensure that they are print in the order they appeared in the original list.

The Twist - Your clients just called with an update. They don't want you to print the first half of the original array. Instead, they want you to print a dash for any element from the first half.

Input Format 
20
0 ab
6 cd
0 ef
6 gh
4 ij
0 ab
6 cd
0 ef
6 gh
0 ij
4 that
3 be
0 to
1 be
5 question
1 or
2 not
4 is
2 to
4 the

Sample Output
- - - - - to be or not to be - that is the question - - - -


 */
import java.util.Scanner;

public class FullCountingSort {

	// Key is how a StringBuffer array was fast instead of a String Array. 
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] order = new int[n];
        String[] input = new String[n];
        int maxLen = 0;
        
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            if(x>maxLen)
            	maxLen = x;
            order[a0] = x;
            String s = in.next();
            int chkHalf = 0;
            if(n%2==0)
            	chkHalf = n/2;
            else
            	chkHalf = n+1/2;
            if(a0<chkHalf)
            	s = "-";
            input[a0] = s;
        }
        in.close();
                
        StringBuffer[] sorted = fullCountingSort(order,input,maxLen);
        // print
        for(int j =0;j<sorted.length;j++)
        {
        	if(sorted[j]!=null)
        		System.out.print(sorted[j].toString()+" ");
        }
        
        
    }
	
	public static StringBuffer[] fullCountingSort(int[] order , String[] input, int arrLen)
	{
		StringBuffer[] sortOrder = new StringBuffer[arrLen+1];
		for(int i=0;i<input.length;i++)
		{
			StringBuffer s = new StringBuffer(input[i]);
			int ord = order[i];
			if(sortOrder[ord]==null)
				sortOrder[ord] = s;
			else
			{
				StringBuffer sbf = sortOrder[ord];
				sbf.append(" ");
				sbf.append(s.toString());
			}
			
			s = null;
				
		}
		
		return sortOrder;
	}
	
}
