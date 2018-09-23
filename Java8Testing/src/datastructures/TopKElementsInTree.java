package datastructures;

import java.util.Stack;

public class TopKElementsInTree 
{
	public static int K = 0;
	public static void getTopK(BSTNode node, int k)
	{
		Stack<BSTNode> stk = new Stack<>();
		if(node!=null)
			stk.push(node);
		if(node.getRightNode()!=null)
			getAllRightNodes(stk,node);
		
		while(!stk.isEmpty() && k>0)
		{
			BSTNode n = stk.pop();
			//getAllRightNodes(stk, n);
			k--;
			System.out.println(n.getValue());
			if(n.getLeftNode()!=null)
			{
				stk.push(n.getLeftNode());
				getAllRightNodes(stk, n.getLeftNode());
			}
				
		}
	}
	
	public static void getAllRightNodes(Stack<BSTNode> stk , BSTNode node)
	{
		if(node==null)
			return;
		
		if(node.getRightNode()!=null)
		{
			stk.push(node.getRightNode());
			getAllRightNodes(stk, node.getRightNode());
		}
			
	}
	
	// This is an example of Reverse Post in-order traversal , like Right goes first then middle and then finally left.
	public static void getTopKUsingRecursion(BSTNode node,int p)
	{
		if(node==null||K>p)
			return;
		getTopKUsingRecursion(node.getRightNode(),p);
		K++;
		if(K<=p)
		{
			System.out.println(node.getValue());	
		}
		getTopKUsingRecursion(node.getLeftNode(),p);
		
	}
	
	public static void getBottomKUsingRecursion(BSTNode node,int p)
	{
		if(node==null||K>p)
			return;
		getBottomKUsingRecursion(node.getLeftNode(),p);
		K++;
		if(K<=p)
		{
			System.out.println(node.getValue());	
		}
		getBottomKUsingRecursion(node.getRightNode(),p);
		
	}
}
