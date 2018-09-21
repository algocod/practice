package datastructures;

import java.util.Stack;

public class TopKElementsInTree 
{
	
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

}
