package datastructures;
/**
 * The below example also illustrates backtracking process where in the element is searched for in each left node . If its not found then the corresponding
 * right nodes are searched for. 
 * The first element in the stack is the element found and the last one is the very top node of the tree.
 */
import java.util.Stack;

public class AddRootToNodeInStack 
{
	public static boolean gotit = false;
	
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
	
	// This needs to be refined.
	public static Stack<BSTNode> addFromTopToBottom(BSTNode node , int findMe,Stack<BSTNode> stk)
	{
		if(node==null)
			return stk;
		stk.push(node);
		
		if(node.getValue()==findMe)
			gotit = true;
		if(gotit)
			return stk;
		else 
		{
			if(node.getLeftNode()!=null)
				addFromTopToBottom(node.getLeftNode(), findMe, stk);
			if(!gotit)
				stk.pop();
			if(node.getRightNode()!=null)
			addFromTopToBottom(node.getRightNode(), findMe, stk);
			if(!gotit)
				stk.pop();
		}
		
		return stk;
		
	}
	
	public static void printTheStack(BSTNode node , int findMe)
	{
		Stack<BSTNode> stk = addToStack(node, findMe);
		
		while (stk!=null && !stk.isEmpty())
			System.out.println(stk.pop().getValue());
		
		Stack<BSTNode> stkT = new Stack<>();
		addFromTopToBottom(node, findMe, stkT);
		System.out.println("------------------Elements in the path with Root first in Stack ------ ---------------");
		while (stkT!=null && !stkT.isEmpty())
			System.out.println(stkT.pop().getValue());
		
		
	}

}
