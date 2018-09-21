package datastructures;

import java.util.Queue;
import java.util.Stack;

/**
 * Addition of elements to a tree. >> Key is setting to the Java object in method like node.setRIghtNode(new BstNode(8))
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1

// Other problems i\nclude , Printing a tree wihtout recursion and Reversing a stack without any Data strucutres.
// SUm of nodes K
// Left View of a Binary tree
 * @author hemant
 *
 */
public class BinarySearchTree {
	
	public static void main(String[] args) {

		Integer[] arr = {10,1,4,40,50};
		BSTNode mainRoot = null;		
		mainRoot = new BSTNode(arr[0]);
		
		for(int i = 1;i<arr.length;i++)
		{
			addToTree(mainRoot,arr[i]);
		}
		
		print(mainRoot);
		//System.out.println(sysOut);

		Stack<BSTNode> stck = new Stack<>();	
		inOrderWithoutRecursion(mainRoot, stck);
		
		Stack<Integer> stack = new Stack();
		int i = 1;
		while (i<6)
		{
			stack.push(i);
			i++;
		}
		reverseStack(stack);
		//
		//boolean gotit = find(mainRoot, 4);
		//System.out.println(gotit);
		
		// Sum of nodes that end up as K
		NodesSumK.caller(mainRoot, 50);
		
		// Left View of a Binary tree printing
		System.out.println("------------------LeftView of a Binary Tree---------------");
		LeftViewOfBT.leftView(mainRoot);
		
		System.out.println("------------------Top K elements of a Binary Tree---------------");
		TopKElementsInTree.getTopK(mainRoot, 5);
		
		System.out.println("------------------Sum of elements in a Binary Tree---------------");
		System.out.println(SumOfAllNodes.getSumOfNodes(mainRoot));
		
		System.out.println("------------------Elements in the path  from Root to the Node found in Stack ---------------");
		AddRootToNodeInStack.printTheStack(mainRoot,50);
		
		System.out.println("-------------------------Average of Levels in a Binary Tree ---------------------------------");
		System.out.println(AverageOfLevels.averageOfLevels(mainRoot).toString());

	}
	
	public static void addToTree(BSTNode rt , Integer val)
	{
		if(rt!=null && val>rt.getValue())
		{
			BSTNode rN = rt.getRightNode();
			if(rN==null)
				rt.setRightNode(new BSTNode(val));
			else
				addToTree(rt.getRightNode(), val);
		}
		else if (rt!=null && val<rt.getValue())
		{
			BSTNode lN = rt.getLeftNode();
			if(lN==null)
				rt.setLeftNode(new BSTNode(val));
			else
				addToTree(rt.getLeftNode(), val);
		}
		
	}
	
	public static void print(BSTNode node)
	{
		/*
		if(node!=null)
		{
			// Pre -Order as in Root , Left and Right
			//return node.getValue()+ "-"+print(node.getLeftNode())+"-"+print(node.getRightNode()) +"-" ;
			// Post-Order Left Right and Root
			return print(node.getLeftNode())+"-"+print(node.getRightNode()) +"-" +node.getValue();	
		}
		*/
		if(node!=null)
		{
			System.out.println(node.getValue());
			print(node.getLeftNode());
			print(node.getRightNode());	
		}
		
	
	}
	
	// reverse a stack without using any other data strucutres
	public static void reverseStack(Stack<Integer> stack)
	{
		if(stack.isEmpty())
			return ;
		
		int tmp = stack.pop();
		reverseStack(stack);
		insertNumFirst(stack, tmp);
		
	}
	
	public static void insertNumFirst(Stack<Integer> stck, Integer i)
	{
		if(stck.isEmpty())
		{
			stck.push(i);
			return;
		}
		
		Integer tmp = stck.pop();
		insertNumFirst(stck, i);
		stck.push(tmp);
	}
	
	// Move to the very left node then one by one move to the right nodes 
	// At each right node , add any exisitng left nodes
	public static void inOrderWithoutRecursion(BSTNode node, Stack<BSTNode> stck)
	{
		//create a queue first
		addToStackToLeft(stck, node);
		
		while(!stck.isEmpty())
		{
			node = stck.pop();
			System.out.println(node.getValue());
			
			addToStackToLeft(stck, node.getRightNode());
		}
	}
	
	public static void addToStackToLeft(Stack<BSTNode> stack, BSTNode node)
	{
		while(node!=null)
		{
			stack.push(node);
			node = node.getLeftNode();
		}
	}
	
	public static boolean find(BSTNode node, Integer val)
	{
		if(node==null)
			return false;
		else
		{
			if(node.getValue()==val)
				return true;
			else if(val>node.getValue())
				return find(node.getRightNode(),val);
			else if(val<node.getValue())
				return find(node.getLeftNode(),val);
			else
				return false;
		}
		
	}
}
