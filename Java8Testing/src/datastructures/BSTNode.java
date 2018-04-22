package datastructures;

public class BSTNode {
	
	private Integer root = null;
	private BSTNode Rnode = null;
	private BSTNode Lnode = null;
	
	public BSTNode(Integer root)
	{
		this.root = root;
	}

	public boolean isGreaterthanRoot(Integer comp)
	{
		if (comp>root)
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
	
	public Integer getRoot()
	{
		return this.root;
	}
	
	// Improve this function to write a traversal of a tree, this is what its trying to do. 
	public void toString(BSTNode n)
	{
		if(n!=null)
		{
			System.out.println("Main node "+ n.getRoot());
			System.out.println("Right element"+n.getRightNode()!=null?n.getRightNode().getRoot():"nothing");
			System.out.println("Left element"+n.getLeftNode()!=null?n.getLeftNode().getRoot():"nothing");
		}
		
		toString(n.getRightNode());
		toString(n.getLeftNode());
	}
}
