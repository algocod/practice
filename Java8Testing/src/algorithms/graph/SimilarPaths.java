package algorithms.graph;
import java.util.*;

public class SimilarPaths {
    public HashMap<String,List<String>> adj = null;
    public HashMap<String,List<List<String>>> dp  = new HashMap<>();
    public int targetLen = 0;
    public  List<Node> ans = new LinkedList<>();
    public  List<List<String>> pathList = new LinkedList<>();
    public int minD = Integer.MAX_VALUE;
    public  HashMap<String,Integer> trgt = new HashMap<>();
    
public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        
        Queue<Node> q = new LinkedList<>();
       
        targetLen = targetPath.length;
        System.out.println("1");
       
        for(String str : targetPath)
            trgt.put(str,trgt.getOrDefault(str,0)+1);
        System.out.println("2");
        adj = new HashMap<>();
        HashMap<String,Integer> imap = new HashMap<>();
        for(int i =0;i<names.length;i++){
            imap.put(names[i],i);
        }
        System.out.println("3");
        
        if(!imap.containsKey(targetPath[0]) && !imap.containsKey(targetPath[1])){
            int i = roads[0][0];
            int j = roads[0][1];
             List<Integer> ret = new LinkedList<>();
            while(ret.size()<targetLen){
               ret.add(i);
               ret.add(j);
            }
            if(ret.size()>targetLen){
                ret.remove(ret.size()-1);
            }
            return ret;
        }
        
        System.out.println("4");
        for(int[] edge : roads)
        {
            String from = names[edge[0]];
            String To = names[edge[1]];
            
            adj.computeIfAbsent(from , k -> new LinkedList<String>()).add(To);
            adj.computeIfAbsent(To , k -> new LinkedList<String>()).add(from);
        }
        System.out.println("5");
        HashMap<String,Integer> cln = (HashMap<String,Integer>)trgt.clone();
        String endCity = targetPath[targetLen-1];
        String strtc = targetPath[0];
        Node first = new Node(cln);
        String start = imap.containsKey(endCity) && imap.containsKey(strtc) ? strtc
            : !imap.containsKey(strtc)?endCity:strtc;
        first.addCity(start);
        
       
        dfs(first,endCity,targetLen-1);
        /*
        System.out.println("6");
        q.offer(first);
        while(!q.isEmpty()){
            Queue<Node> tmp  = new LinkedList<>();
             while(!q.isEmpty()){
                Node curr = q.poll();
                List<String> currl = curr.lst;
                 System.out.println("Current List size "+currl.size());
                  System.out.println("Target List size "+targetLen);
                 System.out.println("String version of list"+currl.toString());
                if(currl.size()==targetLen) {
                    System.out.println("Last City "+currl.get(currl.size()-1));
                    System.out.println("Desti City "+endCity);
                    
                    if(currl.get(currl.size()-1).equals(endCity))
                        ans.add(curr);
                    else
                        continue;
                }
                 else if(currl.size()>targetLen)
                     continue;
                 String currc = currl.get(currl.size()-1);
                 for(String nxt : adj.get(currc)){
                     
                    Node next = new Node((HashMap<String,Integer>)trgt.clone());
                     next.lst.addAll(currl);
                     next.addCity(nxt);
                     tmp.add(next);
                     System.out.println("8");
                 }
                 
             }
            System.out.println("9");
            q = tmp;
        }
        
        Collections.sort(ans , (a,b) -> a.mind-b.mind);
        */
         List<Integer> ret = new LinkedList<>();
        if(pathList.size()>0)
        {
            List<String> top = pathList.get(0);
            for(String cities : top){
                ret.add(imap.get(cities));

            }
        }
        

        return ret;
    }
    
    public List<List<String>>  dfs(Node curr, String endCity , int rem){
        List<List<String>> ret = new ArrayList<>(); 
        List<String> currl = curr.lst;
        String currcity = currl.get(currl.size()-1);
        if(rem <0) return ret;
        if(rem==0){
                   System.out.println("Current List size "+currl.size());
                 System.out.println("String version of list"+currl.toString());
            if(endCity.equals(currcity))
            {
                if(curr.mind>minD) return ret;
                //pathList.clear();
                pathList.add(curr.lst);
                minD = curr.mind;
                List<String> dest = new ArrayList<>();
                dest.add(endCity);
                ret.add(dest);
                return ret;
            }
            else return ret;
        }
        String key = currcity+"_"+rem;
        //if(dp.containsKey(key)) return dp.get(key);
        List<List<String>> dplist  = new ArrayList<>(); 
        for(String nxt : adj.get(currcity)){
            Node next = new Node((HashMap<String,Integer>)trgt.clone());
             next.lst.addAll(curr.lst);
             next.addCity(nxt);
             List<List<String>> tmp = dfs(next,endCity,rem-1);
            if(tmp.size()>0){
                for(List<String> ls : tmp){
                    ls.add(0,currcity);
                    dplist.add(ls);
                }
            }
         }
       // dp.put(key,dplist);
        return ret;
    }
    
    public class Node{
    
        public List<String> lst = new ArrayList<>();
        public HashMap<String,Integer> minEd = null;
        public int mind =0 ;
        
        public Node (HashMap<String,Integer> target){
      
        this.minEd = target;
        for(int a : minEd.values())
            mind +=a;
        }
        
        public Node (){
        }
        
        public void addCity(String city){
             this.lst.add(city); 
            if(minEd.containsKey(city)){
                minEd.put(city,minEd.get(city)-1);
                if(minEd.get(city)==0)
                    minEd.remove(city);
                mind--;
            }
            else
                mind++;
        }
        
    }

	public static void main(String[] args) {
		/*
		int[][] roads = {{0,1},{1,2},{2,3},{3,4},{4,5}};
		String[] cities = {"ATL","PEK","LAX","ATL","DXB","HND"};
		String[] target = {"ATL","DXB","HND","DXB","ATL","LAX","PEK"};
		*/
		int[][] roads = {{0,1},{1,6},{3,6},{2,3},{2,4},{4,5},{6,5},{6,7},{8,7},{8,12},{8,9},{10,9},{12,11},{12,9},{16,15},{15,14},{14,13},{14,19},{19,13},{20,19},{21,19},{22,19},{23,19},{24,19},{13,17},{17,18},{13,6},{18,12}};
				String[] cities =	{"ICN","IKT","ATH","TBS","TLV","LCA","DME","AUH","CGK","DPS","KUL","BKK","SIN","LED","SVO","BEG","TIV","MSQ","PEK","PRG","DUB","MXP","ORY","CRL","AMS"};
				String[] target = 		{"AXX","TBS","DME"};
		SimilarPaths sp = new SimilarPaths();
		sp.mostSimilar(0, roads, cities, target);
		System.out.println(sp.pathList);
	}

}
