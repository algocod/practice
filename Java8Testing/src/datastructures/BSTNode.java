package datastructures;

public class BSTNode {
	
	private Integer value = null;
	private BSTNode Rnode = null;
	private BSTNode Lnode = null;
	
	public boolean isGreaterthanRoot(Integer comp)
	{
		if (comp>value)
			return true;
		else 
			return false;
					
	}
	
	public BSTNode getRightNode()
	{
		return Rnode;
	}
	
	public BSTNode getLeftNode()
	{
		return Lnode;
	}
	
	public void setRightNode(BSTNode rn)
	{
		this.Rnode = rn;
	}
	
	public void  setLeftNode(BSTNode ln)
	{
		this.Lnode = ln;
	}
	
	public Integer getValue()
	{
		return this.value;
	}

	public BSTNode(Integer root)
	{
		this.value = root;
	}

	
	// Improve this function to write a traversal of a tree, this is what its trying to do. 

	public String print(BSTNode node)
	{
		if(node==null)
			return "";
		else
		{
			// Left Traversal and Right traversal is below
			//return print(node.getLeftNode()) +"--"+ node.getValue() + "--"+print(node.getRightNode());
			return print(node.getRightNode()) +"--"+ node.getValue() + "--"+print(node.getLeftNode());
		}
		
	}
	
}
