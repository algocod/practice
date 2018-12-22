package algorithms.strings;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class StringFromTelephoneNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String abc = "2347";
		if(abc.isEmpty())
			System.out.println("--");
		Date dt = new Date();
		long start =  ZonedDateTime.now().toInstant().toEpochMilli();
		List result = letterCombinations(abc);
		long end =  ZonedDateTime.now().toInstant().toEpochMilli();
		long diff = end-start;
		System.out.println("Time taken ----"+diff);
		System.out.println(result.toString());
		long start1 = ZonedDateTime.now().toInstant().toEpochMilli();
		List result1 = letterCombinationsLL(abc);
		long end1 = ZonedDateTime.now().toInstant().toEpochMilli();
		System.out.println("Time taken1111 ----"+(end1-start1));
		System.out.println(result1.toString());
	}

	public static List<String> letterCombinations(String digits) 
    {
        List<String> arl = new ArrayList<String>();
        char[] arr = digits.toCharArray();
        comboHelper(arr,0,arl,new StringBuffer());
        return arl;
    }
    
    public static void comboHelper(char[] arr, int start,List<String> arl,StringBuffer sb)
    {
        if(start==arr.length)
        {
            arl.add(sb.toString());
            return;
        }
        if(arr[start]=='1')
            return;
        char temp = arr[start];
        char[] letter = getLetter(temp);
        
        for(Character c:letter)
        {
            StringBuffer sbl = new StringBuffer(sb).append(c);
            comboHelper(arr,start+1,arl,sbl);
        }
        
    }
    
    public static char[] getLetter(char c)
    {
        if(c=='2')
            return new char[]{'a','b','c'};
        else if(c=='3')
            return new char[]{'d','e','f'};
        else if(c=='4')
            return new char[]{'g','h','i'};
        else if(c=='5')
            return new char[]{'j','k','l'};
        else if(c=='6')
            return new char[]{'m','n','o'};
        else if(c=='7')
            return new char[]{'p','q','r','s'};
        else if(c=='8')
            return new char[]{'t','u','v'};
        else if(c=='9')
            return new char[]{'w','x','y','z'};
        else
        	return new char[] {};
    }
    
    /*
     * THe below method is back tracking where all possible values are stored and then appended with all possible options one by one by removing them first.
     * like add a , b c first then append each with next options d , e ,f => ad, ae, af, bd, be, bf, cd, ce, cf and so on.
     * The while condition is on the lenght of the string , so if input is 4 char long, ultimately the anser is going to be 4 char long going from 0 to 3
     * 
     */
    public static List<String> letterCombinationsLL(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
	
}
