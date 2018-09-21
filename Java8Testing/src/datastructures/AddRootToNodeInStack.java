package datastructures;

import java.util.Stack;

public class AddRootToNodeInStack 
{
	
	public static Stack<BSTNode>  addToStack(BSTNode root, int findMe)
	{
		if(root==null)
			return null;
		if(root.getValue()==findMe)
		{
			Stack<BSTNode> stk = new Stack<>();
			stk.push(root);
			return stk;
		}
		
		Stack<BSTNode> leftPath = addToStack(root.getLeftNode(), findMe);
		if(leftPath!=null)
		{
			leftPath.push(root);
			return leftPath;
		}
		
		Stack<BSTNode> rightPath = addToStack(root.getRightNode(), findMe);
		if(rightPath!=null)
		{
			rightPath.push(root);
		}
			
		return rightPath;
	}
	
	public static void printTheStack(BSTNode node , int findMe)
	{
		Stack<BSTNode> stk = addToStack(node, findMe);
		
		while (stk!=null && !stk.isEmpty())
			System.out.println(stk.pop().getValue());
	}

}
