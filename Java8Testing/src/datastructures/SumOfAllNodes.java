package datastructures;

public class SumOfAllNodes 
{
	
	public static int getSumOfNodes(BSTNode node)
	{
		if(node==null)
			return 0;
		return getSumOfNodes(node.getLeftNode()) + node.getValue() + getSumOfNodes(node.getRightNode());
	}
	
	/*
	public static BSTNode findNode(BSTNode node, int totalSum)
	{
		int lSum = node.getLeftNode()!=null?getSumOfNodes(node.getLeftNode()):0;
		int rSum = node.getRightNode()!=null?getSumOfNodes(node.getRightNode()):0;
		
		if(lSum == totalSum-lSum)
			return node.getLeftNode();
		if(rSum == totalSum-rSum)
			return node.getRightNode();
		
		if(lSum> totalSum-lSum)
			return findNode(node.getLeftNode(),totalSum-lSum+node.getLeftNode().getValue());
		if(rSum > totalSum-rSum)
			return findNode(node.getRightNode(),totalSum-lSum+node.getRightNode().getValue());
		
	}
*/
}
