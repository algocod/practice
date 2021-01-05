import java.util.*;
// This problem is about ca
public class SimilarPaths{
    public HashMap<String,List<String>> adj = null;

    public int targetLen = 0;
    public  HashMap<String,Integer> csmap = new HashMap<>();
    public String[] tar = null;
    public  List<String> ansCost = new LinkedList<>();
    public int minCost = Integer.MAX_VALUE;
    public HashMap<String,Integer> imap = new HashMap<>();


    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {

        tar = targetPath;
        targetLen = targetPath.length;
        adj = new HashMap<>();

        for(int i =0;i<names.length;i++){
            imap.put(names[i],i);
        }

        for(int[] edge : roads)
        {
            String from = names[edge[0]];
            String To = names[edge[1]];

            adj.computeIfAbsent(from , k -> new LinkedList<String>()).add(To);
            adj.computeIfAbsent(To , k -> new LinkedList<String>()).add(from);
        }

        String minStart = null;
        int startC = Integer.MAX_VALUE;
        for(int i=0;i<names.length;i++){

            int currc = minCost(names[i],0);
            if(currc<startC){
                minStart = names[i];
                startC=currc;
            }
        }
        List<Integer> local = new LinkedList<>();
        minCostPath(local,minStart,0);
        return local;

    }

    public int minCost( String city, int i){

        int cost = city.equals(tar[i])?0:1;
        String mpk = city+"_"+i;
        if(csmap.containsKey(mpk)) return csmap.get(mpk);
        if(i==targetLen-1) {
            csmap.put(mpk,cost);
            return cost;
        }




        int minc = Integer.MAX_VALUE;
        for(String c : adj.get(city)){
            int nc = minCost(c,i+1);
            minc = Math.min(nc,minc);
        }

        cost+=minc;
        csmap.put(mpk,cost);
        return cost;
    }


    public void minCostPath(List<Integer> arl , String city, int i){

        arl.add(imap.get(city));

        if(i==targetLen-1){
            return ;
        }

        String next = null;
        int nx = Integer.MAX_VALUE;
        System.out.println(csmap);
        for(String c : adj.get(city)){
            String nk = c+"_"+(i+1);
            System.out.println(nk);
            if (csmap.getOrDefault(nk,Integer.MAX_VALUE)<nx){
                next = c;
                nx = csmap.getOrDefault(nk,Integer.MAX_VALUE);
            }
        }
        if(next!=null)
            minCostPath(arl,next,i+1);

        return ;
    }
    public static void main(String[] args){
        System.out.println("Hello World-------");
        SimilarPaths sp = new SimilarPaths();
        int[][] roads = {{0,2},{0,3},{1,2},{1,3},{1,4},{2,4}};
        int n = roads.length;
        String[] names = {"ATL","PEK","LAX","DXB","HND"};
        String[] target = {"ATL","DXB","HND","LAX"};
        System.out.println(sp.mostSimilar(n,roads,names,target));
    }

}