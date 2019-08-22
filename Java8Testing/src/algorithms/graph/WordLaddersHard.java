package algorithms.graph;
import java.util.*;

public class WordLaddersHard {

    HashSet<String> lst = new HashSet<>();
    HashMap<String,Boolean> visited = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> input = new ArrayList<>();
		//String[] arr = {"ted","tex","red","tax","tad","den","rex","pee"};
		//{"hot","dot","dog","lot","log","cog"}; hit cog
		
		String[] arr = {
				"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"
		};
		
		for(String str : arr)
			input.add(str);
		//new WordLaddersHard().findLadders("hit", "cog", input);
		//new WordLaddersHard().findLadders("red", "tax", input);
		System.out.println("actual input ---"+input.size());
		new WordLaddersHard().findLadders("cet", "ism", input);
	}
	
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) 
    {
        HashSet<String> dict = new HashSet<>();
        for(String str: wordList)
            dict.add(str);
        dict.add(beginWord);
        ArrayList<HashSet<Character>> ast = new ArrayList<>();
        for(int i =0;i<endWord.length();i++)
            ast.add(new HashSet<Character>());
        for(String wrd : wordList)
        {
            for(int i=0;i<wrd.length();i++)
            {
                char c = wrd.charAt(i);
                ast.get(i).add(c);
            }
        }
        
        List<List<Character>> adjList = new ArrayList<>();
        for(HashSet<Character> hst : ast)
        {
            adjList.add(new ArrayList<>(hst));
        }
        System.out.println(adjList);
        if(!dict.contains(endWord))
        	return new ArrayList<>();
        HashMap<String,Integer> dist = new HashMap<>();
        HashMap<String,List<String>> adjNodeList = new HashMap<>();
        List<List<String>> rest = new WordLadders2().getDistance(dist, adjNodeList, adjList, dict, beginWord, endWord);
        System.out.println(rest);
        return rest;
        
        /*
        List<List<String>> rest = getWordsCustomBFS(beginWord, endWord, dict, visited, adjList);
        System.out.println(rest);
        return rest;
        */
       
        /*
        int len = getMinDepthOfWord(beginWord, endWord, dict, adjList);
        System.out.println("lenght----"+len);
        StringBuffer sb = new StringBuffer();
        getWords(beginWord,endWord,dict,visited,adjList,sb,0,len);
        
        
        List<List<String>> ret = new ArrayList<>();
        int minL = Integer.MAX_VALUE;
        for(String str : lst)
        {
        	String[] arr = str.split(",");
        	if(arr.length<=minL)
        	{
        		List<String> addL = Arrays.asList(arr);
            	ret.add(addL);
            	minL = arr.length;
        	}
        	
        }
        System.out.println("result---"+ret);
        return ret;
        */
    }
    
    /**
     * DO a BFS on all the words and two things are important to avoid cycles 
     * First DONT add the same word again back to the queue
     * Second , once a word is added to the queue, make sure its removed from the Dictionary to make sure its NOT added again.
     * Thirdly , the very first word is NOT removed the first time.
     * @param wordN
     * @param end
     * @param dict2
     * @param adjList
     * @return
     */
    public int getMinDepthOfWord(String wordN, String end, HashSet<String> dict2, List<List<Character>> adjList)
    {
    	int minL = Integer.MAX_VALUE;
    	HashMap<String,Boolean> visited = new HashMap<>();
    	HashSet<String> local = new HashSet<>(dict2);
    	int currMin = 0;
    	Queue<String> qu = new LinkedList<>();
    	qu.offer(wordN);
    	boolean wordF = false;
    	while(!qu.isEmpty())
    	{
    		Queue<String> quT = new LinkedList<>();
    		visited.put(qu.peek(), true);
    		currMin++;
    		System.out.println("qu ka size"+qu.size()+"---depth---"+currMin);
    		while(!qu.isEmpty())
    		{
    			String next = qu.poll();
    			
        		List<String> nn = getNbrs(next, adjList,local,visited);
        		for(String str : nn)
        		{
        			if(str.equals(next))
        				continue;
        			if(str.equals(end))
            		{
            			minL = Math.min(currMin, minL);
            			wordF = true;
            			break;
            		
            		}
        			else
        			{
        				quT.offer(str);
        				local.remove(str);
        			}
        			
        				
        		}
        			
        		
    		}
    		if(wordF)
    			break;
    		visited.put(qu.peek(), false);
    		qu = quT;
    	}
    	
    	return minL;
    	
    }
    
    public List<List<String>> getWordsCustomBFS(String wordN, String end, HashSet<String> dict, HashMap<String,Boolean> visited, List<List<Character>> adjList)
    {
    	Queue<Node> qu = new LinkedList<>();
    	List<List<String>> ans = new ArrayList<>();
    	List<String> lstParent = new ArrayList<>();
    	lstParent.add(wordN);
    	Node init = new Node(lstParent,wordN);
    	qu.offer(init);
    	int minL = getMinDepthOfWord(wordN, end, dict, adjList);
    	while(!qu.isEmpty())
    	{
    		Queue<Node> quT = new LinkedList<>();
    		while(!qu.isEmpty())
    		{
    			Node next = qu.poll();
        		List<String> nn = getNbrs(next.child, adjList,dict,visited);
        		for(String str : nn)
        		{
        			List<String> childList = new ArrayList<>(next.parent);
        			childList.add(str);
        			if(childList.size()>minL)
        				continue;
        			Node child = new Node(childList,str);
        			if(str.equals(end))
            		{
        				if(str.equals(next.child))
        					continue;
                        if (childList.size()==minL)
        				{
        					ans.add(childList);
        				}
        				else if(childList.size()<minL)
        				{
        					ans.clear();
        					ans.add(childList);
                            minL = childList.size();
        				}
                        
            			continue;
            		}
        			else
        			{
        				// dict.remove(child.child); this line works fine for depth but NOT For the ladder
        				quT.offer(child);
        			}
        				
        		}
        			
        		
    		}
    		qu = quT;
    	}
    	
    	return ans;
    }
    
    public List<List<String>> getWordsBFS(String wordN, String end, HashSet<String> dict, HashMap<String,Boolean> visited, List<List<Character>> adjList)
    {
    	Queue<String> qu = new LinkedList<>();
    	List<String> lst = new ArrayList<>();
    	List<List<String>> ans = new ArrayList<>();
    	HashMap<String,List<String>> hmp = new HashMap<>();
    	qu.offer(wordN);
    	lst.add(wordN);
    	hmp.put(wordN, lst);
    	while(!qu.isEmpty())
    	{
    		Queue<String> quT = new LinkedList<>();
    		while(!qu.isEmpty())
    		{
    			String next = qu.poll();
    			if(visited.containsKey(next) && visited.get(next))
    				continue;
    			visited.put(next, true);
        		List<String> nn = getNbrs(next, adjList,dict,visited);
        		for(String str : nn)
        		{
        			List<String> parent = hmp.get(next);
        			List<String> child = new ArrayList<>(parent);
        			child.add(str);
        			hmp.put(str, child);
        			//hmp.put(str, hmp.get(next).add(str));
        			if(str.equals(end))
            		{
            			ans.add(hmp.get(str));
            			continue;
            		}
        			else
        				quT.offer(str);
        		}
        			
        		
    		}
    		
    		qu = quT;
    	}
    	
    	return ans;
    }
    
    public List<String> getNbrs(String word,List<List<Character>> adjList , HashSet<String> dict, HashMap<String,Boolean> visited)
    {
    	List<String> ret = new ArrayList<>();
    	
    	for(int i =0;i<word.length();i++)
    	{
    		
    		List<Character> adj = adjList.get(i);
    		for(Character ch : adj)
    		{
    			
    			if(ch!=word.charAt(i))
    			{
    				
    				StringBuffer sb = new StringBuffer(word);
    				String rep = Character.toString(ch);
    				sb.replace(i, i+1, rep);
    				//System.out.println("String produced---"+sb.toString());
    				if(dict.contains(sb.toString()))
    				{
    					if(!(visited.containsKey(sb.toString()) && visited.get(sb.toString())))
    						ret.add(sb.toString());
    				}
    					
    			}
    			else
    				continue;
    		}
    	}
    	
    	return ret;
    }
    
    public void getWords(String wordN, String end, HashSet<String> dict, HashMap<String,Boolean> visited, List<List<Character>> adjList, 
    		StringBuffer sb , int len, int minL)
    {
    	if(!dict.contains(end))
    		return;
    	if(!dict.contains(wordN))
            return;
        if(visited.containsKey(wordN) && visited.get(wordN))
            return;
        if(len > minL)
        	return;
        
    	if(wordN.equals(end))
        {
            sb.append(wordN);
            lst.add(sb.toString());
            return;
        }
        
        len++;
        visited.put(wordN,true);
        //List<Character> lst = adjList.get(index);
        List<String> nbrs = getNbrs(wordN, adjList, dict, visited);
        for(String str : nbrs)
        {
        	if(str.equals(wordN))
        		continue;
        	if((len <=minL))
        	{
        		// dict.remove(str);
        		getWords(str,end,dict,visited,adjList,new StringBuffer(sb).append(wordN+","),len,minL);
        	}
        		
        }
        visited.put(wordN,false);
        /*
        for(char c : lst)
        {
        	if(c==wordN.charAt(index))
        		continue;
            String next = wordN.substring(0,index) + c + wordN.substring(index+1,wordN.length());
            if(!dict.contains(next))
                continue;
            System.out.println("next word-- "+next+"---original--"+wordN);
            for(int i=0 ;i<wordN.length();i++)
            {
                if(i!=index)
                {
                     getWords(next,end,dict,visited,i,adjList,new StringBuffer(sb).append(wordN+","));        
                }
                    
            }
            
        }
        */

           
    }

class Node {
	public String child;
	public List<String> parent = new ArrayList<>();
	
	public Node(List<String> parent, String child)
	{
		this.parent = parent;
		this.child = child;
	}
}
    
    
}
