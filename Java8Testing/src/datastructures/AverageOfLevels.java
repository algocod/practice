package datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.Queue;
import java.util.stream.Stream;

public class AverageOfLevels 
{
	// BFS has same time output as DFS below hence both solutions are good.
	 public static List<Double> averageOfLevels(BSTNode root) 
	    {
	        Queue<BSTNode> q = new ArrayDeque<>();
	        q.add(root);
	        List<Double>  lstAvg = new ArrayList<>();
	        while(!q.isEmpty())
	        {
	        	Queue<BSTNode> temp = new ArrayDeque<>();
	        	int sum = 0;
	        	double k=0;
	        	while(!q.isEmpty())
	        	{
	        		BSTNode bst = q.poll();
		            if(bst!=null)
		            {
		                sum = sum + (bst.getValue());
		                k++;

		                if(bst.getLeftNode()!=null)
		                		temp.add(bst.getLeftNode());
		                if(bst.getRightNode()!=null)
		                	temp.add(bst.getRightNode());

		            }
	
	        	}
	        	
                double avg = sum/k;
                lstAvg.add(avg);
                q = temp;
	        }
	        return lstAvg;
	    }

	 
	 // store the nums at each height in an arrayList with height as key, the streams make it slow hence fast than 5% of submissions
	 public static List<Double> averageOfLevels(TreeNode root) 
     {
         List<Double> lst = new ArrayList<>();
         HashMap<Integer,ArrayList<Integer>> hmp = new HashMap<>();
         helperAverage(root,hmp,0);
         for(Entry<Integer, ArrayList<Integer>> entry : hmp.entrySet())
         {
             List<Integer> ret = entry.getValue();
             Stream<Integer> stm = ret.stream();
             OptionalDouble db = stm.mapToInt(i -> i).average();
             if(db.isPresent())
                 lst.add(db.getAsDouble());
         }
         
         return lst;
     }
     public static void helperAverage(TreeNode root,HashMap<Integer,ArrayList<Integer>> hmp, int hgt)
     {
         if(root==null)
             return;
         if(hmp.get(hgt)==null)
         {
             hmp.put(hgt,new ArrayList<Integer>());
         }
         
         ArrayList<Integer> l = hmp.get(hgt);
         l.add(root.val);
         hmp.put(hgt,l);
         helperAverage(root.left,hmp,hgt+1);
         helperAverage(root.right,hmp,hgt+1);
         
     }
     // optimize the operations, the below one is fast than 91% of submissions.
     public static List<Double> averageOfLevelsSC(TreeNode root) 
     {
         List<Double> lst = new ArrayList<>();
         HashMap<Integer,SumCount> hmp = new HashMap<>();
         helperAverageSC(root,hmp,0);
         for(Entry<Integer, SumCount> entry : hmp.entrySet())
         {
             SumCount ret = entry.getValue();
             lst.add(ret.sum/ret.count);
         }
         
         return lst;
     }
     public static void helperAverageSC(TreeNode root,HashMap<Integer,SumCount> hmp, int hgt)
     {
         if(root==null)
             return;
         if(hmp.get(hgt)==null)
         {
             hmp.put(hgt,new SumCount());
         }
         
         SumCount sc = hmp.get(hgt);
         sc.sum = sc.sum + (root.val);
         sc.count = sc.count +1 ;
         helperAverageSC(root.left,hmp,hgt+1);
         helperAverageSC(root.right,hmp,hgt+1);
         
     }
     
     
     static class SumCount
     {
    	 int sum;
    	 double count;
     }
	 
}
