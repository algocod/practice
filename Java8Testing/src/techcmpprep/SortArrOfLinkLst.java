package techcmpprep;

import java.util.LinkedList;

/**
 * Order the input of log files coming through. THe log files can be string or Integers. 
 * Preserve the order for Integers and DONT sort them but the string ones need to be sorted. 
 Example: 
Input: 
logFileSize = 5 
logLines = 
[al 9 2 3 1] 
[g1 Act car] 
[zo4 4 7] 
[abl off KEY dog] 
[a8 act zoo] 

Output: 
[gl Act car] 
[a8 act zoo] 
[ab1 off KEY dog] 
[al 9 2 3 1] 
[zo4 4 7] 
 * @author hemant
 *
 */
public class SortArrOfLinkLst 
{
	static int size = 3;
	public static LinkedList<String>[] larr = new LinkedList[size];
	public static LinkedList<String>[] larrS = new LinkedList[size];
	public static void main(String[] args)
	{
		for(int i=0;i<size;i++)
		{
			larr[i] = new LinkedList<String>();
		}
		
		larr[0].addLast("g1");
		larr[0].addLast("Act");
		larr[0].addLast("car");
		
		larr[1].addLast("ab1");
		larr[1].addLast("off");
		larr[1].addLast("KEY");
		larr[1].addLast("dog");
		
		larr[2].addLast("a8");
		larr[2].addLast("act");
		larr[2].addLast("zoo");
		
		// Add the nodes to the arr which needs to be sorted
		for(int i=0;i<size;i++)
		{
			larr[i] = new LinkedList<String>();
		}
		
		
	}
	
	public static void qSortLinkedLists(LinkedList[] llarr, int low, int high )
	{
		if(low<high)
		{
			int pivot = high;
			
			int j = low-1;
			for(int i=low;i<=high;i++)
			{
				if(compareTwoNodes(llarr[i],llarr[pivot]))
				{
					j++;
					LinkedList<String> temp = llarr[i];
					llarr[i] = llarr[j];
					llarr[j] = temp;
				}
			}
			
			qSortLinkedLists(llarr, low, j-1);
			qSortLinkedLists(llarr, j+1, high);
		}
	}
	
	public static boolean compareTwoNodes(LinkedList<String> left , LinkedList<String> right)
	{
		boolean retVal = false;
		boolean rankIndex = false;
		if(left.getFirst()!=null && right.getFirst()!=null)
		{
			int rank = left.getFirst().compareTo(right.getFirst());
			rankIndex = rank<=0?true:false;
		}
		
		int j = Math.min(left.size(), right.size());
		boolean isLess = false;
		int k =1;
		isLess = compareStringsInNodes(left, right, k,j);
		
		
		return isLess;
	}
	
	public static boolean compareStringsInNodes(LinkedList<String> left , LinkedList<String> right, int k, int j)
	{
		if(k<j)
		{
			if ((left.get(k).compareTo(right.get(k))==0))
			{
				return compareStringsInNodes(left, right, k+1,j);
			}
			else
			{
				boolean cmpVal = left.get(k).compareTo(right.get(k))<0;
				return cmpVal;
			}
		}
		else
			return false;
		
	}

}
