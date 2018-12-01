package algorithms.strings;
/**
 * To find the first Unique character in a String, till now there are three different ways to do it 
 * > Put an ascii character based array and increment when elements come in. Traverse the string again to check which one is still 1 and return else -1
 * > Similar approach to the above except in a HashMap .
 * > The above two approaches fail due to time limit exceeded 
 * > Create two HashMaps , one with dupes and one without it. At the end traverse the one wihtout dupes to get the minimum index.
 * > With LinkedHashMap, the first element is the answer hence save iteration over the Map.
 */
import java.util.*;
import java.util.stream.Stream;

public class FirstUniqueCharacter {

	public static void main(String[] args) {

		int result = firstUniqChar("loveleetcode");
		System.out.println(result);
	}
	
	public static int firstUniqChar(String s) 
    {
        int retVal = -1;
        HashMap<Character,Integer> hmpDup = new HashMap<>();
        //Map<Character,Integer> hmpS = new HashMap<>();
        LinkedHashMap<Character,Integer> hmpS = new LinkedHashMap<>();
        
        int i =0;
        while(i<s.length())
        {
            if(!hmpDup.containsKey(s.charAt(i)))
            {
                hmpDup.put(s.charAt(i),i);
                hmpS.put(s.charAt(i),i);
            }
            else
            {
                if(hmpS.containsKey(s.charAt(i)))
                    hmpS.remove(s.charAt(i));
            }
            i++;
        }
        
        //Stream way of doing things
        Stream<Map.Entry<Character,Integer>> sorted =hmpS.entrySet().stream().sorted(Map.Entry.comparingByValue());
        int temp = sorted.findFirst().get().getValue();
        System.out.println(temp);
        
        // LinkedHashMap
        int temp2 =  hmpS.size() == 0 ? -1 : hmpS.entrySet().iterator().next().getValue();
        System.out.println(temp2);
        
        retVal= Integer.MAX_VALUE;
        for (Map.Entry<Character,Integer> entry : hmpS.entrySet()) 
        {
        	retVal = Math.min(retVal, entry.getValue());
        }
        if(retVal==Integer.MAX_VALUE)
        	retVal = -1;
        return retVal;        
    }
	
}
