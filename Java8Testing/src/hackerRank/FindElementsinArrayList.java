package hackerRank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * THe below program finds elements in an array of Arraylist, erroring out before finding elements is the key here
 * The way we should apply checks even before any Array operations has been highlighted below
 * @author hemant
 *
 */
/*
5
4 74 72 44 33 
3 12 65 23
0
1 2
3 7 9 8 
5
1 3
2 2
3 1 
4 4 
5 5
44
65
ERROR!
ERROR!
*/
public class FindElementsinArrayList {

	public static void main(String[] args) {
		
		/**
		 * Different ways of creating Arrays of raw and parameterized types
		ArrayList<ArrayList<Integer>> arl = new ArrayList<ArrayList<Integer>>();
		Integer[] i = new Integer[10];
		Object[] j = new Object[5];
		String[] s = new String[6];
		*/
		// TODO Finish tomorrow
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		ArrayList[] al = new ArrayList[num];
		for(int p =0;p<num;p++)
		{
			int totE = in.nextInt();
			ArrayList<Integer> ap = new ArrayList<Integer>();
			for(int l =0;l<totE;l++)
			{
				int i = in.nextInt();
				ap.add(i);
				
			}
			al[p] = ap;
		}
		
		int testCases = in.nextInt();
		for(int m =0;m<testCases;m++)
		{
			int r = in.nextInt();
			int c = in.nextInt();
			findElements(al, r-1,c-1);
		}
		
	}
	
	 public static void findElements(ArrayList[] al , int rowNum , int elementIndex)
		{
	        if(rowNum>=al.length)
				System.out.println("ERROR!");
			else if(al[rowNum]!=null && !al[rowNum].isEmpty())
			{
				ArrayList ax = al[rowNum];
	            if(elementIndex>=ax.size())
					System.out.println("ERROR!");
				else if(ax.get(elementIndex)!=null )
					System.out.println(ax.get(elementIndex));
				else
					System.out.println("ERROR!");
			}
			else
				System.out.println("ERROR!");
		}

}
