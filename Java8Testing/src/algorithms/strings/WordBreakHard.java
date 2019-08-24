package algorithms.strings;
import java.util.*;

public class WordBreakHard {
	List<List<String>> ans = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * "catsanddog"
["cat","cats","and","sand","dog"]
		 */
		String s = "catsanddogi";
		String[] arr = {"cat","cats","and","sand","dog"};
		List<String> input = new ArrayList<String>();
		for(String str : arr)
			input.add(str);
		new WordBreakHard().wordBreakClean(s, input);
	}

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
		
		LinkedList<String> res = new LinkedList<>();
		if(s.length()==0)
		{
			res.add("");
			return res;
		}
			
		for(String str : dict)
		{
			if(s.startsWith(str))
			{
				List<String> subL = dfs(s.substring(str.length()),dict,dp);
				for(String sub : subL)
				{
					res.add(str + (sub.isEmpty() ? "" : " ") + sub); 
				}
			}
		}
		
		dp.put(s, res);
		return res;
	}	
	
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
	
}
