package algorithms.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This example uses HashMap and the values within it to keep track of total count, elements found etc. 
 * Problem  is as below :
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
Example 1: Input: s: "cbaebabacd" p: "abc"
Answer: [0, 6]
 * Explanation of solution :
 * Use HashMap to store the distinct elements within the pattern like a,b,c  with init value as 1 for each and initialize the totalCount = maps.size , that will be 3 in this case
 * Now parse through the given parent string and for each element found in the hashMap, reduce its value by 1 and decrement the counter by 1 as well.
 * Once the counter reaches 0, the window has been found.  Post finding the window , try reducing the window from the left to see if the counter can still be maintained as zero
 * and all elements val<=0 while doing so. If value is <0 , its fine as it means the characters are repeated which is still under definition of anagram.
 * If the window cant be reduced further then proceed with increasing the window from the right. 
 * @author hemant
 *
 */
public class FindAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s =  "cbaebabacd", p= "abc";
		List<Integer> result = findAnagrams(s, p);
	}

	
	 public static List<Integer> findAnagrams(String s, String t) {
	        List<Integer> result = new LinkedList<>();
	        if(t.length()> s.length()) return result;
	        Map<Character, Integer> map = new HashMap<>();
	        for(char c : t.toCharArray()){
	            map.put(c, map.getOrDefault(c, 0) + 1);
	        }
	        int counter = map.size();
	        
	        int begin = 0, end = 0;
	        int head = 0;
	        int len = Integer.MAX_VALUE;
	        
	        
	        while(end < s.length()){
	            char c = s.charAt(end);
	            if( map.containsKey(c) ){
	                map.put(c, map.get(c)-1);
	                if(map.get(c) == 0) counter--;
	            }
	            end++;
	            
	            while(counter == 0){
	                char tempc = s.charAt(begin);
	                if(map.containsKey(tempc)){
	                    map.put(tempc, map.get(tempc) + 1);
	                    if(map.get(tempc) > 0){
	                        counter++;
	                    }
	                }
	                if(end-begin == t.length()){
	                    result.add(begin);
	                }
	                begin++;
	            }
	            
	        }
	        return result;
	    }
	
}
