package algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistFromAllBuildings 
{
    int max = Integer.MAX_VALUE;
    public int shortestDistance(int[][] grid) 
    {
        // write a bfs for each building that is 1 to populate a 2d distance array and keep updating it for every building.
        int len = grid.length;
        int ht = grid[0].length;
        int[][] dist = new int[len][ht];
         int[][] build = new int[len][ht];
        int total = 0;
        
        for(int i =0;i<len;i++)
        {
            for(int j=0;j<ht;j++)
            {
                if(grid[i][j]==1)
                {
                    total++;
                    int[][] visited = new int[len][ht];
                    bfs(grid,i,j,len,ht,dist,0,visited,build);
                }
                    
            }
        }
        for(int i =0;i<len;i++)
            for(int j =0;j<ht;j++)
            {
                if(grid[i][j]==0 && build[i][j]==total)
                    max = Math.min(max,dist[i][j]);
            }
        
        return max==Integer.MAX_VALUE?-1:max;
    }
    
    public void bfs(int[][] grid, int i , int j ,int len, int ht, int[][] dist, int distance,int[][] visited,int[][] build)
    {
        Queue<int[]> qu = new LinkedList<>();
        int[] tmp = {i,j};
        //qu.offer(tmp);
        int[] rt = {i,j+1};
        int[] bt = {i+1,j};
        int[] lt = {i,j-1};
        int[] upt = {i-1,j};
        qu.offer(rt);
        qu.offer(bt);
        qu.offer(lt);
        qu.offer(upt);
        distance++;
        // to counter for the base condition , another version is to edit the continue clause below and check if its ==0 then only update values etc.
        while(!qu.isEmpty())
        {
         //System.out.println("in the queue--"+qu);
            Queue<int[]> inter = new LinkedList<>();
            while(!qu.isEmpty())
            {
                int[] dt = qu.poll();
            int x = dt[0];
            int y = dt[1];
            if(x<0 || x>=len || y<0 || y>=ht || grid[x][y]!=0 || visited[x][y]!=0)
                continue;
            
            visited[x][y]=1;
            build[x][y] +=1; 
            //
            //System.out.println("distance and max--"+max+"---"+distance);
            dist[x][y] += distance;
            //print(dist);
            //System.out.println("");


            int[] right = {x,y+1};
            int[] bottom = {x+1,y};
            int[] left = {x,y-1};
            int[] up = {x-1,y};
            inter.offer(right);
            inter.offer(bottom);
            inter.offer(left);
            inter.offer(up);
            }
            distance++;
            //max = Math.max(max,distance);
            qu = inter;
        }
        //print(dist);
           // System.out.println("");
        
    }
    public void print(int[][] dist)
    {
        for(int[] row :dist)
        {
            for(int a : row)
            {
                    System.out.print(a);
            }
            System.out.println("");
        }
            
            
    }

}
