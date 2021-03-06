package algorithms.strings;

import java.util.HashSet;
import java.util.*;

public class LongestSubStrWORepeatingChars {
	
	public static void main(String[] args)
	{
		String s = "abcabcbb";
		//String s = "ijkkkkkk";
		int result = lengthOfLongestSubstring(s);
		int resultReal = lengthOfLongestSubstringReal(s);
		int result2 = lengthSolWithHmp(s);
		System.out.println(result2);
	}
	 
	 public static int lengthOfLongestSubstringReal(String s) 
	    {
	        HashMap<Character,Integer> map = new HashMap<>();
	        int ans=0, n= s.length();
	       for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	    }
	 
	 public static int lengthSolWithHmp(String s)
	 {
		 int n = s.length();
		 HashMap<Character,Integer> hmp = new HashMap<>();
		 Iterator itr = hmp.entrySet().iterator();
		 //char c = String.toString(j).toCharArray()[0];	
		 int ans=0,i=0,j=0;
		 while(i<n && j<n)
		 {
			 char temp = s.charAt(j);
			 if(!hmp.containsKey(temp))
			 {
				 hmp.put(temp, j);
			 }
			 else
			 {
				 int newi = hmp.get(temp);
				 i = newi+1;
				 hmp.put(temp, j);
			 }
			 j++;
			 ans = Math.max(ans, j-i);
		 }
		 return ans;
	 }
	 
	 // not reliable solution 
	 public static int lengthOfLongestSubstring(String s) {
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int ans = 0, i = 0, j = 0;
	        while (i < n && j < n) {
	            // try to extend the range [i, j]
	            if (!set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));
	                ans = Math.max(ans, j - i);
	            }
	            else {
	                set.remove(s.charAt(i++));
	            }
	        }
	        return ans;
	    }

}
