package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Numeros, the Artist, had two lists  and , such that  was a permutation of . Numeros was very proud of these lists. 
 * Unfortunately, while transporting them from one exhibition to another, some numbers were left out of . Can you find the missing numbers?
Notes
If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
You have to print all the missing numbers in ascending order.
Print each missing number once, even if it is missing multiple times.
The difference between maximum and minimum number in  is less than or equal to 101.
-- Another solution is to create an Array of MAx length and then keep incrementing the position like arr[x]++ for every occurrence and then compare the two arrays
This is always sorted but the downside is the huge memory cost.
5
204 204 205 201 207
7
201 201 204 204 204 207 205

Answer 201 204
 * @author hemant
 *
 */
public class MissingNumbers {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int k = Integer.MAX_VALUE;
        
        
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }
        int[] result = missingNumbers(arr, brr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
	
	static int[] missingNumbers(int[] arr, int[] brr) {
		
		HashMap<Integer, Integer> hmA = new HashMap<>();
		HashMap<Integer, Integer> hmB = new HashMap<>();
		int[] result;
		
		for(int i =0;i<arr.length;i++)
		{
			if(hmA.containsKey(arr[i]))
			{
				int freq = hmA.get(arr[i]);
				freq++;
				hmA.put(arr[i], freq);
				
			}
			else
			{
				hmA.put(arr[i], 1);
			}
		
		}
		
		for(int j =0;j<brr.length;j++)
		{
			if(hmB.containsKey(brr[j]))
			{
				int freq = hmB.get(brr[j]);
				freq++;
				hmB.put(brr[j], freq);
				
			}
			else
			{
				hmB.put(brr[j], 1);
			}
		
		}
		
		ArrayList<Integer> al = new ArrayList<>();
		Iterator itr = hmA.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry pair = (Map.Entry)itr.next();
			Integer ai = (Integer)pair.getKey();
			Integer af = (Integer)pair.getValue();
			
			if(hmB.containsKey(ai))
			{
				int bf = hmB.get(ai);
				if(af!=bf)
					al.add(ai);
			}
			else
				al.add(ai);
		}
		
		Collections.sort(al);
		result = new int[al.size()];
		for(int k =0;k<al.size();k++)
		{
			Integer i = al.get(k);
			//System.out.println(i+" ");
			result[k]=i;
		}
			
		
		return result;
	}

}
