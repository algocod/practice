package datastructures;

public class InvertBinaryTree 
{
	
    public void invertHelper(BSTNode root)
    {
        if(root==null)
            return;
        
        BSTNode temp = root.getLeftNode();
        root.setLeftNode(root.getRightNode());
        root.setRightNode(temp);
        
        invertHelper(root.getLeftNode());
        invertHelper(root.getRightNode());
        
    }

}
