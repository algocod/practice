package datastructures;

/**
 * Addition of elements to a tree. >> Key is setting to the Java object in method like node.setRIghtNode(new BstNode(8))
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
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
		
		String sysOut = print(mainRoot);
		System.out.println(sysOut);

		boolean gotit = find(mainRoot, 4);
		System.out.println(gotit);
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
	
	public static String print(BSTNode node)
	{
		if(node==null)
			return "";
		else
		{
			// Pre -Order as in Root , Left and Right
			//return node.getValue()+ "-"+print(node.getLeftNode())+"-"+print(node.getRightNode()) +"-" ;
			// Post-Order Left Right and Root
			return print(node.getLeftNode())+"-"+print(node.getRightNode()) +"-" +node.getValue();
		}
	}
	
	public static int getElementAtIndex(BSTNode node, int index, int starting)
	{
		//try entering this into a stack and then pop it out.
		/*
		if(node!=null && starting==index)
		{
			return node.getValue();
		}
		else if (node!=null)
		{
			starting++;
			getElementAtIndex(node.getLeftNode(), index, starting) 
			
		}
		*/
		
		return 0;
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
