package datastructures;

public class DiameterOfBinaryTree 
{
	public static int maxL= 1;
    
	// The caller method below where maxL is set to 1 and return is -1.
    public int diameterOfBinaryTree(TreeNode root) {
        
        dHelper(root);
        return maxL-1;
    }
    
    public int dHelper(TreeNode node)
    {
        int currL= 0;
		if(node==null)
			return 0;
		
		int leftL = dHelper(node.left);
		int rightL= dHelper(node.right); 
		currL =  leftL+rightL +1;
		if (currL>maxL)
		{
			maxL = currL;
		}
			
		return Math.max(leftL, rightL) +1 ;

    }
	
}
