package datastructures;

public class MaxDepthOfTree {

    public int hmax = 0;
    /**
     * THe below method gets the max post visiting nodes.
     * @param root
     * @return
     */
    public int maxDep(TreeNode root) 
    {
        if(root==null)
            return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left,right) + 1;
    }
    
    public int maxDepth(TreeNode root) 
    {
        if(root==null)
            return 0;
        
        dHelp(root,0);
        return hmax;
    }
    
    /**
     * The below method gets height before visiting any further.
     * @param root
     * @param ht
     */
    public void dHelp(TreeNode root, int ht)
    {
        if(root==null)
            return;
        
        ht = ht+1;
        hmax = Math.max(ht,hmax);
        dHelp(root.left,ht);
        dHelp(root.right,ht);
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
