package techcmpprep;

import java.util.HashSet;

// Given a String , find all combinations of it like give ABC --> 
// ABC, ACB , BCA, BAC,CAB,CBA etc
public class StringPermutations {
public static HashSet<String> ans = new HashSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> visited = new HashSet<>();
		String input = "ABCD";
		combine(0,input,"",visited);
		System.out.println(ans);
		System.out.println(ans.size());
	}
	
	public static void combine(int index, String input, String curr,HashSet<String> visited)
	{
		if(curr.length()==input.length()){
			ans.add(curr);	return;
		}
		for(int i = index;i<input.length();i++)
		{
			String ele = input.substring(i,i+1);
			if(visited.contains(ele))
				continue;
			visited.add(ele);
			combine(0,input,curr + ele,visited);
			visited.remove(ele);
		}
	}

}
