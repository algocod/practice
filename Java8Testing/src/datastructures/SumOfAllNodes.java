package datastructures;

public class SumOfAllNodes 
{
	
	public static int getSumOfNodes(BSTNode node)
	{
		if(node==null)
			return 0;
		return getSumOfNodes(node.getLeftNode()) + node.getValue() + getSumOfNodes(node.getRightNode());
	}

}
