package datastructures;


public class IsBinaryTree {
	
public boolean isValidBSTHelper(BSTNode root, Integer upperL, Integer lowerL) {
        
        if(lowerL!=null&& root.getValue()<=lowerL)
            return false;
        if(upperL!=null&& root.getValue()>=upperL)
            return false;
        
            boolean leftVal = true;
            boolean rightVal = true;
        
            if(root.getLeftNode()!=null)
                leftVal = isValidBSTHelper(root.getLeftNode(),root.getValue(),lowerL);
            
            if(root.getRightNode()!=null && leftVal)
                rightVal = isValidBSTHelper(root.getRightNode(),upperL,root.getValue());
        
            return leftVal && rightVal;
                    
        
    }
    
    public boolean isValidBST(BSTNode root)
    {
        if(root==null)
            return true;
        else 
            return  isValidBSTHelper(root,null,null);
    }
}

