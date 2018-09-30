package datastructures;

public class DiameterOfBinaryTree 
{
	public static int maxL= 0;

	public static int getDiameter(BSTNode node)
	{
		int currL= 0;
		if(node==null)
			return 0;
		
		int leftL = getDiameter(node.getLeftNode());
		int rightL= getDiameter(node.getRightNode()); 
		currL =  leftL+rightL +1;
		if (currL>maxL)
		{
			maxL = currL;
		}
			
		
		return Math.max(leftL, rightL) +1;
	}
	
}
