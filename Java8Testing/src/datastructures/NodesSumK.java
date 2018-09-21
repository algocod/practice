package datastructures;

import java.util.ArrayList;
import java.util.Stack;

/**
 * this class prints out from a root to leaf perspective if sum equals to K.
 * This is actually solution to the problem that is from Top root to any leaf in the path that sums to K.
 * Intermediatory root to leaves is also solved below.
 * @author hemant
 *
 */
public class NodesSumK 
{
	
	public static void caller(BSTNode node , int k)
	{
		Stack<Integer> stk = new Stack<>();
		traverseTree(node, k, stk, 0);
	}
	
	public static void traverseTree(BSTNode node, int k, Stack<Integer> stk , int interSum)
	{
		if(node==null)
			return;
		
		stk.push(node.getValue());
		interSum+=node.getValue();
		int sum = stk.stream().map(node::getLValue).mapToInt(Integer::intValue).sum();
		//int sum2 = stk.stream().mapToInt(i->i).sum();
		// three ways to sum of nodes.
		
		if (interSum==k)
		{
			// print out the stack
			System.out.println("-----------------Stack values for K SUM from TOP TO BOTTOm--------------------");
			stk.stream().forEach(System.out::println);
		}
		int increSum = 0;
		Stack<Integer> stkTmp = new Stack<>();
		for(int i = stk.size()-1; i>=0;i--)
		{
			increSum +=stk.get(i);
			stkTmp.push(stk.get(i));
			if (increSum==k)
			{
				System.out.println("-----------------Stack values for K SUM from Bottom To  Top-------------------");
				stkTmp.stream().forEach(System.out::println);
				
				break;
			}
		}
		
	
		
		traverseTree(node.getLeftNode(), k ,stk, interSum);
		traverseTree(node.getRightNode(), k,stk, interSum);
		// stk.pop represents the behavior of the recursive function when the control moves to one level up . The stack is just being popeed
		// to show that the control is now at a level up. 
		interSum-=node.getValue();
		stk.pop();
		
	}

}
