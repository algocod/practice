package datastructures;

public class LeftViewOfBT 
{
	
	public static void leftView(BSTNode bn)
	{
		if(bn==null)
			return;
		else
			System.out.println(bn.getValue());
		
		// Keep traversing the left tree and if NO LT then go for Right tree
		BSTNode bch = null;
		if(bn.getLeftNode()!=null)
			bch = bn.getLeftNode();
		else if(bn.getRightNode()!=null)
			bch = bn.getRightNode();
		
		leftView(bch);
		
	}

}
