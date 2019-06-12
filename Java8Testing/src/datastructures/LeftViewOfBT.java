package datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Amended the right view of a tree solution to fix the left view one. This solution is again pre-order where root val is stored based on whether its left
 * most member at that level hence the check of a level. The traversal starts with left and then right hence no need to make check on left or right nodes.
 * @author hemant
 *
 */
public class LeftViewOfBT 
{
	
	public List<Integer> ret = new ArrayList<>();
    public HashSet<Integer> chk = new HashSet<>();
    public List<Integer> rightSideView(TreeNode root)
    {
        getRNodes(root,0);
        return ret;
    }
    
    public void getRNodes(TreeNode root, int ht)
    {
        if(root==null)
            return;
        
        if(!chk.contains(ht))
        {
            ret.add(root.val);
            chk.add(ht);
        }
        
        getRNodes(root.left,ht+1); // Although the method name says RNode , we are passing the left node first hence becomes left view.
        getRNodes(root.right,ht+1);
        
    }

}
