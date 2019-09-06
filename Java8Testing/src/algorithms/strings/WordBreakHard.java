package algorithms.strings;
import java.util.*;

public class WordBreakHard {
	List<List<String>> ans = new ArrayList<>();
	public static void main(String[] args) {
		String s = "catsanddog";
		String[] arr = {"cat","cats","and","sand","dog"};
		List<String> input = new ArrayList<String>();
		for(String str : arr)
			input.add(str);
		new WordBreakHard().wordBreakClean(s, input);
	}
// TODO the proper way of sending back empty and "" added linkedList
// Longest sequence of characters problem is also similar , where the DP is for each pair of characters and if an end is reached , return "" or else empty
// [a,b][b,c][b,d][c,e][e,f][f,g][d,j] - a b c e f  is the sequence
// DFS with adjacency list and if the end pair has no further adjList or no matching start word return "" attached to the linkedList
// as a b d is also a valid sequence. 
// Every call in the stack has its own LinkedList to return , its like sending output from each method.
// Other way round was sending a new Object to each method call like new StringBuffer(sb) and then removing it while backtracking which is kind of complex.
/*
 * the BFS approach to a similar easy problem , can you break the words in a string into dictionary words.
 public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
 */
	public List<String> wordBreakClean(String s, List<String> wordDict) {
		HashMap<String,List<String>> dp = new HashMap<>();
		List<String> ans = dfs(s,wordDict,dp);
		System.out.println(ans);
		return ans;
	}
	
	public List<String> dfs(String s, List<String> dict, HashMap<String,List<String>> dp)
	{
		if(dp.containsKey(s))
			return dp.get(s);
		
		LinkedList<String> res = new LinkedList<>(); // returning a new LinkedList means empty, that is the last few letters didnt match
		if(s.length()==0)
		{
			res.add(""); // this means that the matching word ended the string sequence. 
			return res;
		}
			
		for(String str : dict)
		{
			if(s.startsWith(str)) // looks expensive for a big dictionary and there is a for loop variant as well for it. 
			{
				List<String> subL = dfs(s.substring(str.length()),dict,dp); // this is iterating over each children list elements.
				for(String sub : subL)
				{
					res.add(str + (sub.isEmpty() ? "" : " ") + sub);  // the last word need not have space hence the check.
				}
			}
		}
		
		dp.put(s, res);// this is key , what to store in a DP, here it stores the remainder of the string which will provide uniqueness
		return res;
	}	
	/*
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for(String str : wordDict)
            dict.add(str);
        List<String> lst = new ArrayList<>();
        HashMap<Integer,List<String>> dp = new HashMap<>();
        //helper(s,0,0,lst,dict,dp);
        helperDP(s,0,0,lst,dict,dp);
        
        // to get required format;
        System.out.println("Printing while getting answers---"+ans);
        List<String> ret = new ArrayList<>();
        for(List<String> gt : ans)
        {
            StringBuffer sb = new StringBuffer();
            for(String st : gt)
                sb.append(st);
            
            sb.deleteCharAt(sb.length()-1);
            ret.add(sb.toString());
        }
        System.out.println("Printing while returning---"+ret);
        return ret;
    }
    
    public void helperDP(String s, int start, int end , List<String> lst , Set<String> dict, HashMap<Integer,List<String>> dp)
    {
        if(dp.containsKey(end))
        {
            List<String> l = dp.get(end);
            lst.addAll(l);
            ans.add(new ArrayList<>(lst));
            return;
        }
        if(end==s.length())
        {
            System.out.println("Printing while adding---"+lst);
            dp.put(start,new ArrayList<>(lst));
            ans.add(new ArrayList<>(lst));
            return;
        }
        
        while(end<=s.length())
        {
            String str = s.substring(start,end);
            if(dict.contains(str))
            {
                lst.add(str + " ");
                helperDP(s,end, end ,lst ,dict,dp);
                lst.remove(lst.size()-1);
            }
            end++;
        }
        
        return;
    }
    
    public void helper(String s, int start, int end , List<String> lst , Set<String> dict, HashMap<Integer,List<String>> dp)
    {
        if(dp.containsKey(start))
        {
            lst.addAll(dp.get(start));
            ans.add(new ArrayList<>(lst));
            return;
        }
        if(end==s.length())
        {
            //System.out.println("Printing while adding---"+lst);
            ans.add( new ArrayList<>(lst));
            dp.put(start,new ArrayList<>(lst));
            return;
        }
        
        while(end<=s.length())
        {
            String str = s.substring(start,end);
            if(dict.contains(str))
            {
                lst.add(str + " ");
                helper(s,end, end ,lst ,dict,dp);
                lst.remove(lst.size()-1);
            }
            end++;
        }
        
        return;
    }
*/	
}
