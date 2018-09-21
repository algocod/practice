package datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels 
{
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

}
