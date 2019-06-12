package datastructures;

/**
 * This is a Pre-Order traversal of a tree that is NODE then LEFT and RIGHT.
 * @author hemant
 *
 */
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
