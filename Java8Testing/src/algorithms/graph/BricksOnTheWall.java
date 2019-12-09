package algorithms.graph;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * There is 9*3 wall which needs to be fitted with 2*1 and 3*1 bricks.
 * Lay the bricks in such a way that the cracks dont line up .
 * Idea is to get all the combinations of the bricks that can make up the width of 9 or given width
 * Once this combination is there, translate it into bit array .
 * The question means that 1's cant line up with the immediate below  which means for every combination of width there are certain combinations to be used.
 * 9 can be written as  2 2 2 3, 2 3 2 2 , 2 2 3 2 , 3 2 2 2 , 3 3 3 
 * 
 * @author hemant
 *
 */
public class BricksOnTheWall {

	static List<List<Integer>> comboList = new ArrayList<>();
	static List<int[]> bitList = new ArrayList<>();
	static HashMap<Integer,LinkedList<Integer>> hmp = new HashMap<>(); // linklist of index storing other compatibile arrays
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width = 9;
		int[] bricks = {2,3};
		StringBuffer sb = new StringBuffer();
		comboWidth(width, bricks, width, sb);
		System.out.println(comboList);
		for(int[] top : bitList)
		{
			for(int c : top)
				System.out.print(c);
			
			System.out.println("/");
		}
		compArr(bitList, hmp, width);
		System.out.println(hmp);
		int[] sum = new int[hmp.size()];	
		
	}
	
	// Id
	public static void comboWidth(int width, int[] bricks, int remWidth, StringBuffer sb)
	{
		if(remWidth==0)
		{
			String str = sb.toString();
			String[] arr = str.split(",");
			List<Integer> lst = new ArrayList<>();
			int[] bitC = new int[width];
			int bitset = 0;
			for(String a : arr)
			{
				Integer b = Integer.parseInt(a);
				bitset+=b;
				bitC[bitset-1]=1;
				lst.add(b);
			}
			comboList.add(lst);
			bitList.add(bitC);
			return;
		}
		if(remWidth < 0)
			return;
		StringBuffer sbn = new StringBuffer(sb);
		comboWidth(width,bricks,remWidth-bricks[0],sbn.append(bricks[0]).append(","));
		StringBuffer sbn1 = new StringBuffer(sb);
		comboWidth(width,bricks,remWidth-bricks[1],sbn1.append(bricks[1]).append(","));
	}
	
	// Compare each list to rest of the list ot check compatibility 
	public static void compArr(List<int[]> bitL, HashMap<Integer,LinkedList<Integer>> hmp, int width)
	{
		for(int i =0; i < bitL.size(); i++)
		{
			for(int j =i+1 ;j<bitL.size();j++)
			{
				boolean isC = true;
				for(int k=0;k<width-1;k++)
				{
					int upBit = bitL.get(i)[k];
					int lowBit = bitL.get(j)[k];
					if(upBit!=1)
						continue;
					if(upBit==lowBit)
					{
						isC = false;
						break;
					}
						
				}
				if(isC)
				{
					hmp.computeIfAbsent(i, k -> new LinkedList<Integer>()).add(j);
					hmp.computeIfAbsent(j, k -> new LinkedList<Integer>()).add(i);
				}
			}
		}
	}

}
